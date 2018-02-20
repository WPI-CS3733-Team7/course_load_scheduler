package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidCreateInstructorAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCreateInstructorEventHandler;

public class InvalidCreateInstructorEvent extends BaseEvent<InvalidCreateInstructorAction, InvalidCreateInstructorEventHandler> {

public static Type<InvalidCreateInstructorEventHandler> TYPE = new Type<InvalidCreateInstructorEventHandler>();
	
	public InvalidCreateInstructorEvent(InvalidCreateInstructorAction iica)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidCreateInstructorEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidCreateInstructorEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onInvalidCreateInstructor(this);
	}
}
