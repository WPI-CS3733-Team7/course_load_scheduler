package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveEditUserEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveEditUserEventHandler extends EventHandler
{
	  public void onReceiveEditUser(ReceiveEditUserEvent evt);
}