package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface CreateRequestEventHandler extends EventHandler
{
	public void onCreateRequest(CreateRequestEvent evt);
}
