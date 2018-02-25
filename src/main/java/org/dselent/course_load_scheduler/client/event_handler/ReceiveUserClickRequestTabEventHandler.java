package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveUserClickRequestTabEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveUserClickRequestTabEventHandler extends EventHandler{
	public void onReceiveUserClickRequestTab(ReceiveUserClickRequestTabEvent evt);
}
