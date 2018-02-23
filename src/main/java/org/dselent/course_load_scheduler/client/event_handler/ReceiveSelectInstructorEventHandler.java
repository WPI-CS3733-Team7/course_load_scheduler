package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveSelectInstructorEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveSelectInstructorEventHandler extends EventHandler
{
	  public void onReceiveSelectInstructor(ReceiveSelectInstructorEvent evt);
}