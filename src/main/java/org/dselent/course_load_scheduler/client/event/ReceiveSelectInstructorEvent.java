package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSelectInstructorAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSelectInstructorEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSelectInstructorEvent extends DisplayEvent<ReceiveSelectInstructorAction, ReceiveSelectInstructorEventHandler>
{
	public static Type<ReceiveSelectInstructorEventHandler> TYPE = new Type<ReceiveSelectInstructorEventHandler>();
	
	public ReceiveSelectInstructorEvent(ReceiveSelectInstructorAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveSelectInstructorEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveSelectInstructorEventHandler handler)
	{
		handler.onReceiveSelectInstructor(this);
	}
}
