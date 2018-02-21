package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveRegisterAction;
import org.dselent.course_load_scheduler.client.action.SendRegisterAction;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLoginKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveRegisterKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendRegisterKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class RegisterActionTranslatorImpl implements ActionTranslator<SendRegisterAction, ReceiveRegisterAction>
{

	@Override
	public JSONObject translateToJson(SendRegisterAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.USER_NAME), action.getUserName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.FIRST_NAME), action.getFirstName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.LAST_NAME), action.getLastName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.EMAIL), action.getEmail());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendRegisterKeys.PASSWORD), action.getPassword());
		
		return jsonObject;
	}

	@Override
	public ReceiveRegisterAction translateToAction(JSONObject json)
	{
		JSONValue jsonObject = json.get("success");
		JSONObject registerObject = jsonObject.isArray().get(0).isObject();
		
		String message = JSONHelper.getStringValue(registerObject, JSONHelper.convertKeyName(ReceiveRegisterKeys.MESSAGE));
		
		ReceiveRegisterAction action = new ReceiveRegisterAction(message);
		return action;
	}

}
