package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRegisterAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRegisterEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendRegisterEvent extends DisplayEvent<SendRegisterAction, SendRegisterEventHandler>
{
	public static Type<SendRegisterEventHandler> TYPE = new Type<SendRegisterEventHandler>();
	
	public SendRegisterEvent(SendRegisterAction action, HasWidgets container)
	{
		super(action, container);
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
