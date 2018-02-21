package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AccountPresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public interface AccountView extends BaseView<AccountPresenter>{
	
	void setChangingNameLabelText(String text);
	void setChangingUsernameLabelText(String text);
	void setChangingAccountStateLabelText(String text);
	void setChangingEmailLabelText(String text);
	//
	Button getChangePasswordButton();
	Button getEditUserButton();
	void showErrorMessages(String errorMessages);
	//
	TextBox getOldPasswordText();
	TextBox getNewPasswordText();
	TextBox getConfirmPasswordText();
	Button getSubmitChangePasswordButton();
	//
	ListBox getRoleDropBox();
	ListBox getLinkedInstructorDropBox();
	Button getSubmitEditUserButton();
	Button getDeleteEditUserButton();
	boolean isDeleted();
	ListBox getUserBox();
}
