package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditInstructorEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class SendEditInstructorEvent extends GwtEvent<SendEditInstructorEventHandler>
{
	public static Type<SendEditInstructorEventHandler> TYPE = new Type<SendEditInstructorEventHandler>();
	
	private SendEditInstructorAction action;
	
	public SendEditInstructorEvent(SendEditInstructorAction action)
	{
		this.action = action;
	}
	
	public SendEditInstructorAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<SendEditInstructorEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(SendEditInstructorEventHandler handler) {
		handler.onSendEditInstructor(this);
	}
}
