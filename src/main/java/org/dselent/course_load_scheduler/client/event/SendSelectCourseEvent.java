package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSelectCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSelectCourseEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendSelectCourseEvent extends DisplayEvent<SendSelectCourseAction, SendSelectCourseEventHandler>{

	public static Type<SendSelectCourseEventHandler> TYPE = new Type<SendSelectCourseEventHandler>();
	
	public SendSelectCourseEvent(SendSelectCourseAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendSelectCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSelectCourseEventHandler handler)
	{
		handler.onSendSelectCourse(this);
	}
	
}
