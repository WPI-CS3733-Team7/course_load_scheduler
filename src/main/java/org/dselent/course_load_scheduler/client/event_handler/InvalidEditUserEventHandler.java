package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidEditUserEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidEditUserEventHandler extends EventHandler
{		
	public void onInvalidEditUser(InvalidEditUserEvent evt);
}

