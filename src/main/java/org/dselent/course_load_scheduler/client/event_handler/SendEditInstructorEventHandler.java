package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendEditInstructorEventHandler extends EventHandler {
	
	public void onSendEditInstructor(SendEditInstructorEvent evt);

}
