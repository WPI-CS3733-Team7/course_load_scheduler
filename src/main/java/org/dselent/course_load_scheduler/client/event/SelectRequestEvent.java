package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SelectRequestAction;
import org.dselent.course_load_scheduler.client.event_handler.SelectRequestEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class SelectRequestEvent extends DisplayEvent<SelectRequestAction, SelectRequestEventHandler>{
	public static Type<SelectRequestEventHandler> TYPE = new Type<SelectRequestEventHandler>();

	
	public SelectRequestEvent(SelectRequestAction action, HasWidgets container)
	{
		super(action, container);
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
