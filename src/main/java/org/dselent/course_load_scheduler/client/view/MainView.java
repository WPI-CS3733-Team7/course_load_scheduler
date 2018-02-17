package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import com.google.gwt.user.client.ui.Button;

public interface MainView extends BaseView<MainPresenter>
{
	Button getLogoutButton();
	void showErrorMessages(String errorMessages);
}