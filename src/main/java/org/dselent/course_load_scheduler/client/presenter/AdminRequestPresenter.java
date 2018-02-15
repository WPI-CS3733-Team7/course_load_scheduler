package org.dselent.course_load_scheduler.client.presenter;

public interface AdminRequestPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void reply();
	void selectRequest();
}
