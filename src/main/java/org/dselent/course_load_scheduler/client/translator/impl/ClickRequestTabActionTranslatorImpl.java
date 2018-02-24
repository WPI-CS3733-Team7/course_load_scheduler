package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveClickAccountTabAction;
import org.dselent.course_load_scheduler.client.action.ReceiveClickRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickAccountTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickRequestTabAction;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;

import com.google.gwt.json.client.JSONObject;

public class ClickRequestTabActionTranslatorImpl implements ActionTranslator<SendClickRequestTabAction, ReceiveClickRequestTabAction>
{

	@Override
	public JSONObject translateToJson(SendClickRequestTabAction action) {
		JSONObject jsonObject = new JSONObject();		
		return jsonObject;
	}

	@Override
	public ReceiveClickRequestTabAction translateToAction(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}

}
