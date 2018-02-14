package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidRegisterAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidRegisterEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidRegisterEvent extends GwtEvent<InvalidRegisterEventHandler>
{
	public static Type<InvalidRegisterEventHandler> TYPE = new Type<InvalidRegisterEventHandler>();
	
	private InvalidRegisterAction action;
	
	public InvalidRegisterEvent(InvalidRegisterAction action)
	{
		this.action = action;
	}
	
	public InvalidRegisterAction getAction()
	{
		return action;
	}

	/*
	 * 
	 */
	@Override
	public Type<InvalidRegisterEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidRegisterEventHandler handler)
	{
		handler.onInvalidRegister(this);
	}
}
