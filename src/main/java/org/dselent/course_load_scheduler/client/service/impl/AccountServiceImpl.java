package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.callback.SendChangePasswordCallback;
import org.dselent.course_load_scheduler.client.action.SendEditUserAction;
import org.dselent.course_load_scheduler.client.callback.SendLoginCallback;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendEditUserEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.AccountService;
import org.dselent.course_load_scheduler.client.translator.impl.ChangePasswordActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.EditUserActionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class AccountServiceImpl extends BaseServiceImpl implements AccountService
{
	public AccountServiceImpl()
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
		
		registration = eventBus.addHandler(SendChangePasswordEvent.TYPE, this);
		eventBusRegistration.put(SendChangePasswordEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SendEditUserEvent.TYPE, this);
		eventBusRegistration.put(SendEditUserEvent.TYPE, registration);
	}
	
	@Override
	public void onSendChangePassword(SendChangePasswordEvent evt)
	{
		SendChangePasswordAction action = evt.getAction();
		ChangePasswordActionTranslatorImpl changePasswordActionTranslator = new ChangePasswordActionTranslatorImpl();
		JSONObject json = changePasswordActionTranslator.translateToJson(action);
		SendChangePasswordCallback changePasswordCallback = new SendChangePasswordCallback(eventBus, evt.getContainer());
		
		String uri = action.getUserId() + NetworkRequestStrings.CHANGE_PASSWORD;
		
		NetworkRequest request = new NetworkRequest(uri, changePasswordCallback, json);
		request.send();
	}
		
	@Override
	public void onSendEditUser(SendEditUserEvent evt)
	{
		SendEditUserAction action = evt.getAction();
		EditUserActionTranslatorImpl editUserActionTranslator = new EditUserActionTranslatorImpl();
		JSONObject json = editUserActionTranslator.translateToJson(action);
		SendLoginCallback editUserCallback = new SendLoginCallback(eventBus, evt.getContainer());
		
		String uri = action.getUserId() + NetworkRequestStrings.EDIT_USER;
		
		NetworkRequest request = new NetworkRequest(uri, editUserCallback, json);
		request.send();
	}
}
