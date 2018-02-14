package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.view.LoginView;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.PopupPanel;



public class LoginViewImpl extends BaseViewImpl<LoginPresenter> implements LoginView
{
	private static LoginViewImplUiBinder uiBinder = GWT.create(LoginViewImplUiBinder.class);
	
	interface LoginViewImplUiBinder extends UiBinder<Widget, LoginViewImpl>{}
	
	@UiField VerticalPanel loginPanel;
	@UiField Label titleLabel;
	@UiField Label loginUserLabel;
	@UiField Label loginPasswordLabel;
	@UiField TextBox loginUserTextBox;
	@UiField TextBox loginPasswordTextBox;
	@UiField Button registerButton;
	@UiField Button loginButton;
	
	Label regLabel = new Label("Registration");
	Label usernameLabel = new Label("Username");
	Label firstnameLabel = new Label("First Name");
	Label lastnameLabel = new Label("Last Name");
	Label emailLabel = new Label("Email Address");
	Label passwordLabel = new Label("Password");
	TextBox usernameText = new TextBox();
	TextBox firstnameText = new TextBox();
	TextBox lastnameText = new TextBox();
	TextBox emailText = new TextBox();
	TextBox passwordText = new TextBox();
	Button submitButton = new Button("Submit", new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			presenter.register();
		}
	});
	
	public TextBox getUsernameText() {
		return usernameText;
	}

	public void setUsernameText(TextBox usernameText) {
		this.usernameText = usernameText;
	}

	public TextBox getFirstnameText() {
		return firstnameText;
	}

	public void setFirstnameText(TextBox firstnameText) {
		this.firstnameText = firstnameText;
	}

	public TextBox getLastnameText() {
		return lastnameText;
	}

	public void setLastnameText(TextBox lastnameText) {
		this.lastnameText = lastnameText;
	}

	public TextBox getEmailText() {
		return emailText;
	}

	public void setEmailText(TextBox emailText) {
		this.emailText = emailText;
	}

	public TextBox getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(TextBox passwordText) {
		this.passwordText = passwordText;
	}

	public LoginViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public TextBox getLoginUserTextBox() {
		return loginUserTextBox;
	}

	public void setLoginUserTextBox(TextBox loginUserTextBox) {
		this.loginUserTextBox = loginUserTextBox;
	}

	public TextBox getLoginPasswordTextBox() {
		return loginPasswordTextBox;
	}

	public void setLoginPasswordTextBox(TextBox loginPasswordTextBox) {
		this.loginPasswordTextBox = loginPasswordTextBox;
	}

	@Override
	public Button getLoginButton()
	{
		return loginButton;
	}

	@Override
	public Button getRegisterButton()
	{
		return registerButton;
	}
	
	@Override
	public void setPresenter(LoginPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return loginPanel;
	}
	
	@UiHandler("loginButton")
	void onloginButtonClicked(ClickEvent evt)
	{
		presenter.login();
	}
	
	@UiHandler("registerButton")
	void onregisterButtonClicked(ClickEvent evt)
	{
		Grid regGrid = new Grid(5, 2);		
		regGrid.setWidget(0, 0, usernameLabel);
		regGrid.setWidget(0, 1, usernameText);
		regGrid.setWidget(1, 0, firstnameLabel);
		regGrid.setWidget(1, 1, firstnameText);
		regGrid.setWidget(2, 0, lastnameLabel);
		regGrid.setWidget(2, 1, lastnameText);
		regGrid.setWidget(3, 0, emailLabel);
		regGrid.setWidget(3, 1, emailText);
		regGrid.setWidget(4, 0, passwordLabel);
		regGrid.setWidget(4, 1, passwordText);
		
		VerticalPanel vertPanel = new VerticalPanel();
		vertPanel.add(regLabel);
		vertPanel.add(regGrid);
		vertPanel.add(submitButton);
		
		PopupPanel registerPopup = new PopupPanel(true);
		registerPopup.add(vertPanel);
		registerPopup.isGlassEnabled();
		registerPopup.center();
	}

	public Button getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(Button submitButton) {
		this.submitButton = submitButton;
	}
}
