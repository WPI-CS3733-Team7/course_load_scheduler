package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CourseLoad;
import org.dselent.course_load_scheduler.client.model.Instructor;

public class ReceiveLoginAction extends Action
{
	private String message;
	private Integer userId;
	private String userRole;
	private Integer linkedInstructorId;
	private List<Instructor> instructorList;
	private List<Course> courseList;
	private List<CourseLoad> courseLoadList;
	
	public ReceiveLoginAction(String message, Integer userId, String userRole, Integer linkedInstructorId,
			List<Instructor> instructorList, List<Course> courseList, List<CourseLoad> courseLoadList) {
		this.message = message;
		this.userId = userId;
		this.userRole = userRole;
		this.linkedInstructorId = linkedInstructorId;
		this.instructorList = instructorList;
		this.courseList = courseList;
		this.courseLoadList = courseLoadList;
	}

	public String getMessage() {
		return message;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public Integer getLinkedInstructorId() {
		return linkedInstructorId;
	}

	public List<Instructor> getInstructorList() {
		return instructorList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public List<CourseLoad> getCourseLoadList() {
		return courseLoadList;
	}

	@Override
	public String toString() {
		return "ReceiveLoginAction [message=" + message + ", userId=" + userId + ", userRole=" + userRole
				+ ", linkedInstructorId=" + linkedInstructorId + ", instructorList=" + instructorList + ", courseList="
				+ courseList + ", courseLoadList=" + courseLoadList + "]";
	}	
}