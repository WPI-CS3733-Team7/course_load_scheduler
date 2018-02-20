package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendRequestEvent extends DisplayEvent<SendRequestAction, SendRequestEventHandler>{
	public static Type<SendRequestEventHandler> TYPE = new Type<SendRequestEventHandler>();
	
	public SendRequestEvent(SendRequestAction action, HasWidgets container)
	{
		super(action, container);
	}	
	
	@Override
	public Type<SendRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRequestEventHandler handler)
	{
		handler.onSendRequest(this);
	}
}
