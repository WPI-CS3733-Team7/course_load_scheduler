package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveEditInstructorAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveEditInstructorEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveEditInstructorEvent extends DisplayEvent<ReceiveEditInstructorAction, ReceiveEditInstructorEventHandler>
{
	public static Type<ReceiveEditInstructorEventHandler> TYPE = new Type<ReceiveEditInstructorEventHandler>();
	
	public ReceiveEditInstructorEvent(ReceiveEditInstructorAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveEditInstructorEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveEditInstructorEventHandler handler)
	{
		handler.onReceiveEditInstructor(this);
	}
}
