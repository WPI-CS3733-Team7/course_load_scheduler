package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.event_handler.SendValidateEventHandler;
import com.google.gwt.event.shared.GwtEvent;;

public class SendValidateEvent extends GwtEvent<SendValidateEventHandler> {
	
	public static Type<SendValidateEventHandler> TYPE = new Type<SendValidateEventHandler>();
	
	private SendValidateAction action;
	
	public SendValidateEvent(SendValidateAction action)
	{
		this.action = action;
	}
	
	public SendValidateAction getAction()
	{
		return action;
	}
	
	/*
	 * 
	 */
	@Override
	public Type<SendValidateEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	/*
	 * 
	 */
	@Override
	protected void dispatch(SendValidateEventHandler handler)
	{
		handler.onSendValidate(this);
	}
}
