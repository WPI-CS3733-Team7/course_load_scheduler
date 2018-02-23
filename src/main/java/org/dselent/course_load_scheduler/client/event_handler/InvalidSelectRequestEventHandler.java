package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidSelectRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidSelectRequestEventHandler extends EventHandler{
	public void onInvalidSelectRequest(InvalidSelectRequestEvent evt);
}
