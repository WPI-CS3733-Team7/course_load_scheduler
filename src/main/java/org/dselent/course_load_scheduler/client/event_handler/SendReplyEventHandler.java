package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendReplyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendReplyEventHandler extends EventHandler{
	public void onSendReply(SendReplyEvent evt);
}
