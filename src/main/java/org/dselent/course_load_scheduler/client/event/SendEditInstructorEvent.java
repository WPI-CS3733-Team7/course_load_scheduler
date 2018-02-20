package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditInstructorEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendEditInstructorEvent extends DisplayEvent<SendEditInstructorAction, SendEditInstructorEventHandler>
{
	public static Type<SendEditInstructorEventHandler> TYPE = new Type<SendEditInstructorEventHandler>();
	
	public SendEditInstructorEvent(SendEditInstructorAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<SendEditInstructorEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditInstructorEventHandler handler) {
		handler.onSendEditInstructor(this);
	}
}
