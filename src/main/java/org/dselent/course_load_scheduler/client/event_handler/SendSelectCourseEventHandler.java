package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendSelectCourseEvent;

import com.google.gwt.event.shared.EventHandler;


public interface SendSelectCourseEventHandler extends EventHandler {

	public void onSendSelectCourse(SendSelectCourseEvent evt);
}
