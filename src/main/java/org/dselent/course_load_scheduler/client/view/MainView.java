package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public interface MainView extends BaseView<MainPresenter>
{
	Button getLogoutButton();
	void showErrorMessages(String errorMessages);
	HasWidgets getSchedulePanel();
	HasWidgets getRequestPanel();
	HasWidgets getAccountPanel();
	TabLayoutPanel getTabPanel();
}