package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveClickScheduleTabEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveClickScheduleTabEvent extends DisplayEvent<ReceiveClickScheduleTabAction, ReceiveClickScheduleTabEventHandler> {
	
public static Type<ReceiveClickScheduleTabEventHandler> TYPE = new Type<ReceiveClickScheduleTabEventHandler>();
	
	public ReceiveClickScheduleTabEvent(ReceiveClickScheduleTabAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveClickScheduleTabEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveClickScheduleTabEventHandler handler)
	{
		handler.onReceiveClickScheduleTab(this);
	}

}
