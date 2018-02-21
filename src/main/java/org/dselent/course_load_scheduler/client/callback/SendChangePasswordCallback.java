package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidChangePasswordAction;
import org.dselent.course_load_scheduler.client.action.ReceiveChangePasswordAction;
import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import org.dselent.course_load_scheduler.client.translator.impl.ChangePasswordActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendChangePasswordCallback extends DisplayCallback<JSONValue>
{
	public SendChangePasswordCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		ChangePasswordActionTranslatorImpl changePasswordActionTranslator = new ChangePasswordActionTranslatorImpl();
		ReceiveChangePasswordAction action = changePasswordActionTranslator.translateToAction(json);
		
		ReceiveChangePasswordEvent event = new ReceiveChangePasswordEvent(action, getContainer());
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
		
		InvalidChangePasswordAction icpa = new InvalidChangePasswordAction(sb.toString());
		InvalidChangePasswordEvent icpe = new InvalidChangePasswordEvent(icpa);
		eventBus.fireEvent(icpe);
	}

}
