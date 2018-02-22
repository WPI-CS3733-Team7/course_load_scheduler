package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Instructor;

public class SendSelectInstructorAction extends Action
{
	private Instructor instructor;
	
	public SendSelectInstructorAction(Instructor selected)
	{
		this.instructor = selected;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	@Override
	public String toString() {
		return "SendSelectInstructorAction [instructor=" + instructor + "]";
	}
}
