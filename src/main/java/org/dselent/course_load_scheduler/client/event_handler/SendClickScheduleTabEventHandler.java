package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendClickScheduleTabEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendClickScheduleTabEventHandler extends EventHandler {
	
	void onSendClickScheduleTab(SendClickScheduleTabEvent sendClickScheduleTabEvent);

}
