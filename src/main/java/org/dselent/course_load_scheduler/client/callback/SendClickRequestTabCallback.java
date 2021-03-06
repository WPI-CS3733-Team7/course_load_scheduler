package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveClickRequestTabAction;
import org.dselent.course_load_scheduler.client.event.ReceiveClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.translator.impl.ClickRequestTabActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendClickRequestTabCallback extends DisplayCallback<JSONValue>{
	public SendClickRequestTabCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}

	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		
		// Should never fail
	}

	@Override
	public void onSuccess(JSONValue result)
	{	
		JSONObject json = JSONHelper.getObjectValue(result);
		ClickRequestTabActionTranslatorImpl ClickRequestTabActionTranslator = new ClickRequestTabActionTranslatorImpl();
		ReceiveClickRequestTabAction action = ClickRequestTabActionTranslator.translateToAction(json);
		
		ReceiveClickRequestTabEvent event = new ReceiveClickRequestTabEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
}
