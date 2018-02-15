package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendReplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SelectRequestEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendReplyEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendReplyEvent extends GwtEvent<SendReplyEventHandler>{
	
	public static Type<SendReplyEventHandler> TYPE = new Type<SendReplyEventHandler>();
	
	private SendReplyAction action;
	
	public SendReplyEvent(SendReplyAction action)
	{
		this.action = action;
	}
	
	public SendReplyAction getAction()
	{
		return action;
	}
	
	
	@Override
	public Type<SendReplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendReplyEventHandler handler)
	{
		handler.onSendReply(this);
	}
}
