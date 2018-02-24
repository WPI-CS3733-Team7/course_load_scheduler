package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Instructor;

public interface SchedulePresenter extends BasePresenter {

	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	void editInstructor(boolean creating, boolean deleting);
	void editCourse(boolean creating, boolean deleting);
	
	public void populateInstructorList(List<Instructor> instructorList);
	public void populateCourseList(List<Course> instructorList);
	
	void editSection();
	void validate();
	void fillInstructorFields();
	void fillCourseFields();
	void fillCourseSectionFields();
	void selectInstructor();
	void selectCourse();	
}
