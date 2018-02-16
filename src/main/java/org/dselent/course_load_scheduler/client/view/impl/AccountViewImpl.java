package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountPresenter;
import org.dselent.course_load_scheduler.client.view.AccountView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;


public class AccountViewImpl extends BaseViewImpl<AccountPresenter> implements AccountView {

	private static AccountViewImplUiBinder uiBinder = GWT.create(AccountViewImplUiBinder.class);
	
	interface AccountViewImplUiBinder extends UiBinder<Widget, AccountViewImpl> {}
	
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

	// Change password pop-up widgets
	Label changePasswordTitle = new Label("Change Password");
	Label changePasswordOld = new Label("Old password");
	Label changePasswordNew = new Label("New password");
	Label changePasswordConfirm = new Label("Confirm password");
	TextBox oldPasswordText = new TextBox();
	TextBox newPasswordText = new TextBox();
	TextBox confirmPasswordText = new TextBox();
	Button submitChangePasswordButton = new Button("Submit", new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			//presenter.changePassword();
		}
	});
	
	// Edit user pop-up widgets
	Label editUserTitle = new Label("Edit User");
	Label editUserRole = new Label("Role");
	Label editUserLinked = new Label("Linked Instructor");
	Button deleteEditUserButton = new Button("Delete", new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			//change deleted to true
			//presenter.editUser()
		}
	});
	Button submitEditUserButton = new Button("Submit", new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			// set deleted to false
			//presenter.editUser();
		}
	});

	public TextBox getOldPasswordText() {
		return oldPasswordText;
	}

	public TextBox getNewPasswordText() {
		return newPasswordText;
	}

	public TextBox getConfirmPasswordText() {
		return confirmPasswordText;
	}

	public Button getSubmitChangePasswordButton() {
		return submitChangePasswordButton;
	}
	
	public Button getSubmitEditUserButton()
	{
		return submitEditUserButton;
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
	public Button getDeleteEditUserButton() {
		return deleteEditUserButton;
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
	public void setPresenter(AccountPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@UiHandler("changePasswordButton")
	void onChangePasswordButtonClicked(ClickEvent evt)
	{
		Grid regGrid = new Grid(3, 2);
		regGrid.setWidget(0, 0, changePasswordOld);
		regGrid.setWidget(0, 1, oldPasswordText);
		regGrid.setWidget(1, 0, changePasswordNew);
		regGrid.setWidget(1, 1, newPasswordText);
		regGrid.setWidget(2, 0, changePasswordConfirm);
		regGrid.setWidget(2, 1, confirmPasswordText);
		
		VerticalPanel vertPanel = new VerticalPanel();
		vertPanel.add(changePasswordTitle);
		vertPanel.add(regGrid);
		vertPanel.add(submitChangePasswordButton);
		
		PopupPanel registerPopup = new PopupPanel(true);
		registerPopup.add(vertPanel);
		registerPopup.isGlassEnabled();
		registerPopup.center();
	}

	@UiHandler("editUserButton")
	void onEditUserPasswordButtonClicked(ClickEvent evt)
	{
		Grid regGrid = new Grid(3, 2);
		regGrid.setWidget(0, 0, editUserRole);
		// set 0, 1 to a drop down menu
		regGrid.setWidget(1, 0, editUserLinked);
		// set 1, 1 to a drop down menu
		regGrid.setWidget(2, 0, deleteEditUserButton);
		regGrid.setWidget(2, 1, submitEditUserButton);
		
		VerticalPanel vertPanel = new VerticalPanel();
		vertPanel.add(editUserTitle);
		vertPanel.add(regGrid);
		
		PopupPanel registerPopup = new PopupPanel(true);
		registerPopup.add(vertPanel);
		registerPopup.isGlassEnabled();
		registerPopup.center();
	}


	
}
