package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidRequestEventHandler;

public class InvalidRequestEvent extends BaseEvent<InvalidRequestAction, InvalidRequestEventHandler>{
	public static Type<InvalidRequestEventHandler> TYPE = new Type<InvalidRequestEventHandler>();
	
	public InvalidRequestEvent(InvalidRequestAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidRequestEventHandler handler)
	{
		handler.onInvalidRequest(this);
	}
}
