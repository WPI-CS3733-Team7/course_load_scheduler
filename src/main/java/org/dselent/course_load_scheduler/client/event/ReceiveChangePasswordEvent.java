package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveChangePasswordAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveChangePasswordEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveChangePasswordEvent extends DisplayEvent<ReceiveChangePasswordAction, ReceiveChangePasswordEventHandler>
{
	public static Type<ReceiveChangePasswordEventHandler> TYPE = new Type<ReceiveChangePasswordEventHandler>();
	
	public ReceiveChangePasswordEvent(ReceiveChangePasswordAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveChangePasswordEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveChangePasswordEventHandler handler)
	{
		handler.onReceiveChangePassword(this);
	}
}