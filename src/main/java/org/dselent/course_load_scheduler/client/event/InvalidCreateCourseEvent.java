package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidCreateCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCreateCourseEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class InvalidCreateCourseEvent extends GwtEvent<InvalidCreateCourseEventHandler> {

public static Type<InvalidCreateCourseEventHandler> TYPE = new Type<InvalidCreateCourseEventHandler>();
	
	private InvalidCreateCourseAction action;
	
	public InvalidCreateCourseEvent(InvalidCreateCourseAction icca)
	{
		this.action = icca;
	}
	
	public InvalidCreateCourseAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
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
