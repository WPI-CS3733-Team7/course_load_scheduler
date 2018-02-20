package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidCreateCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCreateCourseEventHandler;

public class InvalidCreateCourseEvent extends BaseEvent<InvalidCreateCourseAction, InvalidCreateCourseEventHandler> {

public static Type<InvalidCreateCourseEventHandler> TYPE = new Type<InvalidCreateCourseEventHandler>();
	
	public InvalidCreateCourseEvent(InvalidCreateCourseAction icca)
	{
		super(action);
	}

	@Override
	public Type<InvalidCreateCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}


	@Override
	protected void dispatch(InvalidCreateCourseEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onInvalidCreateCourse(this);
	}
}
