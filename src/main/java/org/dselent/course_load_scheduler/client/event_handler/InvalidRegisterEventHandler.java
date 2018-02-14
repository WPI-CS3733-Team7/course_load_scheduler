package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidRegisterEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidRegisterEventHandler extends EventHandler
{
	public void onInvalidRegister(InvalidRegisterEvent evt);
}
