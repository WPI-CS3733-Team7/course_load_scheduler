package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendRegisterEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendRegisterEventHandler extends EventHandler 
{
	public void onSendRegister(SendRegisterEvent evt);
}
