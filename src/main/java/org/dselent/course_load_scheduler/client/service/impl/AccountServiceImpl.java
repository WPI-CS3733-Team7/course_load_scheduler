package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendEditUserEvent;
import org.dselent.course_load_scheduler.client.service.AccountService;

import com.google.gwt.event.shared.HandlerRegistration;

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
		
	}
	
	@Override
	public void onSendEditUser(SendEditUserEvent evt)
	{
		
	}
}
