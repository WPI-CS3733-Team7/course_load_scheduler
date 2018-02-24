package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidSelectRequestAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSelectRequestAction;
import org.dselent.course_load_scheduler.client.event.InvalidSelectRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectRequestEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SelectRequestActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;


public class SendSelectRequestCallback extends DisplayCallback<JSONValue>{
	public SendSelectRequestCallback(SimpleEventBus eventBus, HasWidgets container)
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
		
		InvalidSelectRequestAction isra = new InvalidSelectRequestAction(sb.toString());
		InvalidSelectRequestEvent isre = new InvalidSelectRequestEvent(isra);
		eventBus.fireEvent(isre);
	}

	@Override
	public void onSuccess(JSONValue result) {

		JSONObject json = JSONHelper.getObjectValue(result);
		SelectRequestActionTranslatorImpl selectRequestActionTranslator = new SelectRequestActionTranslatorImpl();
		ReceiveSelectRequestAction action = selectRequestActionTranslator.translateToAction(json);
		
		ReceiveSelectRequestEvent event = new ReceiveSelectRequestEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
}
