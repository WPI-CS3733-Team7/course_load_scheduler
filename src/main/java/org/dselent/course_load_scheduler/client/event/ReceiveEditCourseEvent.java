package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveEditCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveEditCourseEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveEditCourseEvent extends DisplayEvent<ReceiveEditCourseAction, ReceiveEditCourseEventHandler>
{
	public static Type<ReceiveEditCourseEventHandler> TYPE = new Type<ReceiveEditCourseEventHandler>();
	
	public ReceiveEditCourseEvent(ReceiveEditCourseAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveEditCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveEditCourseEventHandler handler)
	{
		handler.onReceiveEditCourse(this);
	}
}
