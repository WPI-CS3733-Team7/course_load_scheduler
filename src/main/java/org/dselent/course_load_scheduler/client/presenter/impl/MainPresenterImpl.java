package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SendLogoutAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendDisplayMessageEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.event_handler.SendDisplayMessageEventHandler;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.MainView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class MainPresenterImpl extends BasePresenterImpl implements MainPresenter, SendDisplayMessageEventHandler
{
	private IndexPresenter parentPresenter;
	private MainView view;
	
	@Inject
	public MainPresenterImpl(IndexPresenter parentPresenter, MainView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
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
		
		registration = eventBus.addHandler(SendDisplayMessageEvent.TYPE, this);
		eventBusRegistration.put(SendDisplayMessageEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
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
			
		SendLogoutAction sla = new SendLogoutAction();
		SendLogoutEvent sle = new SendLogoutEvent(sla);
		eventBus.fireEvent(sle);	
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onSendDisplayMessage(SendDisplayMessageEvent evt) {
		view.showErrorMessages(evt.getAction().getMessage());
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
}
