package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveClickAccountTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickAccountTabAction;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;

import com.google.gwt.json.client.JSONObject;

public class ClickRequestTabActionTranslatorImpl implements ActionTranslator<SendClickAccountTabAction, ReceiveClickAccountTabAction>
{

	@Override
	public JSONObject translateToJson(SendClickAccountTabAction object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiveClickAccountTabAction translateToAction(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}

}
