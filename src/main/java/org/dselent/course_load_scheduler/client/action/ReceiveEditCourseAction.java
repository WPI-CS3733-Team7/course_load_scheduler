package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.User;

public class ReceiveEditCourseAction extends Action
{
	private Course model;

	public ReceiveEditCourseAction(Course model)
	{
		this.model = model;
	}

	public Course getModel()
	{
		return model;
	}

	public void setModel(Course model)
	{
		this.model = model;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveEditCourseAction [model=");
		builder.append(model);
		builder.append("]");
		return builder.toString();
	}


}