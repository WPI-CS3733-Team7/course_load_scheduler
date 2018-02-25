package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidCreateInstructorAction;
import org.dselent.course_load_scheduler.client.action.ReceiveEditInstructorAction;
import org.dselent.course_load_scheduler.client.event.InvalidCreateInstructorEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditInstructorEvent;
import org.dselent.course_load_scheduler.client.translator.impl.EditInstructorActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendEditInstructorCallback extends DisplayCallback<JSONValue>
{
	public SendEditInstructorCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		EditInstructorActionTranslatorImpl editInstructorActionTranslator = new EditInstructorActionTranslatorImpl();
		ReceiveEditInstructorAction action = editInstructorActionTranslator.translateToAction(json);
		
		ReceiveEditInstructorEvent event = new ReceiveEditInstructorEvent(action, getContainer());
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
		
		InvalidCreateInstructorAction icia = new InvalidCreateInstructorAction("Failed."/*sb.toString()*/);
		InvalidCreateInstructorEvent icie = new InvalidCreateInstructorEvent(icia);
		eventBus.fireEvent(icie);
	}
	
}
