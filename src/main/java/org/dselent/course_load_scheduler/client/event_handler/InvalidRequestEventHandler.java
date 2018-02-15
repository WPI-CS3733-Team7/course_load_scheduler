package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidRequestEventHandler extends EventHandler{
	 public void onInvalidRequest(InvalidRequestEvent evt);
}
