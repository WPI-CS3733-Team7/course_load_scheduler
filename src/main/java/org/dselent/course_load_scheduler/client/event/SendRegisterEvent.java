package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRegisterAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRegisterEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRegisterEvent extends GwtEvent<SendRegisterEventHandler>
{
	public static Type<SendRegisterEventHandler> TYPE = new Type<SendRegisterEventHandler>();
	
	private SendRegisterAction action;
	
	public SendRegisterEvent(SendRegisterAction action)
	{
		this.action = action;
	}
	
	public SendRegisterAction getAction()
	{
		return action;
	}
	
	
	@Override
	public Type<SendRegisterEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRegisterEventHandler handler)
	{
		handler.onSendRegister(this);
	}

}
