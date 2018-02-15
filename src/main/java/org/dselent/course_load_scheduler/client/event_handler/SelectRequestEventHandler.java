package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SelectRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SelectRequestEventHandler extends EventHandler{
	public void onSelectRequest(SelectRequestEvent evt);
}
