package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.event_handler.SendClickScheduleTabEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendClickScheduleTabEvent extends DisplayEvent<SendClickScheduleTabAction, SendClickScheduleTabEventHandler> {
	
public static Type<SendClickScheduleTabEventHandler> TYPE = new Type<SendClickScheduleTabEventHandler>();
	
	public SendClickScheduleTabEvent(SendClickScheduleTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendClickScheduleTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendClickScheduleTabEventHandler handler)
	{
		handler.onSendClickScheduleTab(this);
	}

}
