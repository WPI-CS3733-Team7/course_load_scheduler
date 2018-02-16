package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendLogoutEventHandler extends EventHandler
{
	public void onSendLogout(SendLogoutEvent evt);
}
