package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveRegisterAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveRegisterEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveRegisterEvent extends DisplayEvent<ReceiveRegisterAction, ReceiveRegisterEventHandler>
{
	public static Type<ReceiveRegisterEventHandler> TYPE = new Type<ReceiveRegisterEventHandler>();
	
	public ReceiveRegisterEvent(ReceiveRegisterAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveRegisterEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveRegisterEventHandler handler)
	{
		handler.onReceiveRegister(this);
	}
}