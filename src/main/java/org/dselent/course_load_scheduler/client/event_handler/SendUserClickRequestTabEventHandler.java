package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendUserClickRequestTabEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendUserClickRequestTabEventHandler extends EventHandler{
	void onSendUserClickRequestTab(SendUserClickRequestTabEvent evt);

}
