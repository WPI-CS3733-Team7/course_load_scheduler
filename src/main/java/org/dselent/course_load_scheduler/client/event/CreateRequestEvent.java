package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.CreateRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.CreateRequestEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SelectRequestEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class CreateRequestEvent extends GwtEvent<CreateRequestEventHandler>{
	public static Type<CreateRequestEventHandler> TYPE = new Type<CreateRequestEventHandler>();
	
	private CreateRequestAction action;
	
	public CreateRequestEvent(CreateRequestAction action)
	{
		this.action = action;
	}
	
	public CreateRequestAction getAction()
	{
		return action;
	}
	
	
	@Override
	public Type<CreateRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(CreateRequestEventHandler handler)
	{
		handler.onCreateRequest(this);
	}
}
