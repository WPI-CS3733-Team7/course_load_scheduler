package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;
import org.dselent.course_load_scheduler.client.model.Request;

public interface AdminRequestPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void reply();
	void selectRequest();
	void populateRequestList(List<Request> requestList);
	void fillRequestFields();
}
