package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import org.dselent.course_load_scheduler.client.view.MainView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainViewImpl extends BaseViewImpl<MainPresenter> implements MainView
{

	private static MainViewImplUiBinder uiBinder = GWT.create(MainViewImplUiBinder.class);

	@UiField VerticalPanel mainPanel;
	@UiField Button logoutButton;

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
}