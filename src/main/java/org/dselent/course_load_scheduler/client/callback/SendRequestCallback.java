package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidRequestAction;
import org.dselent.course_load_scheduler.client.action.ReceiveRequestAction;
import org.dselent.course_load_scheduler.client.event.InvalidRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveRequestEvent;
import org.dselent.course_load_scheduler.client.translator.impl.UserRequestActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendRequestCallback extends DisplayCallback<JSONValue>
{
	public SendRequestCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		UserRequestActionTranslatorImpl RequestActionTranslator = new UserRequestActionTranslatorImpl();
		ReceiveRequestAction action = RequestActionTranslator.translateToAction(json);
		
		ReceiveRequestEvent event = new ReceiveRequestEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
	  
	@Override
	public void onFailure(Throwable caught)
	{
		// TODO
		// give better exception information
		// these stack traces are not helpful
		
		StringBuilder sb = new StringBuilder();
		
		StackTraceElement[] stackTraceElements = caught.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements)
		{
			sb.append(stackTraceElement.toString());
			sb.append("\n");
		}
		
		InvalidRequestAction ila = new InvalidRequestAction(sb.toString());
		InvalidRequestEvent ile = new InvalidRequestEvent(ila);
		eventBus.fireEvent(ile);
	}
}
