package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendClickRequestTabEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendClickRequestTabEventHandler extends EventHandler
{
	void onSendClickRequestTab(SendClickRequestTabEvent evt);
}
