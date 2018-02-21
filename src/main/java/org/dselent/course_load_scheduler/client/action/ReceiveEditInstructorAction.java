package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Instructor;

public class ReceiveEditInstructorAction extends Action
{
	private Instructor model;

	public ReceiveEditInstructorAction(Instructor model)
	{
		this.model = model;
	}

	public Instructor getModel()
	{
		return model;
	}

	public void setModel(Instructor model)
	{
		this.model = model;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveEditInstructorAction [model=");
		builder.append(model);
		builder.append("]");
		return builder.toString();
	}


}