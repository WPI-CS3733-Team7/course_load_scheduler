package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveClickUserRequestTabAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveUserClickRequestTabEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveUserClickRequestTabEvent extends DisplayEvent<ReceiveClickUserRequestTabAction, ReceiveUserClickRequestTabEventHandler>
{
public static Type<ReceiveUserClickRequestTabEventHandler> TYPE = new Type<ReceiveUserClickRequestTabEventHandler>();
	
	public ReceiveUserClickRequestTabEvent(ReceiveClickUserRequestTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveUserClickRequestTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveUserClickRequestTabEventHandler handler)
	{
		handler.onReceiveUserClickRequestTab(this);
	}
	
}
