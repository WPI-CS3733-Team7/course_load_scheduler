package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveEditInstructorEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveEditInstructorEventHandler extends EventHandler
{
	  public void onReceiveEditInstructor(ReceiveEditInstructorEvent evt);
}