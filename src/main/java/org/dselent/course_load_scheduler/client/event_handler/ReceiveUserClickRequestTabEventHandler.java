package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveClickRequestTabEvent;

public interface ReceiveUserClickRequestTabEventHandler {
	public void onReceiveClickRequestTab(ReceiveClickRequestTabEvent evt);
}
