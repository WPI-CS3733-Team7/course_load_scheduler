package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveChangePasswordAction;
import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendChangePasswordKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveChangePasswordKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ChangePasswordActionTranslatorImpl implements ActionTranslator<SendChangePasswordAction, ReceiveChangePasswordAction>
{

	@Override
	public JSONObject translateToJson(SendChangePasswordAction action) 
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendChangePasswordKeys.OLD_PASSWORD), action.getOldPassword());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendChangePasswordKeys.NEW_PASSWORD), action.getNewPassword());
		
		return jsonObject;
	}

	@Override
	public ReceiveChangePasswordAction translateToAction(JSONObject json) 
	{
		JSONValue jsonChangePasswordObject = json.get("success");
		JSONObject changePasswordObject = jsonChangePasswordObject.isObject();
		
		JSONValue jsonChangePassword = changePasswordObject.get("returnObject");
		JSONObject changePassword = jsonChangePassword.isObject();
		
		String message = JSONHelper.getStringValue(changePassword, JSONHelper.convertKeyName(ReceiveChangePasswordKeys.MESSAGE));

		ReceiveChangePasswordAction action = new ReceiveChangePasswordAction(message);	
		return action;
	}

}
