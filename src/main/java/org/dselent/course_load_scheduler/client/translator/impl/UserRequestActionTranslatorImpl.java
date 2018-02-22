package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveRequestAction;
import org.dselent.course_load_scheduler.client.action.SendRequestAction;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveRequestKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendRequestKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class UserRequestActionTranslatorImpl implements ActionTranslator<SendRequestAction, ReceiveRequestAction>{
	@Override
	public JSONObject translateToJson(SendRequestAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRequestKeys.Request_Type), action.getrequestType());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRequestKeys.Request_Descriptions), action.getDescription());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveRequestAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject requestObject = jsonObject.isArray().get(0).isObject();
		
		String requestType = JSONHelper.getStringValue(requestObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Request_Type));
		String requestDescriptions = JSONHelper.getStringValue(requestObject, JSONHelper.convertKeyName(ReceiveRequestKeys.Request_Details));
		
		// TODO look into time conversion more
		// put into JSONHelper?
		
		Request request = new Request();
		request.setRequestType(requestType);
		request.setRequestDetails(requestDescriptions);
		
		// possibly use builder pattern if it is a lot of data
		ReceiveRequestAction action = new ReceiveRequestAction(request);	
	
		return action;
	}
}
