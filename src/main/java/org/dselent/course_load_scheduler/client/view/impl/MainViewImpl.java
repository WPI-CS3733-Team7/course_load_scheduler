package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainViewImpl extends Composite implements HasText {

	private static MainViewImplUiBinder uiBinder = GWT.create(MainViewImplUiBinder.class);
	@UiField Button scheduleAddCourse;
	@UiField Button scheduleAddInstructor;
	@UiField Button scheduleEditInstructor;
	@UiField Button scheduleEditCourse;
	@UiField VerticalPanel scheduleInstructorsPanel;
	@UiField VerticalPanel scheduleCoursesPanel;

	interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
	}

	public MainViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public MainViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
		// todo
	}

	public String getText() {
		// todo
		return null;
	}

	@UiHandler("scheduleAddCourse")
	void onScheduleAddCourseClick(ClickEvent event) {
	}
}
