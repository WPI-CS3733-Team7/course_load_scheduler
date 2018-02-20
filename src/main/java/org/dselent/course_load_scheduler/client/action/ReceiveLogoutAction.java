package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.User;

public class ReceiveLogoutAction extends Action
{
	private User model;

	public ReceiveLogoutAction(User model)
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
		builder.append("ReceiveLogoutAction [model=");
		builder.append(model);
		builder.append("]");
		return builder.toString();
	}


}