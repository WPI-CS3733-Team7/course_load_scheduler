package org.dselent.course_load_scheduler.client.presenter.impl;

import javax.swing.text.View;

import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.SendClickAccountTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.action.SendLogoutAction;
import org.dselent.course_load_scheduler.client.event.InvalidCreateCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidCreateInstructorEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendClickAccountTabEvent;
import org.dselent.course_load_scheduler.client.event.SendClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.event.SendClickScheduleTabEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.MainView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class MainPresenterImpl extends BasePresenterImpl implements MainPresenter
{
	private IndexPresenter parentPresenter;
	private MainView view;
	private GlobalData globalData;
	
	@Inject
	public MainPresenterImpl(IndexPresenter parentPresenter, MainView view, GlobalData globalData)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		this.globalData = globalData;
		view.setPresenter(this);
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(ReceiveLoginEvent.TYPE, this);
		eventBusRegistration.put(ReceiveLoginEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	@Override
	public GlobalData getGlobalData() 
	{
		return globalData;
	}

	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}

	@Override
	public void logout()
	{
		parentPresenter.showLoadScreen();
			
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendLogoutAction sla = new SendLogoutAction();
		SendLogoutEvent sle = new SendLogoutEvent(sla, container);
		eventBus.fireEvent(sle);	
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasWidgets getSchedulePanel() {
		return view.getSchedulePanel();
	}

	@Override
	public HasWidgets getRequestPanel() {
		return view.getRequestPanel();
	}

	@Override
	public HasWidgets getAccountPanel() {
		return view.getAccountPanel();
	}

	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt)
	{
		ReceiveLoginAction action = evt.getAction();
		globalData.setRole(action.getUserRole());
		
		if (globalData.getRole() == "USER") {
			
		}
		parentPresenter.hideLoadScreen();
		this.go(parentPresenter.getView().getViewRootPanel());
	}
	
	@Override
	public void onTabClicked(Integer index)
	{
		String role = globalData.getRole();
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		if (role == "ADMIN" || role == "LINKED USER") {
			switch (index)
			{
			case 0: 
				SendClickScheduleTabAction scheduleAction = new SendClickScheduleTabAction(globalData.getUserId());
				SendClickScheduleTabEvent scheduleEvent = new SendClickScheduleTabEvent(scheduleAction, container);
				eventBus.fireEvent(scheduleEvent);
				break;
			case 1: 
				SendClickRequestTabAction requestAction = new SendClickRequestTabAction(globalData.getUserId());
				SendClickRequestTabEvent requestEvent = new SendClickRequestTabEvent(requestAction, container);
				eventBus.fireEvent(requestEvent);
				break;
			case 2:
				SendClickAccountTabAction accountAction = new SendClickAccountTabAction(globalData.getUserId());
				SendClickAccountTabEvent  accountEvent = new SendClickAccountTabEvent(accountAction, container);
				eventBus.fireEvent(accountEvent);
				break;
			}
		}
	}
}
