package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidEditUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveEditUserAction;
import org.dselent.course_load_scheduler.client.event.InvalidEditUserEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditUserEvent;
import org.dselent.course_load_scheduler.client.translator.impl.EditUserActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendEditUserCallback extends DisplayCallback<JSONValue>
{
	public SendEditUserCallback(SimpleEventBus eventBus, HasWidgets container)
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
		
		InvalidEditUserAction ieua = new InvalidEditUserAction(sb.toString());
		InvalidEditUserEvent ieue = new InvalidEditUserEvent(ieua);
		eventBus.fireEvent(ieue);
	}

	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		EditUserActionTranslatorImpl editUserActionTranslator = new EditUserActionTranslatorImpl();
		ReceiveEditUserAction action = editUserActionTranslator.translateToAction(json);
		
		ReceiveEditUserEvent event = new ReceiveEditUserEvent(action, getContainer());
		eventBus.fireEvent(event);
	}

}
