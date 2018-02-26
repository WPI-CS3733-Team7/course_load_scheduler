package org.dselent.course_load_scheduler.client.translator.impl;


import org.dselent.course_load_scheduler.client.action.ReceiveClickRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickRequestTabAction;
import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveRequestKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ClickRequestTabActionTranslatorImpl implements ActionTranslator<SendClickRequestTabAction, ReceiveClickRequestTabAction>{
	@Override
	public JSONObject translateToJson(SendClickRequestTabAction object)
	{	
		JSONObject jsonObject = new JSONObject();		
		return jsonObject;
	}

	@Override
	public ReceiveClickRequestTabAction translateToAction(JSONObject json)
	{
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnClickRequestTabObject = jsonObject.isObject();
		
		JSONValue returnClickRequestTab = jsonReturnClickRequestTabObject.get("returnObject");
		JSONObject returnClickRequestTabObject = returnClickRequestTab.isObject();
		
		JSONArray clickRequestTabListObject = returnClickRequestTabObject.get("requestList").isArray();
		List<Request> requestList = new ArrayList<Request>();
		for (int i = 0; i < clickRequestTabListObject.size(); i++) {
			
			JSONObject clickRequestTabObject = clickRequestTabListObject.get(i).isObject();
			
			Integer requester_id = JSONHelper.getIntValue(clickRequestTabObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Requester_ID));
			String requestType = JSONHelper.getStringValue(clickRequestTabObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Request_Type));
			String requestDetails = JSONHelper.getStringValue(clickRequestTabObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Request_Details));
			
			Request request = new Request();
			request.setRequesterId(requester_id);
			request.setRequestType(requestType);
			request.setRequestDetails(requestDetails);
			
			requestList.add(request);
		}
		
		ReceiveClickRequestTabAction action = new ReceiveClickRequestTabAction(requestList);
		return action;
	}
}
