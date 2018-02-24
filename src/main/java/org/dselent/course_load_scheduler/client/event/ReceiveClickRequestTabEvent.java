package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveClickRequestTabAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveClickRequestTabEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveClickRequestTabEvent extends DisplayEvent<ReceiveClickRequestTabAction, ReceiveClickRequestTabEventHandler>
{
public static Type<ReceiveClickRequestTabEventHandler> TYPE = new Type<ReceiveClickRequestTabEventHandler>();
	
	public ReceiveClickRequestTabEvent(ReceiveClickRequestTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveClickRequestTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveClickRequestTabEventHandler handler)
	{
		handler.onReceiveClickRequestTab(this);
	}

}
