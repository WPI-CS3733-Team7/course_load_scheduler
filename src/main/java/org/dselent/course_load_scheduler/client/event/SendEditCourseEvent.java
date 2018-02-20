package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditCourseEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendEditCourseEvent extends DisplayEvent<SendEditCourseAction, SendEditCourseEventHandler>{

	public static Type<SendEditCourseEventHandler> TYPE = new Type<SendEditCourseEventHandler>();
	
	public SendEditCourseEvent(SendEditCourseAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendEditCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditCourseEventHandler handler)
	{
		handler.onSendEditCourse(this);
	}
	
}
