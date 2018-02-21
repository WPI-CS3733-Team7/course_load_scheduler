package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountPresenter;
import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.action.InvalidEditUserAction;
import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.action.SendEditUserAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidChangePasswordStrings;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditUserStrings;
import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditUserEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendEditUserEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.InstructorUserLink;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UsersRolesLink;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AccountView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class AccountPresenterImpl  extends BasePresenterImpl implements AccountPresenter
{	
	private IndexPresenter parentPresenter;
	private AccountView view;
	private GlobalData globalData;
	private boolean changePasswordClickInProgress;
	private boolean editUserClickInProgress;
	
	List<User> userList = new ArrayList<User>();
	List<UsersRolesLink> userRoleLinkList = new ArrayList<UsersRolesLink>();
	List<InstructorUserLink> instructorUserLinkList = new ArrayList<InstructorUserLink>();
	List<Instructor> instructorList = new ArrayList<Instructor>();
	int selectedUser = -1;
	

	@Inject
	public AccountPresenterImpl(IndexPresenter parentPresenter, AccountView view, GlobalData globalData)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		this.globalData = globalData;
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
		
		registration = eventBus.addHandler(InvalidChangePasswordEvent.TYPE, this);
		eventBusRegistration.put(InvalidChangePasswordEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidEditUserEvent.TYPE, this);
		eventBusRegistration.put(InvalidEditUserEvent.TYPE, registration);
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
	
	/*---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----*/
	
	public void populateUserList(List<User> uList)
	{
		userList = uList;
		view.getUserBox().clear();
		for (User u : userList)
		{
			view.getUserBox().addItem(u.displayText());
		}
	}
	
	public void populateInstructorList(List<Instructor> iList)
	{
		instructorList = iList;
		view.getLinkedInstructorDropBox().clear();
		view.getLinkedInstructorDropBox().addItem("-");
		for (Instructor i : instructorList) {
			view.getLinkedInstructorDropBox().addItem(i.displayText());
		}
	}
	
	
	
	public void populateRoleList()
	{
		view.getRoleDropBox().clear();
		view.getRoleDropBox().addItem("USER");
		view.getRoleDropBox().addItem("LINKED USER");
		view.getRoleDropBox().addItem("ADMIN");
	}
	
	public void fillEditUserFields()
	{
		// find which user is selected
		selectedUser = view.getUserBox().getSelectedIndex();
		User selected = userList.get(selectedUser);
		int userId = selected.getId();
		
		//
		
		// get that user's role
		UsersRolesLink userRole = null;
		for (UsersRolesLink u : userRoleLinkList)
		{
			if (u.getUserId() == userId)
			{
				userRole = u;
				break;
			}
		}
		// user role entry was not found (should never happen if user was not manually entered in database)
		if (userRole == null) {
			view.getRoleDropBox().setSelectedIndex(0);
		} 
		else 
		{
			// get corresponding user role
			if (userRole.getRoleId() == 1) {
				view.getRoleDropBox().setSelectedIndex(2);
			} else if (userRole.getRoleId() == 2) {
				view.getRoleDropBox().setSelectedIndex(0);
			} else if (userRole.getRoleId() == 3) {
				view.getRoleDropBox().setSelectedIndex(1);
			}
		}
		
		//
		
		// get the user's instructor link
		InstructorUserLink userLink = null;
		for (InstructorUserLink u : instructorUserLinkList)
		{
			if (u.getLinkedUserId() == userId)
			{
				userLink = u;
				break;
			}
		}
		
		int instructorIndex = 0;
		// if the user has a link to an instructor, find the corresponding instructor
		if (userLink != null)
		{
			for (int i = 0; i < instructorList.size(); i++)
			{
				if (instructorList.get(i).getId() == userLink.getInstructorId())
				{
					instructorIndex = i + 1;
					break;
				}
			}
		}
		view.getLinkedInstructorDropBox().setSelectedIndex(instructorIndex);
	}
	
	/*---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----*/
	
	@Override
	public void changePassword()
	{
		if(!changePasswordClickInProgress)
		{
			changePasswordClickInProgress = true;
			view.getSubmitChangePasswordButton().setEnabled(false);
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
			if(oldPassword == newPassword && oldPassword != "") {
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
			if(confirmNewPassword != newPassword)
			{
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
				InvalidChangePasswordAction icpa = new InvalidChangePasswordAction(invalidReasonList);
				InvalidChangePasswordEvent icpe = new InvalidChangePasswordEvent(icpa);
				eventBus.fireEvent(icpe);
			}
		}
	}

	private void sendChangePassword(String oldPassword, String newPassword, String confirmNewPassword)
	{
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendChangePasswordAction scpa = new SendChangePasswordAction(globalData.getUserId(), oldPassword, newPassword);
		SendChangePasswordEvent scpe = new SendChangePasswordEvent(scpa, container);
		eventBus.fireEvent(scpe);
	}
	
	@Override
	public void onInvalidChangePassword(InvalidChangePasswordEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getSubmitChangePasswordButton().setEnabled(true);
		changePasswordClickInProgress = false;
		
		InvalidChangePasswordAction icpa = evt.getAction();
		view.showErrorMessages(icpa.toString());
	}
	
	/*---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----*/
	
	@Override
	public void editUser()
	{	
		if(!editUserClickInProgress)
		{
			editUserClickInProgress = true;
			view.getSubmitEditUserButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			boolean validUserRole = true;
			boolean validLinkedInstructor = true;
			
			String userRole = view.getRoleDropBox().getItemText(view.getRoleDropBox().getSelectedIndex());
			String linkedInstructor = view.getLinkedInstructorDropBox().getItemText(view.getLinkedInstructorDropBox().getSelectedIndex());
			Boolean deleted = view.isDeleted();
			
			List<String> invalidReasonList = new ArrayList<>();
			if(userRole == "LINKED USER" && linkedInstructor == "-" && !deleted)
			{
				invalidReasonList.add(InvalidEditUserStrings.LINKED_USER_ERROR);
				validLinkedInstructor = false;
			}
			if(validUserRole && validLinkedInstructor)
			{
				sendEditUser(userRole, linkedInstructor, deleted);
			}
			else
			{
				InvalidEditUserAction ieua = new InvalidEditUserAction(invalidReasonList);
				InvalidEditUserEvent ieue = new InvalidEditUserEvent(ieua);
				eventBus.fireEvent(ieue);
			}
		}
	}
	
	@Override
	public void onInvalidEditUser(InvalidEditUserEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getSubmitEditUserButton().setEnabled(true);
		editUserClickInProgress = false;
		
		InvalidEditUserAction ieau = evt.getAction();
		view.showErrorMessages(ieau.toString());
	}
	
	private void sendEditUser(String userRole, String linkedInstructor, Boolean deleted)
	{
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendEditUserAction seua = new SendEditUserAction(globalData.getUserId(), null, userRole, /*linkedInstructor*/ -1, deleted);
		SendEditUserEvent seue = new SendEditUserEvent(seua, container);
		eventBus.fireEvent(seue);
	}
	
	@Override
	public void onReceiveChangePassword(ReceiveChangePasswordEvent evt)
	{
		String message = evt.getAction().getMessage();
		view.showErrorMessages(message);
	}
	
	/*---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----*/
	
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
