package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidRequestEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InvalidRequestEvent extends GwtEvent<InvalidRequestEventHandler>{
	public static Type<InvalidRequestEventHandler> TYPE = new Type<InvalidRequestEventHandler>();
	
	private InvalidRequestAction action;
	
	public InvalidRequestEvent(InvalidRequestAction action)
	{
		this.action = action;
	}
	
	public InvalidRequestAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<InvalidRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidRequestEventHandler handler)
	{
		handler.onInvalidRequest(this);
	}
}
