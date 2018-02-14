package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;

import com.google.gwt.user.client.ui.Button;

public interface ScheduleView extends BaseView<SchedulePresenter>{
	public void addInstructorButton(String instructorName);
	public void addCourseButton(String courseName);
	public void removeInstructorButton(String instructorName);
	public void removeCourseButton(String courseName);
	public Button getSelectedInstructor();
	public Button getSelectedCourse();
}
