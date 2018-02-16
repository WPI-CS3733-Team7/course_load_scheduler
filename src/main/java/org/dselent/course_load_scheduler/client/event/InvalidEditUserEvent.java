package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidEditUserAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEditUserEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidEditUserEvent extends GwtEvent<InvalidEditUserEventHandler>
{
	
	public static Type<InvalidEditUserEventHandler> TYPE = new Type<InvalidEditUserEventHandler>();
	
	private InvalidEditUserAction action;
	
	public InvalidEditUserEvent(InvalidEditUserAction action)
	{
		this.action = action;
	}
	
	public InvalidEditUserAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<InvalidEditUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidEditUserEventHandler handler)
	{
		handler.onInvalidEditUser(this);
	}

}
