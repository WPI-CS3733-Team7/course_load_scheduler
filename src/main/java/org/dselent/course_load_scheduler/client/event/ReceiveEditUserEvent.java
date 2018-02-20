package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveEditUserAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveEditUserEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveEditUserEvent extends DisplayEvent<ReceiveEditUserAction, ReceiveEditUserEventHandler>
{
	public static Type<ReceiveEditUserEventHandler> TYPE = new Type<ReceiveEditUserEventHandler>();
	
	public ReceiveEditUserEvent(ReceiveEditUserAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveEditUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveEditUserEventHandler handler)
	{
		handler.onReceiveEditUser(this);
	}
}
