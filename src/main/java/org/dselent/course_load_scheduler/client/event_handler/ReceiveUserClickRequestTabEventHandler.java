package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveUserClickRequestTabEvent;

public interface ReceiveUserClickRequestTabEventHandler {
	public void onReceiveUserClickRequestTab(ReceiveUserClickRequestTabEvent evt);
}
