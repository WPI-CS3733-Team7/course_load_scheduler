package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendSelectInstructorEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendSelectInstructorEventHandler extends EventHandler {
	
	public void onSendSelectInstructor(SendSelectInstructorEvent evt);

}
