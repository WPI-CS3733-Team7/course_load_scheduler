package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSelectInstructorAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSelectInstructorEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendSelectInstructorEvent extends DisplayEvent<SendSelectInstructorAction, SendSelectInstructorEventHandler>
{
	public static Type<SendSelectInstructorEventHandler> TYPE = new Type<SendSelectInstructorEventHandler>();
	
	public SendSelectInstructorEvent(SendSelectInstructorAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<SendSelectInstructorEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSelectInstructorEventHandler handler) {
		handler.onSendSelectInstructor(this);
	}
}
