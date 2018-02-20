package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveReplyAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveReplyEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveReplyEvent extends DisplayEvent<ReceiveReplyAction, ReceiveReplyEventHandler>
{
	public static Type<ReceiveReplyEventHandler> TYPE = new Type<ReceiveReplyEventHandler>();
	
	public ReceiveReplyEvent(ReceiveReplyAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveReplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveReplyEventHandler handler)
	{
		handler.onReceiveReply(this);
	}
}
