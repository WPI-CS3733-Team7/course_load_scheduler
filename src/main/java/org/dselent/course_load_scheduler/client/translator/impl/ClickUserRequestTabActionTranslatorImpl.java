package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveClickUserRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickUserRequestTabAction;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveRequestKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ClickUserRequestTabActionTranslatorImpl implements ActionTranslator<SendClickUserRequestTabAction, ReceiveClickUserRequestTabAction>{

	@Override
	public JSONObject translateToJson(SendClickUserRequestTabAction object) {
		JSONObject jsonObject = new JSONObject();		
		return jsonObject;
	}

	@Override
	public ReceiveClickUserRequestTabAction translateToAction(JSONObject json) {
		// TODO Auto-generated method stub
		JSONValue jsonObject = json.get("success");
		JSONObject returnObject = jsonObject.isArray().get(0).isObject();
		
		
		
		JSONValue requestListObjectStart = returnObject.get("requestList");
		JSONArray requestListObject = requestListObjectStart.isArray();
		List<Request> requestList = new ArrayList<Request>();
		for (int i = 0; i < requestListObject.size(); i++) {
			
			JSONObject requestObject = requestListObject.get(i).isObject();
			
			Integer requester_id = JSONHelper.getIntValue(requestObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Requester_ID));
			String requestType = JSONHelper.getStringValue(requestObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Request_Type));
			String requestDetails = JSONHelper.getStringValue(requestObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Request_Details));
			
			Request request = new Request();
			request.setRequesterId(requester_id);
			request.setRequestType(requestType);
			request.setRequestDetails(requestDetails);
			
			requestList.add(request);
		}
		
		ReceiveClickUserRequestTabAction action = new ReceiveClickUserRequestTabAction(requestList);
		return action;
	}
	
}
