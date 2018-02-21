package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveClickAccountTabAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveClickAccountTabEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveClickAccountTabEvent extends DisplayEvent<ReceiveClickAccountTabAction, ReceiveClickAccountTabEventHandler>
{
public static Type<ReceiveClickAccountTabEventHandler> TYPE = new Type<ReceiveClickAccountTabEventHandler>();
	
	public ReceiveClickAccountTabEvent(ReceiveClickAccountTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveClickAccountTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveClickAccountTabEventHandler handler)
	{
		handler.onReceiveClickAccountTab(this);
	}
}
