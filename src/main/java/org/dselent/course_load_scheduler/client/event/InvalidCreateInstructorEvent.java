package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidCreateInstructorAction;
import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCreateInstructorEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEditSectionEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class InvalidCreateInstructorEvent extends GwtEvent<InvalidCreateInstructorEventHandler> {

public static Type<InvalidCreateInstructorEventHandler> TYPE = new Type<InvalidCreateInstructorEventHandler>();
	
	private InvalidCreateInstructorAction action;
	
	public InvalidCreateInstructorEvent(InvalidCreateInstructorAction iica)
	{
		this.action = iica;
	}
	
	public InvalidCreateInstructorAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
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
