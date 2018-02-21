package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;

public interface AccountPresenter extends BasePresenter
{	
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void changePassword();
	void editUser();
	
	void populateUserList(List<User> uList);
	void populateInstructorList(List<Instructor> iList);
	void fillEditUserFields();
}
