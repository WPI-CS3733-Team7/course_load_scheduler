package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditUserAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditUserEventHandler;

import com.google.gwt.event.shared.GwtEvent;


public class SendEditUserEvent extends GwtEvent<SendEditUserEventHandler>
{
	
	public static Type<SendEditUserEventHandler> TYPE = new Type<SendEditUserEventHandler>();
	
	private SendEditUserAction action;
	
	public SendEditUserEvent(SendEditUserAction action)
	{
		this.action = action;
	}
	
	public SendEditUserAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<SendEditUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(SendEditUserEventHandler handler)
	{
		handler.onSendEditUser(this);
	}
}
