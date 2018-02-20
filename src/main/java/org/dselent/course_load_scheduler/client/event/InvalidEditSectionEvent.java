package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEditSectionEventHandler;

public class InvalidEditSectionEvent extends BaseEvent<InvalidEditSectionAction, InvalidEditSectionEventHandler> {

public static Type<InvalidEditSectionEventHandler> TYPE = new Type<InvalidEditSectionEventHandler>();
	
	public InvalidEditSectionEvent(InvalidEditSectionAction action)
	{
		super(action);
	}
	
	@Override
	public Type<InvalidEditSectionEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidEditSectionEventHandler handler)
	{
		handler.onInvalidEditSection(this);
	}
}
