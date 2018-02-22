package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Course;

public class SendSelectCourseAction extends Action
{
	private Course course;
	
	public SendSelectCourseAction(Course selected)
	{
		this.course = selected;
	}

	public Course getCourse()
	{
		return course;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendSelectCourseAction [course=");
		builder.append(course);
		builder.append("]");
		return builder.toString();
	}

}
