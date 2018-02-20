package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendLogoutAction;
import org.dselent.course_load_scheduler.client.event_handler.SendLogoutEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendLogoutEvent extends DisplayEvent<SendLogoutAction, SendLogoutEventHandler>
{
	public static Type<SendLogoutEventHandler> TYPE = new Type<SendLogoutEventHandler>();
	
	public SendLogoutEvent(SendLogoutAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendLogoutEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendLogoutEventHandler handler)
	{
		handler.onSendLogout(this);
	}
}
