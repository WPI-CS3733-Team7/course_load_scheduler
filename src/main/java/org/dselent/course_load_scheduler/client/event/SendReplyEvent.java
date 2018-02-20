package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendReplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendReplyEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendReplyEvent extends DisplayEvent<SendReplyAction, SendReplyEventHandler>{
	
	public static Type<SendReplyEventHandler> TYPE = new Type<SendReplyEventHandler>();
	
	public SendReplyEvent(SendReplyAction action, HasWidgets container)
	{
		super(action, container);
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
