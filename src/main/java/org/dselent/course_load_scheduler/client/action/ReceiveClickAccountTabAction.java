package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UsersRolesLink;
import org.dselent.course_load_scheduler.client.model.InstructorUserLink;
import org.dselent.course_load_scheduler.client.model.Instructor;


public class ReceiveClickAccountTabAction extends Action
{
	String firstName;
	String lastName;
	String userName;
	String userRole;
	String email;
	List<User> userList;
	List<UsersRolesLink> userRoleLinkList;
	List<InstructorUserLink> instructorUserLinkList;
	List<Instructor> instructorList;

	public ReceiveClickAccountTabAction(String firstName, String lastName, String userName, String userRole,
			String email, List<User> userList, List<UsersRolesLink> userRoleLinkList,
			List<InstructorUserLink> instructorUserLinkList, List<Instructor> instructorList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.userRole = userRole;
		this.email = email;
		this.userList = userList;
		this.userRoleLinkList = userRoleLinkList;
		this.instructorUserLinkList = instructorUserLinkList;
		this.instructorList = instructorList;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getEmail() {
		return email;
	}

	public List<User> getUserList() {
		return userList;
	}

	public List<UsersRolesLink> getUserRoleLinkList() {
		return userRoleLinkList;
	}

	public List<InstructorUserLink> getInstructorUserLinkList() {
		return instructorUserLinkList;
	}

	public List<Instructor> getInstructorList() {
		return instructorList;
	}

	@Override
	public String toString() {
		return "ReceiveClickAccountTabAction [firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", userRole=" + userRole + ", email=" + email + ", userList=" + userList
				+ ", userRoleLinkList=" + userRoleLinkList + ", instructorUserLinkList=" + instructorUserLinkList
				+ ", instructorList=" + instructorList + "]";
	}	
}
