package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidSelectRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidSelectRequestEventHandler;

public class InvalidSelectRequestEvent extends BaseEvent<InvalidSelectRequestAction, InvalidSelectRequestEventHandler>{
	public static Type<InvalidSelectRequestEventHandler> TYPE = new Type<InvalidSelectRequestEventHandler>();
	
	public InvalidSelectRequestEvent(InvalidSelectRequestAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidSelectRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidSelectRequestEventHandler handler)
	{
		handler.onInvalidSelectRequest(this);
	}
}
