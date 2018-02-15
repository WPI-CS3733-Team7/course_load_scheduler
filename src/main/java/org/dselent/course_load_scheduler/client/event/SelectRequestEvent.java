package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SelectRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.SelectRequestEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SelectRequestEvent extends GwtEvent<SelectRequestEventHandler>{
	public static Type<SelectRequestEventHandler> TYPE = new Type<SelectRequestEventHandler>();
	
	private SelectRequestAction action;
	
	public SelectRequestEvent(SelectRequestAction action)
	{
		this.action = action;
	}
	
	public SelectRequestAction getAction()
	{
		return action;
	}
	
	
	@Override
	public Type<SelectRequestEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SelectRequestEventHandler handler)
	{
		handler.onSelectRequest(this);
	}
}
