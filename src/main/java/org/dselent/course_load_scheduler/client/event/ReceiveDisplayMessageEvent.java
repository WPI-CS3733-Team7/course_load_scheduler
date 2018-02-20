package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveDisplayMessageAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveDisplayMessageEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveDisplayMessageEvent extends DisplayEvent<ReceiveDisplayMessageAction, ReceiveDisplayMessageEventHandler>
{
	public static Type<ReceiveDisplayMessageEventHandler> TYPE = new Type<ReceiveDisplayMessageEventHandler>();
	
	public ReceiveDisplayMessageEvent(ReceiveDisplayMessageAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveDisplayMessageEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveDisplayMessageEventHandler handler)
	{
		handler.onReceiveDisplayMessage(this);
	}
}
