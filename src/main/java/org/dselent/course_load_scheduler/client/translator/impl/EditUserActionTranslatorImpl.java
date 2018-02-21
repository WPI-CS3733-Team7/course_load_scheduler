package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.Action;
import org.dselent.course_load_scheduler.client.action.ReceiveEditUserAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.SendEditUserAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;

import com.google.gwt.json.client.JSONObject;

public class EditUserActionTranslatorImpl implements ActionTranslator<SendEditUserAction, ReceiveEditUserAction>
{
	@Override
	public JSONObject translateToJson(SendEditUserAction object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiveEditUserAction translateToAction(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}
}
