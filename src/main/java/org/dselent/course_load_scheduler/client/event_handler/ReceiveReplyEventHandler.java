package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveReplyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveReplyEventHandler extends EventHandler
{
	  public void onReceiveReply(ReceiveReplyEvent evt);
}