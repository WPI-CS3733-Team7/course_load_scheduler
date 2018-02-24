package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveClickRequestTabEvent;


import com.google.gwt.event.shared.EventHandler;

public interface ReceiveClickRequestTabEventHandler extends EventHandler
{
	public void onReceiveClickRequestTab(ReceiveClickRequestTabEvent evt);

}
