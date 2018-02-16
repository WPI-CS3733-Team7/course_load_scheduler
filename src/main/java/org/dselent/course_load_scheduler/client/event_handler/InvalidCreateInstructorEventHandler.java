package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidCreateInstructorEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import com.google.gwt.event.shared.EventHandler;

public interface InvalidCreateInstructorEventHandler extends EventHandler {
	
	public void onInvalidCreateInstructor(InvalidCreateInstructorEvent evt);

}
