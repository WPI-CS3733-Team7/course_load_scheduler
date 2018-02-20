package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveLogoutEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveLogoutEventHandler extends EventHandler
{
	  public void onReceiveLogout(ReceiveLogoutEvent evt);
}