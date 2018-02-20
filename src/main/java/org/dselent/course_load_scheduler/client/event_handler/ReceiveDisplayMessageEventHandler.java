package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveDisplayMessageEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveDisplayMessageEventHandler extends EventHandler
{
	  public void onReceiveDisplayMessage(ReceiveDisplayMessageEvent evt);
}