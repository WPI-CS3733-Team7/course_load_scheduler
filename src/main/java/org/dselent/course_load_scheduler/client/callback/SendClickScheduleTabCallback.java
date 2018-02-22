package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.event.ReceiveClickScheduleTabEvent;
import org.dselent.course_load_scheduler.client.translator.impl.ClickScheduleTabActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendClickScheduleTabCallback extends DisplayCallback<JSONValue> {
	
	public SendClickScheduleTabCallback(SimpleEventBus eventBus, HasWidgets container)
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
		ClickScheduleTabActionTranslatorImpl clickScheduleTabActionTranslator = new ClickScheduleTabActionTranslatorImpl();
		ReceiveClickScheduleTabAction action = clickScheduleTabActionTranslator.translateToAction(json);
		
		ReceiveClickScheduleTabEvent event = new ReceiveClickScheduleTabEvent(action, getContainer());
		eventBus.fireEvent(event);
	}

}
