package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.event_handler.SendValidateEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendValidateEvent extends DisplayEvent<SendValidateAction, SendValidateEventHandler> {
	
	public static Type<SendValidateEventHandler> TYPE = new Type<SendValidateEventHandler>();
	
	public SendValidateEvent(SendValidateAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendValidateEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendValidateEventHandler handler)
	{
		handler.onSendValidate(this);
	}
}
