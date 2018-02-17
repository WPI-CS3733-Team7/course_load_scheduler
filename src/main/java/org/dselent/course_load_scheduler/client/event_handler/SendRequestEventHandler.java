package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendRequestEventHandler extends EventHandler{
	public void onSendRequest(SendRequestEvent evt);
}
