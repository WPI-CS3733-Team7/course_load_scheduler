package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.action.SendClickAccountTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.event.SendClickAccountTabEvent;
import org.dselent.course_load_scheduler.client.event.SendClickScheduleTabEvent;
import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import org.dselent.course_load_scheduler.client.view.MainView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.TabBar.Tab;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class MainViewImpl extends BaseViewImpl<MainPresenter> implements MainView
{

	private static MainViewImplUiBinder uiBinder = GWT.create(MainViewImplUiBinder.class);

	@UiField VerticalPanel mainPanel;
	@UiField Button logoutButton;
	@UiField SimplePanel schedulePanel;
	@UiField SimplePanel requestPanel;
	@UiField SimplePanel accountPanel;
	@UiField TabLayoutPanel tabPanel;

	interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
	}

	public MainViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(MainPresenter presenter)
	{
		this.presenter = presenter;
	}


	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}


	@Override
	public HasWidgets getViewRootPanel() {
		return mainPanel;
	}
	
	@UiHandler("logoutButton")
	void onLogoutButtonClicked(ClickEvent evt)
	{
		presenter.logout();
	}

	@Override
	public Button getLogoutButton()
	{
		return logoutButton;
	}

	@Override
	public void showErrorMessages(String errorMessages) {
		Window.alert(errorMessages);
	}

	@Override
	public HasWidgets getSchedulePanel() {
		return schedulePanel;
	}

	@Override
	public HasWidgets getRequestPanel() {
		// TODO Auto-generated method stub
		return requestPanel;
	}

	@Override
	public HasWidgets getAccountPanel() {
		// TODO Auto-generated method stub
		return accountPanel;
	}
	
	@UiHandler("tabPanel")
	void onTabClicked(BeforeSelectionEvent<Integer> evt)
	{ 
		presenter.onTabClicked(evt.getItem());
	}
}
