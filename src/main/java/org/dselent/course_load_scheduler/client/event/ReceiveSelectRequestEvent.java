package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSelectRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSelectRequestEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSelectRequestEvent extends DisplayEvent<ReceiveSelectRequestAction, ReceiveSelectRequestEventHandler>
{
	public static Type<ReceiveSelectRequestEventHandler> TYPE = new Type<ReceiveSelectRequestEventHandler>();
	
	public ReceiveSelectRequestEvent(ReceiveSelectRequestAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveSelectRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveSelectRequestEventHandler handler)
	{
		handler.onReceiveSelectRequest(this);
	}
}
