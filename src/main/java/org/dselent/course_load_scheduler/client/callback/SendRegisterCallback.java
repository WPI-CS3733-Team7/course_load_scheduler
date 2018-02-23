package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidRegisterAction;
import org.dselent.course_load_scheduler.client.action.ReceiveRegisterAction;
import org.dselent.course_load_scheduler.client.event.InvalidRegisterEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveRegisterEvent;
import org.dselent.course_load_scheduler.client.translator.impl.RegisterActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendRegisterCallback extends DisplayCallback<JSONValue>
{
	public SendRegisterCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
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
		
		InvalidRegisterAction ira = new InvalidRegisterAction(sb.toString());
		InvalidRegisterEvent ire = new InvalidRegisterEvent(ira);
		eventBus.fireEvent(ire);
	}

	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		RegisterActionTranslatorImpl registerActionTranslator = new RegisterActionTranslatorImpl();
		ReceiveRegisterAction action = registerActionTranslator.translateToAction(json);
		
		ReceiveRegisterEvent event = new ReceiveRegisterEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
}