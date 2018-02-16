package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEditSectionEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class InvalidEditSectionEvent extends GwtEvent<InvalidEditSectionEventHandler> {

public static Type<InvalidEditSectionEventHandler> TYPE = new Type<InvalidEditSectionEventHandler>();
	
	private InvalidEditSectionAction action;
	
	public InvalidEditSectionEvent(InvalidEditSectionAction action)
	{
		this.action = action;
	}
	
	public InvalidEditSectionAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<InvalidEditSectionEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(InvalidEditSectionEventHandler handler)
	{
		handler.onInvalidEditSection(this);
	}
}
