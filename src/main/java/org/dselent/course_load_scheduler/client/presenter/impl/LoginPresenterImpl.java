package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;
import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.InvalidRegisterAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.action.SendRegisterAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidLoginStrings;
import org.dselent.course_load_scheduler.client.errorstring.InvalidRegisterStrings;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidRegisterEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.event.SendRegisterEvent;
import org.dselent.course_load_scheduler.client.event_handler.SendLogoutEventHandler;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.view.LoginView;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class LoginPresenterImpl extends BasePresenterImpl implements LoginPresenter
{
	private IndexPresenter parentPresenter;
	private LoginView view;
	private boolean loginClickInProgress;
	private boolean submitClickInProgress;

	@Inject
	public LoginPresenterImpl(IndexPresenter parentPresenter, LoginView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		loginClickInProgress = false;
		submitClickInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidLoginEvent.TYPE, this);
		eventBusRegistration.put(InvalidLoginEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidRegisterEvent.TYPE, this);
		eventBusRegistration.put(InvalidRegisterEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SendLogoutEvent.TYPE, this);
		eventBusRegistration.put(SendLogoutEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public LoginView getView()
	{
		return view;
	}
	
	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	@Override
	public void login()
	{
		if(!loginClickInProgress)
		{
			loginClickInProgress = true;
			view.getLoginButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			String userName = view.getLoginUserTextBox().getText();
			String password = view.getLoginPasswordTextBox().getText();
			
			boolean validUserName = true;
			boolean validPassword = true;

			List<String> invalidReasonList = new ArrayList<>();
			
			try
			{
				validateField(userName);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidLoginStrings.NULL_USER_NAME);
				validUserName = false;
			}

			try
			{
				validateField(password);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidLoginStrings.NULL_PASSWORD);
				validPassword = false;
			}
			
			if(validUserName && validPassword)
			{
				sendLogin(userName, password);
			}
			else
			{
				InvalidLoginAction ila = new InvalidLoginAction(invalidReasonList);
				InvalidLoginEvent ile = new InvalidLoginEvent(ila);
				eventBus.fireEvent(ile);
			}
		}
	}
	
	private void sendLogin(String userName, String password)
	{
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendLoginAction sla = new SendLoginAction(userName, password);
		SendLoginEvent sle = new SendLoginEvent(sla, container);
		eventBus.fireEvent(sle);
	}
	
	private void validateField(String field) throws EmptyStringException
	{
		checkEmptyString(field);
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	/*
	 * Currently only sent by itself
	 * Probably did not need the event bus for this
	 * Useful for example purposes without involving server-side
	*/
	@Override
	public void onInvalidLogin(InvalidLoginEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getLoginButton().setEnabled(true);
		loginClickInProgress = false;
		
		InvalidLoginAction ila = evt.getAction();
		view.showErrorMessages(ila.toString());
	}

	@Override
	public void register()
	{	
		if (!submitClickInProgress)
		{
			submitClickInProgress = true;
			view.getSubmitButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			boolean validUserName = true;
			boolean validFirstName = true;
			boolean validLastName = true;
			boolean validEmail = true;
			boolean validPassword = true;
			
			String userName = view.getUsernameText().getText();
			String firstName = view.getFirstnameText().getText();
			String lastName = view.getLastnameText().getText();
			String email = view.getEmailText().getText();
			String password = view.getPasswordText().getText();
			
			List<String> invalidReasonList = new ArrayList<>();
			
			//
			
			try
			{
				validateField(userName);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidRegisterStrings.NULL_USER_NAME);
				validUserName = false;
			}
			
			//
			
			try
			{
				validateField(firstName);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidRegisterStrings.NULL_FIRST_NAME);
				validUserName = false;
			}
			
			//
			
			try
			{
				validateField(lastName);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidRegisterStrings.NULL_LAST_NAME);
				validUserName = false;
			}
			
			//
			
			try
			{
				validateField(email);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidRegisterStrings.NULL_EMAIL);
				validUserName = false;
			}

			//
			
			if (password.length() < 8 || password.length() > 20) {
				invalidReasonList.add(InvalidRegisterStrings.BAD_PASSWORD_LENGTH);
				validPassword = false;
			}
		
			//
			
			if(validUserName && validFirstName && validLastName && validEmail && validPassword)
			{
				sendRegister(userName, firstName, lastName, email, password);
			}
			else
			{
				InvalidRegisterAction ira = new InvalidRegisterAction(invalidReasonList);
				InvalidRegisterEvent ire = new InvalidRegisterEvent(ira);
				eventBus.fireEvent(ire);
			}
		}
	}
	
	@Override
	public void onInvalidRegister(InvalidRegisterEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getSubmitButton().setEnabled(true);
		submitClickInProgress = false;
		
		InvalidRegisterAction ira = evt.getAction();
		view.showErrorMessages(ira.toString());
	}
	
	private void sendRegister(String userName, String firstName, String lastName, String email, String password)
	{
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendRegisterAction sra = new SendRegisterAction(userName, firstName, lastName, email, password);
		SendRegisterEvent sre = new SendRegisterEvent(sra, container);
		eventBus.fireEvent(sre);
	}

	@Override
	public void onSendLogout(SendLogoutEvent evt)
	{
		parentPresenter.hideLoadScreen();
		this.go(parentPresenter.getView().getViewRootPanel());	
	}

}
