package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidReplyAction;
import org.dselent.course_load_scheduler.client.action.ReceiveReplyAction;
import org.dselent.course_load_scheduler.client.event.InvalidReplyEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveReplyEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendReplyActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;


public class SendReplyCallback extends DisplayCallback<JSONValue>
{
	public SendReplyCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}

	@Override
	public void onFailure(Throwable caught) {
		StringBuilder sb = new StringBuilder();
		
		StackTraceElement[] stackTraceElements = caught.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements)
		{
			sb.append(stackTraceElement.toString());
			sb.append("\n");
		}
		
		InvalidReplyAction ira = new InvalidReplyAction(sb.toString());
		InvalidReplyEvent ire = new InvalidReplyEvent(ira);
		eventBus.fireEvent(ire);
		
	}

	@Override
	public void onSuccess(JSONValue result) {
		JSONObject json = JSONHelper.getObjectValue(result);
		SendReplyActionTranslatorImpl sendReplyActionTranslator = new SendReplyActionTranslatorImpl();
		ReceiveReplyAction action = sendReplyActionTranslator.translateToAction(json);
		
		ReceiveReplyEvent event = new ReceiveReplyEvent(action, getContainer());
		eventBus.fireEvent(event);
		
	}

}
