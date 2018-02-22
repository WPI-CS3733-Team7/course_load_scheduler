package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveClickScheduleTabEvent;
import com.google.gwt.event.shared.EventHandler;

public interface ReceiveClickScheduleTabEventHandler extends EventHandler {
	
	public void onReceiveClickScheduleTab(ReceiveClickScheduleTabEvent evt);

}
