package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveReplyAction;
import org.dselent.course_load_scheduler.client.action.SendReplyAction;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveReplyKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendReplyKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendReplyActionTranslatorImpl implements ActionTranslator<SendReplyAction, ReceiveReplyAction> {

	@Override
	public JSONObject translateToJson(SendReplyAction action) {
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendReplyKeys.REQUEST_ID), action.getRequestId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendReplyKeys.RESPONSE), action.getResponse());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendReplyKeys.REPLY_TYPE), action.getReplyType());
		
		return jsonObject;
	}

	@Override
	public ReceiveReplyAction translateToAction(JSONObject json) {
		
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnReplyObject = jsonObject.isObject();
		
		JSONValue returnReply = jsonReturnReplyObject.get("returnObject");
		JSONObject returnReplyObject = returnReply.isObject();
		
		
		Integer requestId = JSONHelper.getIntValue(returnReplyObject, JSONHelper.convertKeyName(ReceiveReplyKeys.REQUEST_ID));
		String response = JSONHelper.getStringValue(returnReplyObject, JSONHelper.convertKeyName(ReceiveReplyKeys.RESPONSE));
		String replyType = JSONHelper.getStringValue(returnReplyObject, JSONHelper.convertKeyName(ReceiveReplyKeys.REPLY_TYPE));
		
		Request request = new Request();
		request.setId(requestId);
		request.setReply(response);
		request.setReplyType(replyType);
		
		ReceiveReplyAction action = new ReceiveReplyAction(request);
		return action;
	}

}