package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendValidateEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendValidateEventHandler extends EventHandler {
	public void onSendValidate(SendValidateEvent evt);
}
