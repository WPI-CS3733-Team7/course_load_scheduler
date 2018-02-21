package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendClickAccountTabAction;
import org.dselent.course_load_scheduler.client.event_handler.SendClickAccountTabEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendClickAccountTabEvent extends DisplayEvent<SendClickAccountTabAction, SendClickAccountTabEventHandler>
{
	public static Type<SendClickAccountTabEventHandler> TYPE = new Type<SendClickAccountTabEventHandler>();
	
	public SendClickAccountTabEvent(SendClickAccountTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendClickAccountTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendClickAccountTabEventHandler handler)
	{
		handler.onSendClickAccountTab(this);
	}
}
