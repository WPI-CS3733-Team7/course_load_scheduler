package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendClickRequestTabAction;
import org.dselent.course_load_scheduler.client.event_handler.SendClickRequestTabEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendClickRequestTabEvent extends DisplayEvent<SendClickRequestTabAction, SendClickRequestTabEventHandler> {
	
	public static Type<SendClickRequestTabEventHandler> TYPE = new Type<SendClickRequestTabEventHandler>();
	
	public SendClickRequestTabEvent(SendClickRequestTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendClickRequestTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendClickRequestTabEventHandler handler)
	{
		handler.onSendClickRequestTab(this);
	}

}
