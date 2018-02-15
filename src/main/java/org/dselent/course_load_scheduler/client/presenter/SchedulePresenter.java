package org.dselent.course_load_scheduler.client.presenter;

public interface SchedulePresenter extends BasePresenter {

	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	void deleteInstructor();
	void editInstructor();
	void deleteCourse();
	void editCourse();
	void selectInstructor();
	void selectCourse();
	
	void editSection();
	void validate();
	
	// request methods for courses, instructors, sections, validate
	
	
}
