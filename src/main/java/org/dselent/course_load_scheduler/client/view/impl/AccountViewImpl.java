package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountPresenter;
import org.dselent.course_load_scheduler.client.view.AccountView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;


public class AccountViewImpl extends BaseViewImpl<AccountPresenter> implements AccountView {

	private static AccountViewImplUiBinder uiBinder = GWT.create(AccountViewImplUiBinder.class);
	@UiField 
	Label nameLabel;
	
	@UiField 
	TextBox nameTextBox;
	
	@UiField 
	Label usernameLabel;
	
	@UiField 
	TextBox usernameTextBox;
	
	@UiField 
	Label accountStateLabel;
	
	@UiField 
	TextBox accountStateTextBox;
	
	@UiField 
	Label emailLabel;
	
	@UiField 
	TextBox emailTextBox;
	
	@UiField 
	Button changePasswordButton;
	
	@UiField 
	Button editUserButton;
	
	@UiField 
	HorizontalPanel accountViewPanel;

	
	interface AccountViewImplUiBinder extends UiBinder<Widget, AccountViewImpl> {
	}

	public AccountViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(Label nameLabel) {
		this.nameLabel = nameLabel;
	}

	public TextBox getNameTextBox() {
		return nameTextBox;
	}

	public void setNameTextBox(TextBox nameTextBox) {
		this.nameTextBox = nameTextBox;
	}

	public Label getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(Label usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public TextBox getUsernameTextBox() {
		return usernameTextBox;
	}

	public void setUsernameTextBox(TextBox usernameTextBox) {
		this.usernameTextBox = usernameTextBox;
	}

	public Label getAccountStateLabel() {
		return accountStateLabel;
	}

	public void setAccountStateLabel(Label accountStateLabel) {
		this.accountStateLabel = accountStateLabel;
	}

	public TextBox getAccountStateTextBox() {
		return accountStateTextBox;
	}

	public void setAccountStateTextBox(TextBox accountStateTextBox) {
		this.accountStateTextBox = accountStateTextBox;
	}

	public Label getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(Label emailLabel) {
		this.emailLabel = emailLabel;
	}

	public TextBox getEmailTextBox() {
		return emailTextBox;
	}

	public void setEmailTextBox(TextBox emailTextBox) {
		this.emailTextBox = emailTextBox;
	}

	public Button getChangePasswordButton() {
		return changePasswordButton;
	}

	public void setChangePasswordButton(Button changePasswordButton) {
		this.changePasswordButton = changePasswordButton;
	}

	public Button getEditUserButton() {
		return editUserButton;
	}

	public void setEditUserButton(Button editUserButton) {
		this.editUserButton = editUserButton;
	}
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	

	@Override
	public HasWidgets getViewRootPanel()
	{
		return accountViewPanel;
	}
	
	
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}

	@Override
	public void setPresenter(AccountPresenter presenter) {
		// TODO Auto-generated method stub
		
	}

}
