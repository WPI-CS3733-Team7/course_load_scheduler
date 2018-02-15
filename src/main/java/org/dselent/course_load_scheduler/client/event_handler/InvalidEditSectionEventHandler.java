package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import com.google.gwt.event.shared.EventHandler;

public interface InvalidEditSectionEventHandler extends EventHandler {
	
	public void onInvalidEditSection(InvalidEditSectionEvent evt);

}
