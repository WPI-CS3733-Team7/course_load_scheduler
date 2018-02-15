package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidReplyAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidReplyEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidReplyEvent extends GwtEvent<InvalidReplyEventHandler>
{
	public static Type<InvalidReplyEventHandler> TYPE = new Type<InvalidReplyEventHandler>();
	
	private InvalidReplyAction action;
	
	public InvalidReplyEvent(InvalidReplyAction action)
	{
		this.action = action;
	}
	
	public InvalidReplyAction getAction()
	{
		return action;
	}

	/*
	 * 
	 */
	@Override
	public Type<InvalidReplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidReplyEventHandler handler)
	{
		handler.onInvalidReply(this);
	}
}
