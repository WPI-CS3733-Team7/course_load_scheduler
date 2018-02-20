package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveValidateAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveValidateEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveValidateEvent extends DisplayEvent<ReceiveValidateAction, ReceiveValidateEventHandler>
{
	public static Type<ReceiveValidateEventHandler> TYPE = new Type<ReceiveValidateEventHandler>();
	
	public ReceiveValidateEvent(ReceiveValidateAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveValidateEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveValidateEventHandler handler)
	{
		handler.onReceiveValidate(this);
	}
}
