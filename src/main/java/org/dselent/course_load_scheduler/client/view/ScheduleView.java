package org.dselent.course_load_scheduler.client.view;

public interface ScheduleView {
	public void addInstructorButton(String instructorName);
	public void addCourseButton(String courseName);
	public void removeInstructorButton(String instructorName);
	public void removeCourseButton(String courseName);
}
