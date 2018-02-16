package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.view.impl.ModelButton;

public interface SchedulePresenter extends BasePresenter {

	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	void editInstructor(boolean deleting);
	void editCourse(boolean deleting);
	void selectInstructor(ModelButton<Instructor> clickedButton);
	void selectCourse(ModelButton<Course> clickedButton);
	
	void editSection();
	void validate();	
}
