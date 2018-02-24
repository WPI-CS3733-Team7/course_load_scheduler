package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendClickRequestTabEvent;

public interface SendUserClickRequestTabEventHandler {
	void onSendClickRequestTab(SendClickRequestTabEvent evt);
}
