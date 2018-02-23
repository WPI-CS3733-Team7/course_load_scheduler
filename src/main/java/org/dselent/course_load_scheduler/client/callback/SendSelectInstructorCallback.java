package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidCreateInstructorAction;
import org.dselent.course_load_scheduler.client.action.ReceiveEditInstructorAction;
import org.dselent.course_load_scheduler.client.event.InvalidCreateInstructorEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditInstructorEvent;
import org.dselent.course_load_scheduler.client.translator.impl.EditInstructorActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SelectInstructorActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendSelectInstructorCallback extends DisplayCallback<JSONValue>
{

	public SendSelectInstructorCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		SelectInstructorActionTranslatorImpl selectInstructorActionTranslator = new SelectInstructorActionTranslatorImpl();
		ReceiveSelectInstructorAction action = selectInstructorActionTranslator.translateToAction(json);
		
		ReceiveSelectInstructorEvent event = new ReceiveSelectInstructorEvent(action, getContainer());
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
		
		InvalidCreateInstructorAction icia = new InvalidCreateInstructorAction(sb.toString());
		InvalidCreateInstructorEvent icie = new InvalidCreateInstructorEvent(icia);
		eventBus.fireEvent(icie);
	}
	
}
