package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AccountPresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface AccountView extends BaseView<AccountPresenter>{
	
	Button getChangePasswordButton();
	Button getEditUserButton();
	void showErrorMessages(String errorMessages);
	//
	TextBox getOldPasswordText();
	TextBox getNewPasswordText();
	TextBox getConfirmPasswordText();
	Button getSubmitChangePasswordButton();
	//
	TextBox getUserRoleText();
	TextBox getLinkedInstructorText();
	Button getSubmitEditUserButton();
	Button getDeleteEditUserButton();
	boolean isDeleted();
}
