package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendLogoutAction;
import org.dselent.course_load_scheduler.client.event_handler.SendLogoutEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendLogoutEvent extends GwtEvent<SendLogoutEventHandler>
{
	public static Type<SendLogoutEventHandler> TYPE = new Type<SendLogoutEventHandler>();
	
	private SendLogoutAction action;
	
	public SendLogoutEvent(SendLogoutAction action)
	{
		this.action = action;
	}
	
	public SendLogoutAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<SendLogoutEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(SendLogoutEventHandler handler)
	{
		handler.onSendLogout(this);
	}
}
