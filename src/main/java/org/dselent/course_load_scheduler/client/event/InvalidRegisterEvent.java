package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidRegisterAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidRegisterEventHandler;

public class InvalidRegisterEvent extends BaseEvent<InvalidRegisterAction, InvalidRegisterEventHandler>
{
	public static Type<InvalidRegisterEventHandler> TYPE = new Type<InvalidRegisterEventHandler>();
	
	public InvalidRegisterEvent(InvalidRegisterAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidRegisterEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidRegisterEventHandler handler)
	{
		handler.onInvalidRegister(this);
	}
}
