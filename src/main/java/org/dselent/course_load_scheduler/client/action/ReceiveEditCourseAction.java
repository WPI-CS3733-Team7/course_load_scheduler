package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.User;

public class ReceiveEditCourseAction extends Action
{
	private User model;

	public ReceiveEditCourseAction(User model)
	{
		this.model = model;
	}

	public User getModel()
	{
		return model;
	}

	public void setModel(User model)
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