package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendDisplayMessageAction;
import org.dselent.course_load_scheduler.client.event_handler.SendDisplayMessageEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendDisplayMessageEvent extends GwtEvent<SendDisplayMessageEventHandler>
{

	public static Type<SendDisplayMessageEventHandler> TYPE = new Type<SendDisplayMessageEventHandler>();
	
	private SendDisplayMessageAction action;
	
	public SendDisplayMessageEvent(SendDisplayMessageAction action)
	{
		this.action = action;
	}
	
	public SendDisplayMessageAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<SendDisplayMessageEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(SendDisplayMessageEventHandler handler)
	{
		handler.onSendDisplayMessage(this);
	}
}
