package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveSelectCourseEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveSelectCourseEventHandler extends EventHandler
{
	  public void onReceiveSelectCourse(ReceiveSelectCourseEvent evt);
}