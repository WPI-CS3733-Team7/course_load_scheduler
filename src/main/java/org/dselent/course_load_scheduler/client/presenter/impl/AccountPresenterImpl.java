package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountPresenter;
import java.util.ArrayList;
import java.util.List;
import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidChangePasswordStrings;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AccountView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class AccountPresenterImpl  extends BasePresenterImpl implements AccountPresenter{	
	
	private IndexPresenter parentPresenter;
	private AccountView view;
	private boolean changePasswordClickInProgress;
	private boolean editUserClickInProgress;

	@Inject
	public AccountPresenterImpl(IndexPresenter parentPresenter, AccountView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		changePasswordClickInProgress = false;
		editUserClickInProgress = false;
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
		
		//registration = eventBus.addHandler(InvalidChangePasswordEvent.TYPE, this);
		//eventBusRegistration.put(InvalidChangePasswordEvent.TYPE, registration);
		
		//registration = eventBus.addHandler(InvalidEditUserEvent.TYPE, this);
		//eventBusRegistration.put(InvalidEditUserEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	@Override
	public AccountView getView()
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
	public void changePassword()
	{
		if(!changePasswordClickInProgress)
		{
			changePasswordClickInProgress = true;
			view.getChangePasswordButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			// initially assumes valid password
			boolean validOldPassword = true;
			boolean validNewPassword = true;
			boolean validConfirmNewPassword = true;

			String oldPassword = view.getOldPasswordText().getText();
			String newPassword = view.getNewPasswordText().getText();
			String confirmNewPassword = view.getConfirmPasswordText().getText();
			
			List<String> invalidReasonList = new ArrayList<>();
			
			/* if old password is empty, add the proper string to 
			 * error message and set validOldPassword to false */
			try
			{
				validateField(oldPassword);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidChangePasswordStrings.NULL_OLD_PASSWORD);
				validOldPassword = false;
			}
			
			/* if new password is empty, add the proper string to 
			 * error message and set validNewPassword to false */
			try
			{
				validateField(newPassword);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidChangePasswordStrings.NULL_NEW_PASSWORD);
				validNewPassword = false;
			}
			
			
			/* if confirm new password is empty, add the proper string to 
			 * error message and set validConfirmNewPassword to false */
			try
			{
				validateField(confirmNewPassword);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidChangePasswordStrings.NULL_CONFIRM_NEW_PASSWORD);
				validConfirmNewPassword = false;
			}
			
			/* if the old password is the same as the new password, 
			 * inform the user in the error message */
			if(oldPassword == newPassword) {
				invalidReasonList.add(InvalidChangePasswordStrings.BAD_NEW_PASSWORD);
				validNewPassword = false;
			}
			
			/* if incorrect password length, 
			 * inform the user in the error message */
			if(newPassword.length() < 8 || newPassword.length() > 20) {
				invalidReasonList.add(InvalidChangePasswordStrings.BAD_PASSWORD_LENGTH);
				validNewPassword = false;
			}
			
			/* if the confirm new password field is not the same as the new password, 
			 * inform the user in the error message */
			if(confirmNewPassword != newPassword) {
				invalidReasonList.add(InvalidChangePasswordStrings.BAD_CONFIRM_NEW_PASSWORD);
				validConfirmNewPassword = false;
			}
			
			// if all the fields are valid, send the change password request 
			if(validOldPassword && validNewPassword && validConfirmNewPassword)
			{
				sendChangePassword(oldPassword, newPassword, confirmNewPassword);
			}
			else
			{
				InvalidLoginAction ila = new InvalidLoginAction(invalidReasonList);
				InvalidLoginEvent ile = new InvalidLoginEvent(ila);
				eventBus.fireEvent(ile);
			}
		}
	}

	private void sendChangePassword(String oldPassword, String newPassword, String confirmNewPassword)
	{
		SendChangePasswordAction scpa = new SendChangePasswordAction(oldPassword, newPassword);
		SendChangePasswordEvent scpe = new SendChangePasswordEvent(scpa);
		eventBus.fireEvent(scpe);
	}
	
	@Override
	public void editUser()
	{
		if(!editUserClickInProgress)
		{
			editUserClickInProgress = true;
		}
	}
	
	private void sendEditUser()
	{
		//SendEditUserAction seua = new SendEditUserAction();
		//SendEditUserEvent seue = new SendEditUserEvent(seue);
		//eventBus.fireEvent(seue);
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
}