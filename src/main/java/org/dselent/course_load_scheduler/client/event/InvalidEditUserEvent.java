package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidEditUserAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEditUserEventHandler;

public class InvalidEditUserEvent extends BaseEvent<InvalidEditUserAction, InvalidEditUserEventHandler>
{
	
	public static Type<InvalidEditUserEventHandler> TYPE = new Type<InvalidEditUserEventHandler>();
	
	public InvalidEditUserEvent(InvalidEditUserAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidEditUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidEditUserEventHandler handler)
	{
		handler.onInvalidEditUser(this);
	}

}
