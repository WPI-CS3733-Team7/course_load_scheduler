package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendClickAccountTabEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendClickAccountTabEventHandler extends EventHandler
{
	void onSendClickAccountTab(SendClickAccountTabEvent sendClickAccountTabEvent);
}
