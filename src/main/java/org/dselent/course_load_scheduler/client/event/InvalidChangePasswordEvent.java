package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidChangePasswordEventHandler;

public class InvalidChangePasswordEvent extends BaseEvent<InvalidChangePasswordAction, InvalidChangePasswordEventHandler>
{
	public static Type<InvalidChangePasswordEventHandler> TYPE = new Type<InvalidChangePasswordEventHandler>();
	
	public InvalidChangePasswordEvent(InvalidChangePasswordAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidChangePasswordEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidChangePasswordEventHandler handler)
	{
		handler.onInvalidChangePassword(this);
	}
}
