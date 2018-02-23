package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.ReceiveValidateAction;
import org.dselent.course_load_scheduler.client.event.ReceiveValidateEvent;
import org.dselent.course_load_scheduler.client.translator.impl.ValidateActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendValidateCallback extends DisplayCallback<JSONValue> {
	
	public SendValidateCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}
	  
	@Override
	public void onSuccess(JSONValue result)
	{
		JSONObject json = JSONHelper.getObjectValue(result);
		ValidateActionTranslatorImpl validateActionTranslator = new ValidateActionTranslatorImpl();
		ReceiveValidateAction action = validateActionTranslator.translateToAction(json);
		
		if(action.getInstructorList().isEmpty() == true && action.getCourseList().isEmpty() == true) {
			action.setMessage("Success!");
			ReceiveValidateEvent event = new ReceiveValidateEvent(action, getContainer());
			eventBus.fireEvent(event);
		}
		
		else if(action.getInstructorList().isEmpty() == false) {
			action.setMessage("ERROR: the selected instructor is not valid.");
		}
		else if(action.getCourseList().isEmpty() == false) {
			action.setMessage("ERROR: the selected course is not valid.");
		}
		else if(action.getInstructorList().isEmpty() == false && action.getCourseList().isEmpty() == false) {
			action.setMessage("ERROR: neither the selected instructor nor the selected course are valid.");
		}
	}

	@Override
	public void onFailure(Throwable caught) {
		// THIS SHOULD NEVER FAIL
	}
}
