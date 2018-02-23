package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidCreateCourseAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSelectCourseAction;
import org.dselent.course_load_scheduler.client.event.InvalidCreateCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectCourseEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SelectCourseActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendSelectCourseCallback extends DisplayCallback<JSONValue> {
	
	public SendSelectCourseCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		SelectCourseActionTranslatorImpl selectCourseActionTranslator = new SelectCourseActionTranslatorImpl();
		ReceiveSelectCourseAction action = selectCourseActionTranslator.translateToAction(json);
		
		ReceiveSelectCourseEvent event = new ReceiveSelectCourseEvent(action, getContainer());
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
		
		InvalidCreateCourseAction icca = new InvalidCreateCourseAction(sb.toString());
		InvalidCreateCourseEvent icce = new InvalidCreateCourseEvent(icca);
		eventBus.fireEvent(icce);
	}

}
