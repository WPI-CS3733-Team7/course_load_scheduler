package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidLoginEventHandler;

public class InvalidLoginEvent extends BaseEvent<InvalidLoginAction, InvalidLoginEventHandler>
{
	public static Type<InvalidLoginEventHandler> TYPE = new Type<InvalidLoginEventHandler>();
	
	public InvalidLoginEvent(InvalidLoginAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidLoginEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidLoginEventHandler handler)
	{
		handler.onInvalidLogin(this);
	}
}
