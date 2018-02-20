package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditSectionAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditSectionEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendEditSectionEvent extends DisplayEvent<SendEditSectionAction, SendEditSectionEventHandler>{

	public static Type<SendEditSectionEventHandler> TYPE = new Type<SendEditSectionEventHandler>();
	
	public SendEditSectionEvent(SendEditSectionAction action, HasWidgets container)
	{
		super(action, container);
	}

	@Override
	public Type<SendEditSectionEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditSectionEventHandler handler)
	{
		handler.onSendEditSection(this);
	}
	
}
