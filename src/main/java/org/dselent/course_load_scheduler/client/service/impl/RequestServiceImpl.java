package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SendReplyAction;
import org.dselent.course_load_scheduler.client.action.SelectRequestAction;
import org.dselent.course_load_scheduler.client.callback.SendReplyCallback;
import org.dselent.course_load_scheduler.client.callback.SendSelectRequestCallback;
import org.dselent.course_load_scheduler.client.event.SelectRequestEvent;
import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendReplyEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.RequestService;
import org.dselent.course_load_scheduler.client.translator.impl.SelectRequestActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendReplyActionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class RequestServiceImpl extends BaseServiceImpl implements RequestService{
	
	public RequestServiceImpl() {
		
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
		
		registration = eventBus.addHandler(SendReplyEvent.TYPE, this);
		eventBusRegistration.put(SendReplyEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SelectRequestEvent.TYPE, this);
		eventBusRegistration.put(SelectRequestEvent.TYPE, registration);
	}
	
	@Override
	public void onSendReply(SendReplyEvent evt) {
		SendReplyAction action = evt.getAction();
		SendReplyActionTranslatorImpl sendReplyActionTranslator = new SendReplyActionTranslatorImpl();
		JSONObject json = sendReplyActionTranslator.translateToJson(action);
		SendReplyCallback sendReplyCallback = new SendReplyCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.SUBMIT_RESPONSE, sendReplyCallback, json);
		request.send();
	}
	
	@Override
	public void onSelectRequest(SelectRequestEvent evt) {
		SelectRequestAction action = evt.getAction();
		SelectRequestActionTranslatorImpl selectRequestActionTranslator = new SelectRequestActionTranslatorImpl();
		JSONObject json = selectRequestActionTranslator.translateToJson(action);
		SendSelectRequestCallback selectRequestCallback = new SendSelectRequestCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.SELECT_REQUEST, selectRequestCallback, json);
		request.send();
	}
	
	
}
