package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CourseLoad;


public class ReceiveClickScheduleTabAction extends Action
{
	Integer linkedInstructorId;
	List<Instructor> instructorList;
	List<Course> courseList;
	List<CourseLoad> courseLoadList;
	
	public ReceiveClickScheduleTabAction(Integer linkedInstructorId, List<Instructor> instructorList, List<Course> courseList, List<CourseLoad> courseLoadList) {
		super();
		this.linkedInstructorId = linkedInstructorId;
		this.instructorList = instructorList;
		this.courseList = courseList;
		this.courseLoadList = courseLoadList;
	}	
	
	public Integer getLinkedInstructorId() {
		return linkedInstructorId;
	}

	public void setLinkedInstructorId(Integer linkedInstructorId) {
		this.linkedInstructorId = linkedInstructorId;
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

	public List<CourseLoad> getCourseLoadList() {
		return courseLoadList;
	}

	public void setCourseLoadList(List<CourseLoad> courseLoadList) {
		this.courseLoadList = courseLoadList;
	}

	@Override
	public String toString() {
		return "ReceiveClickScheduleTabAction [linkedInstructorId=" + linkedInstructorId + ", instructorList="
				+ instructorList + ", courseList=" + courseList + ", courseLoadList=" + courseLoadList + "]";
	}	
}
