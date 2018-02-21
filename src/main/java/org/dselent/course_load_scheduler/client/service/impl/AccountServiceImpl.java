package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SendChangePasswordAction;
import org.dselent.course_load_scheduler.client.callback.SendChangePasswordCallback;
import org.dselent.course_load_scheduler.client.callback.SendRegisterCallback;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendEditUserEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.AccountService;
import org.dselent.course_load_scheduler.client.translator.impl.ChangePasswordActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.RegisterActionTranslatorImpl;

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
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.REGISTER, changePasswordCallback, json);
		request.send();
	}
		
	@Override
	public void onSendEditUser(SendEditUserEvent evt)
	{
		
	}
}
