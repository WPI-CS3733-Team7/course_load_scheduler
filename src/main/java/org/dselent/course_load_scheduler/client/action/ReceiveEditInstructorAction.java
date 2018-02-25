package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.CourseLoad;
import org.dselent.course_load_scheduler.client.model.Instructor;

public class ReceiveEditInstructorAction extends Action
{
	private Instructor instructorModel;
	private CourseLoad courseLoadModel;

	public ReceiveEditInstructorAction(Instructor instructorModel, CourseLoad courseLoadModel)
	{
		this.instructorModel = instructorModel;
		this.courseLoadModel = courseLoadModel;
	}

	public Instructor getInstructorModel() {
		return instructorModel;
	}

	public void setInstructorModel(Instructor instructorModel) {
		this.instructorModel = instructorModel;
	}

	public CourseLoad getCourseLoadModel() {
		return courseLoadModel;
	}

	public void setCourseLoadModel(CourseLoad courseLoadModel) {
		this.courseLoadModel = courseLoadModel;
	}

	@Override
	public String toString() {
		return "ReceiveEditInstructorAction [instructorModel=" + instructorModel + ", courseLoadModel="
				+ courseLoadModel + "]";
	}
}