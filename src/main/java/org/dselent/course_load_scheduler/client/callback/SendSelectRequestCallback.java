package org.dselent.course_load_scheduler.client.callback;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;


public class SendSelectRequestCallback extends DisplayCallback<JSONValue>{
	public SendSelectRequestCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}

	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(JSONValue result) {
		// TODO Auto-generated method stub
		
	}
}
