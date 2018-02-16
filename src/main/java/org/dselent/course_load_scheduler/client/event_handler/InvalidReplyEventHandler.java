package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidReplyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidReplyEventHandler extends EventHandler
{
	public void onInvalidReply(InvalidReplyEvent evt);
}
