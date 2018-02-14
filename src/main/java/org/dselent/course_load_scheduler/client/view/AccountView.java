package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AccountPresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface AccountView extends BaseView<AccountPresenter>{
	TextBox getNameTextBox();
	void setNameTextBox(TextBox nameTextBox);
	TextBox getUsernameTextBox();
	void setUsernameTextBox(TextBox usernameTextBox);
	TextBox getAccountStateTextBox();
	void setAccountStateTextBox(TextBox accountStateTextBox);
	TextBox getEmailTextBox();
	void setEmailTextBox(TextBox emailTextBox);
	Button getChangePasswordButton();
	Button getEditUserButton();
	void showErrorMessages(String errorMessages);
}
