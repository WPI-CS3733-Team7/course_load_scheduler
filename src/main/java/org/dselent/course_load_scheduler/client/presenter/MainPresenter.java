package org.dselent.course_load_scheduler.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;

public interface MainPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void logout();
	HasWidgets getSchedulePanel();
	HasWidgets getRequestPanel();
	HasWidgets getAccountPanel();
}
