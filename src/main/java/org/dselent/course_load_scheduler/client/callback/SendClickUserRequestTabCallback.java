package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveClickRequestTabAction;
import org.dselent.course_load_scheduler.client.action.ReceiveClickUserRequestTabAction;
import org.dselent.course_load_scheduler.client.event.ReceiveClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveUserClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.translator.impl.ClickRequestTabActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendClickUserRequestTabCallback extends DisplayCallback<JSONValue>{
	public SendClickUserRequestTabCallback(SimpleEventBus eventBus, HasWidgets container)
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
		ClickUserRequestTabActionTranslatorImpl ClickUserRequestTabActionTranslator = new ClickUserRequestTabActionTranslatorImpl();
		ReceiveClickUserRequestTabAction action = ClickUserRequestTabActionTranslator.translateToAction(json);
		
		ReceiveUserClickRequestTabEvent event = new ReceiveUserClickRequestTabEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
	
}
