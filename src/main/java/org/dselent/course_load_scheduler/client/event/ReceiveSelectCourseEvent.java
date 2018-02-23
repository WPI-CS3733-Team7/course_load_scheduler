package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSelectCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSelectCourseEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSelectCourseEvent extends DisplayEvent<ReceiveSelectCourseAction, ReceiveSelectCourseEventHandler>
{
	public static Type<ReceiveSelectCourseEventHandler> TYPE = new Type<ReceiveSelectCourseEventHandler>();
	
	public ReceiveSelectCourseEvent(ReceiveSelectCourseAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveSelectCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveSelectCourseEventHandler handler)
	{
		handler.onReceiveSelectCourse(this);
	}
}
