package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveLogoutAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveLogoutEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveLogoutEvent extends DisplayEvent<ReceiveLogoutAction, ReceiveLogoutEventHandler>
{
	public static Type<ReceiveLogoutEventHandler> TYPE = new Type<ReceiveLogoutEventHandler>();
	
	public ReceiveLogoutEvent(ReceiveLogoutAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveLogoutEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveLogoutEventHandler handler)
	{
		handler.onReceiveLogout(this);
	}
}
