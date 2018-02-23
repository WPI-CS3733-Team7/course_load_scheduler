package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Instructor;

public class ReceiveValidateAction extends Action
{
	private String message;
	private List<Instructor> instructorList;
	private List<Course> courseList;

	public ReceiveValidateAction(String message, List<Instructor> instructorList, List<Course> courseList)
	{
		this.message = message;
		this.instructorList = instructorList;
		this.courseList = courseList;
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

	@Override
	public String toString() {
		return "ReceiveValidateAction [message=" + message + ", instructorList=" + instructorList + ", courseList="
				+ courseList + "]";
	}
}