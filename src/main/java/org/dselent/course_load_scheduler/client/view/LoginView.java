package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface LoginView extends BaseView<LoginPresenter>
{
	TextBox getLoginUserTextBox();
	void setLoginUserTextBox(TextBox loginUserTextBox);
	TextBox getLoginPasswordTextBox();
	void setLoginPasswordTextBox(TextBox loginPasswordTextBox);
	TextBox getUsernameText();
	void setUsernameText(TextBox usernameTextBox);
	TextBox getFirstnameText();
	void setFirstnameText(TextBox firstnameTextBox);
	TextBox getLastnameText();
	void setLastnameText(TextBox lastnameTextBox);
	TextBox getEmailText();
	void setEmailText(TextBox emailTextBox);
	TextBox getPasswordText();
	void setPasswordText(TextBox passwordTextBox);
	Button getLoginButton();
	Button getRegisterButton();
	Button getSubmitButton();
	void showErrorMessages(String errorMessages);
}
