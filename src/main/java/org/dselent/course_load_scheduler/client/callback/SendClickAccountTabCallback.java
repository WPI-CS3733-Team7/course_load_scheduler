package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveClickAccountTabAction;
import org.dselent.course_load_scheduler.client.event.ReceiveClickAccountTabEvent;
import org.dselent.course_load_scheduler.client.translator.impl.ClickAccountTabActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendClickAccountTabCallback  extends DisplayCallback<JSONValue>
{
	public SendClickAccountTabCallback(SimpleEventBus eventBus, HasWidgets container)
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
		ClickAccountTabActionTranslatorImpl clickAccountTabActionTranslator = new ClickAccountTabActionTranslatorImpl();
		ReceiveClickAccountTabAction action = clickAccountTabActionTranslator.translateToAction(json);
		
		ReceiveClickAccountTabEvent event = new ReceiveClickAccountTabEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
}
