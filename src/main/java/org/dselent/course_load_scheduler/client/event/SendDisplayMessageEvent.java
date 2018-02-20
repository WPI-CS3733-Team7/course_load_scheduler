package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendDisplayMessageAction;
import org.dselent.course_load_scheduler.client.event_handler.SendDisplayMessageEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendDisplayMessageEvent extends DisplayEvent<SendDisplayMessageAction, SendDisplayMessageEventHandler>
{

	public static Type<SendDisplayMessageEventHandler> TYPE = new Type<SendDisplayMessageEventHandler>();
	
	public SendDisplayMessageEvent(SendDisplayMessageAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendDisplayMessageEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendDisplayMessageEventHandler handler)
	{
		handler.onSendDisplayMessage(this);
	}
}
