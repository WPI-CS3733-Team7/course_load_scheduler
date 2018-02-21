package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.action.ReceiveEditSectionAction;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditSectionEvent;
import org.dselent.course_load_scheduler.client.translator.impl.EditSectionActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendEditSectionCallback extends DisplayCallback<JSONValue> {
	
	public SendEditSectionCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		EditSectionActionTranslatorImpl editSectionActionTranslator = new EditSectionActionTranslatorImpl();
		ReceiveEditSectionAction action = editSectionActionTranslator.translateToAction(json);
		
		ReceiveEditSectionEvent event = new ReceiveEditSectionEvent(action, getContainer());
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
		
		InvalidEditSectionAction iesa = new InvalidEditSectionAction(sb.toString());
		InvalidEditSectionEvent iese = new InvalidEditSectionEvent(iesa);
		eventBus.fireEvent(iese);
	}

}
