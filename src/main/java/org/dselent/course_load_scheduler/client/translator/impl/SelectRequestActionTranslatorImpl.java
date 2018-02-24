package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveSelectRequestAction;
import org.dselent.course_load_scheduler.client.action.SelectRequestAction;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSelectRequestKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendSelectRequestKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SelectRequestActionTranslatorImpl implements ActionTranslator<SelectRequestAction, ReceiveSelectRequestAction>{
	
	@Override
	public JSONObject translateToJson(SelectRequestAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendSelectRequestKeys.REQUEST_ID), action.getrequester());
			
		return jsonObject;
		
	}

	@Override
	public ReceiveSelectRequestAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONObject selectRequestObject = jsonObject.isArray().get(0).isObject();
		
		Integer requesterId = JSONHelper.getIntValue(selectRequestObject, JSONHelper.convertKeyName(ReceiveSelectRequestKeys.REQUESTER_ID));
		String requestType = JSONHelper.getStringValue(selectRequestObject, JSONHelper.convertKeyName(ReceiveSelectRequestKeys.REQUEST_TYPE));
		String requestDetail = JSONHelper.getStringValue(selectRequestObject, JSONHelper.convertKeyName(ReceiveSelectRequestKeys.REQUEST_DETAIL));
		
		ReceiveSelectRequestAction action = new ReceiveSelectRequestAction(requesterId, requestType, requestDetail);
		return action;
	}
}
