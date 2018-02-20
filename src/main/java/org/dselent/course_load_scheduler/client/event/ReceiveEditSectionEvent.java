package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveEditSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveEditSectionEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveEditSectionEvent extends DisplayEvent<ReceiveEditSectionAction, ReceiveEditSectionEventHandler>
{
	public static Type<ReceiveEditSectionEventHandler> TYPE = new Type<ReceiveEditSectionEventHandler>();
	
	public ReceiveEditSectionEvent(ReceiveEditSectionAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<ReceiveEditSectionEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveEditSectionEventHandler handler)
	{
		handler.onReceiveEditSection(this);
	}
}
