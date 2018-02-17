package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendDisplayMessageEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendDisplayMessageEventHandler extends EventHandler
{
	void onSendDisplayMessage(SendDisplayMessageEvent evt);
}
