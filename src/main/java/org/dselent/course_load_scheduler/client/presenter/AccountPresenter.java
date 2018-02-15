package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.presenter.BasePresenter;

public interface AccountPresenter extends BasePresenter{	
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void changePassword();
	void editUser();
}
