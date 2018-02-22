package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveClickAccountTabEvent;
import com.google.gwt.event.shared.EventHandler;

public interface ReceiveClickAccountTabEventHandler extends EventHandler
{
	public void onReceiveClickAccountTab(ReceiveClickAccountTabEvent evt);
}
