package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendClickRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickUserRequestTabAction;
import org.dselent.course_load_scheduler.client.event_handler.SendClickRequestTabEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendUserClickRequestTabEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendUserClickRequestTabEvent extends DisplayEvent<SendClickUserRequestTabAction, SendUserClickRequestTabEventHandler> 
{
	public static Type<SendUserClickRequestTabEventHandler> TYPE = new Type<SendUserClickRequestTabEventHandler>();
	
	public SendUserClickRequestTabEvent(SendClickUserRequestTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendUserClickRequestTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendUserClickRequestTabEventHandler handler)
	{
		handler.onSendUserClickRequestTab(this);
	}
	
}
