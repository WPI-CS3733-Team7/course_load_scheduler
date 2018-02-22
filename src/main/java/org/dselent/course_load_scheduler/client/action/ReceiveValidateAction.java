package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CourseSection;
import org.dselent.course_load_scheduler.client.model.Instructor;

public class ReceiveValidateAction extends Action
{
	private String message;
	private List<Instructor> instructorList;
	private List<Course> courseList;
	private List<CourseSection> courseSectionList;
	private List<CalendarInfo> calendarInfoList;

	public ReceiveValidateAction(String message, List<Instructor> instructorList, List<Course> courseList, List<CourseSection> courseSectionList, 
			List<CalendarInfo> calendarInfoList)
	{
		this.message = message;
		this.instructorList = instructorList;
		this.courseList = courseList;
		this.courseSectionList = courseSectionList;
		this.calendarInfoList = calendarInfoList;
	}

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public List<Instructor> getInstructorList() {
		return instructorList;
	}



	public void setInstructorList(List<Instructor> instructorList) {
		this.instructorList = instructorList;
	}



	public List<Course> getCourseList() {
		return courseList;
	}



	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}



	public List<CourseSection> getCourseSectionList() {
		return courseSectionList;
	}



	public void setCourseSectionList(List<CourseSection> courseSectionList) {
		this.courseSectionList = courseSectionList;
	}



	public List<CalendarInfo> getCalendarInfoList() {
		return calendarInfoList;
	}



	public void setCalendarInfoList(List<CalendarInfo> calendarInfoList) {
		this.calendarInfoList = calendarInfoList;
	}

	@Override
	public String toString() {
		return "ReceiveValidateAction [message=" + message + ", instructorList=" + instructorList + ", courseList="
				+ courseList + ", courseSectionList=" + courseSectionList + ", calendarInfoList=" + calendarInfoList
				+ "]";
	}
}