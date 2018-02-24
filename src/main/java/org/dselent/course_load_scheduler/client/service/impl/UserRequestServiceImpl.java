package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SendClickUserRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SendRequestAction;
import org.dselent.course_load_scheduler.client.callback.SendClickUserRequestTabCallback;
import org.dselent.course_load_scheduler.client.callback.SendRequestCallback;
import org.dselent.course_load_scheduler.client.event.SendRequestEvent;
import org.dselent.course_load_scheduler.client.event.SendUserClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.UserRequestService;
import org.dselent.course_load_scheduler.client.translator.impl.UserRequestActionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class UserRequestServiceImpl extends BaseServiceImpl implements UserRequestService{
	public UserRequestServiceImpl()
	{
		
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(SendRequestEvent.TYPE, this);
		eventBusRegistration.put(SendRequestEvent.TYPE, registration);
		
	}
	
	@Override
	public void onSendRequest(SendRequestEvent evt)
	{
		SendRequestAction action = evt.getAction();
		UserRequestActionTranslatorImpl UserRequestActionTranslator = new UserRequestActionTranslatorImpl();
		JSONObject json = UserRequestActionTranslator.translateToJson(action);
		SendRequestCallback UserRequestCallback = new SendRequestCallback(eventBus, evt.getContainer());
		
		String uri = action.getUserId() + NetworkRequestStrings.SUBMIT_USER_REQUEST;
		
		NetworkRequest request = new NetworkRequest(uri, UserRequestCallback, json);
		request.send();
	}
	
	@Override
	public void onSendUserClickRequestTab(SendUserClickRequestTabEvent evt)
	{
		SendClickUserRequestTabAction action = evt.getAction();
		UserRequestActionTranslatorImpl UserRequestActionTranslator = new UserRequestActionTranslatorImpl();
		JSONObject json = UserRequestActionTranslator.translateToJson(action);
		SendClickUserRequestTabCallback UserRequestCallback = new SendClickUserRequestTabCallback(eventBus, evt.getContainer());
		
		String uri = action.getUserId() + NetworkRequestStrings.CLICK_USER_REQUEST_TAB;
		
		NetworkRequest request = new NetworkRequest(uri, UserRequestCallback, json);
		request.send();
	}
}
