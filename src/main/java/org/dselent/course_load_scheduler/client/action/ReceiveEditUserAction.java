package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.InstructorUserLink;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UsersRolesLink;

public class ReceiveEditUserAction extends Action
{
	private List<User> userList;
	private List<UsersRolesLink> userRoleLinkList;
	private List<Instructor> instructorList;
	private List<InstructorUserLink> instructorUserLinkList;
	
	public ReceiveEditUserAction(List<User> userList, List<UsersRolesLink> userRoleLinkList,
			List<Instructor> instructorList, List<InstructorUserLink> instructorUserLinkList) {
		this.userList = userList;
		this.userRoleLinkList = userRoleLinkList;
		this.instructorList = instructorList;
		this.instructorUserLinkList = instructorUserLinkList;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	public List<UsersRolesLink> getUserRoleLinkList() {
		return userRoleLinkList;
	}
	public List<Instructor> getInstructorList() {
		return instructorList;
	}
	public List<InstructorUserLink> getInstructorUserLinkList() {
		return instructorUserLinkList;
	}

	@Override
	public String toString() {
		return "ReceiveEditUserAction [userList=" + userList + ", userRoleLinkList=" + userRoleLinkList
				+ ", instructorList=" + instructorList + ", instructorUserLinkList=" + instructorUserLinkList + "]";
	}

}
