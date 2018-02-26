package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveRequestAction;
import org.dselent.course_load_scheduler.client.action.SendRequestAction;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveRequestKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendRequestKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class UserRequestActionTranslatorImpl implements ActionTranslator<SendRequestAction, ReceiveRequestAction>{
	@Override
	public JSONObject translateToJson(SendRequestAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendRequestKeys.User_ID), action.getUserId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRequestKeys.REQUEST_TYPE), action.getRequestType());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRequestKeys.REQUEST_DETAILS), action.getDescription());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveRequestAction translateToAction(JSONObject json) {
		
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnRequestObject = jsonObject.isObject();
		
		JSONValue returnRequest = jsonReturnRequestObject.get("returnObject");
		JSONObject returnRequestObject = returnRequest.isObject();
		
		// extract request list
		
		JSONArray requestListObject = returnRequestObject.get("requestList").isArray();
		List<Request> requestList = new ArrayList<Request>();
		for (int i = 0; i < requestListObject.size();) {
			
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
		
		ReceiveRequestAction action = new ReceiveRequestAction(requestList);	
		return action;
	}
}
