package org.dselent.course_load_scheduler.client.event_handler;
	
import org.dselent.course_load_scheduler.client.event.SendEditUserEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendEditUserEventHandler extends EventHandler
{
	void onSendEditUser(SendEditUserEvent evt);
}

