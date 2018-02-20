package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditUserAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditUserEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;


public class SendEditUserEvent extends DisplayEvent<SendEditUserAction, SendEditUserEventHandler>
{
	
	public static Type<SendEditUserEventHandler> TYPE = new Type<SendEditUserEventHandler>();
	
	public SendEditUserEvent(SendEditUserAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<SendEditUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditUserEventHandler handler)
	{
		handler.onSendEditUser(this);
	}
}
