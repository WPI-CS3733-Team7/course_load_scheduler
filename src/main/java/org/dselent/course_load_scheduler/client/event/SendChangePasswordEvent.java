package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.event_handler.SendChangePasswordEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendChangePasswordEvent extends DisplayEvent<SendChangePasswordAction, SendChangePasswordEventHandler>
{
	public static Type<SendChangePasswordEventHandler> TYPE = new Type<SendChangePasswordEventHandler>();
	
	public SendChangePasswordEvent(SendChangePasswordAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<SendChangePasswordEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendChangePasswordEventHandler handler)
	{
		handler.onSendChangePassword(this);
	}
}
