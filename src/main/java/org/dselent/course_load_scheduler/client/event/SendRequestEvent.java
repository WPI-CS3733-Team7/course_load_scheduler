package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRequestEvent extends GwtEvent<SendRequestEventHandler>{
	public static Type<SendRequestEventHandler> TYPE = new Type<SendRequestEventHandler>();
	
	private SendRequestAction action;
	
	public SendRequestEvent(SendRequestAction action)
	{
		this.action = action;
	}
	
	public SendRequestAction getAction()
	{
		return action;
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
