package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidReplyAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidReplyEventHandler;

public class InvalidReplyEvent extends BaseEvent<InvalidReplyAction, InvalidReplyEventHandler>
{
	public static Type<InvalidReplyEventHandler> TYPE = new Type<InvalidReplyEventHandler>();
	
	public InvalidReplyEvent(InvalidReplyAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidReplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidReplyEventHandler handler)
	{
		handler.onInvalidReply(this);
	}
}
