package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.model.GlobalData;

import com.google.gwt.user.client.ui.HasWidgets;

public interface MainPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void logout();
	GlobalData getGlobalData();
	HasWidgets getSchedulePanel();
	HasWidgets getRequestPanel();
	HasWidgets getAccountPanel();
	void onTabClicked(Integer index);
}
