package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveRequestEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveRequestEventHandler extends EventHandler
{
	  public void onReceiveRequest(ReceiveRequestEvent evt);
}