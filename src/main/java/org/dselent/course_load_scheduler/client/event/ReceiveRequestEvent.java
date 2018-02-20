package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveRequestEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveRequestEvent extends DisplayEvent<ReceiveRequestAction, ReceiveRequestEventHandler>
{
	public static Type<ReceiveRequestEventHandler> TYPE = new Type<ReceiveRequestEventHandler>();
	
	public ReceiveRequestEvent(ReceiveRequestAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveRequestEventHandler handler)
	{
		handler.onReceiveRequest(this);
	}
}
