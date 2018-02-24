package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveSelectRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveSelectRequestEventHandler extends EventHandler{
	public void onReceiveSelectRequest(ReceiveSelectRequestEvent evt);
}
