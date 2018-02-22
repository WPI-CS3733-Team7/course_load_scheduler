package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.InstructorUserLink;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UsersRolesLink;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;

public interface AccountPresenter extends BasePresenter
{	
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void changePassword();
	void editUser();
	
	void populateUserList(List<User> uList);
	void populateInstructorList(List<Instructor> iList);
	void populateUserRolesLinkList(List<UsersRolesLink> urlList);
	void populateInstructorUserLinkList(List<InstructorUserLink> iulList);
	
	void fillEditUserFields();
}
