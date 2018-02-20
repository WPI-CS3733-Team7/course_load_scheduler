package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveValidateEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveValidateEventHandler extends EventHandler
{
	  public void onReceiveValidate(ReceiveValidateEvent evt);
}