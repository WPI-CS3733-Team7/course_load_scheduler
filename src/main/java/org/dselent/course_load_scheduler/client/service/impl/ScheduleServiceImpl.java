package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendSelectCourseAction;
import org.dselent.course_load_scheduler.client.action.SendSelectInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.action.SendClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.callback.SendEditInstructorCallback;
import org.dselent.course_load_scheduler.client.callback.SendEditCourseCallback;
import org.dselent.course_load_scheduler.client.callback.SendEditSectionCallback;
import org.dselent.course_load_scheduler.client.callback.SendSelectCourseCallback;
import org.dselent.course_load_scheduler.client.callback.SendSelectInstructorCallback;
import org.dselent.course_load_scheduler.client.callback.SendValidateCallback;
import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendSelectCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendSelectInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendValidateEvent;
import org.dselent.course_load_scheduler.client.event.SendClickScheduleTabEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.ScheduleService;
import org.dselent.course_load_scheduler.client.translator.impl.ClickScheduleTabActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.EditInstructorActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.EditCourseActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.EditSectionActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SelectCourseActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SelectInstructorActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.ValidateActionTranslatorImpl;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class ScheduleServiceImpl extends BaseServiceImpl implements ScheduleService
{

	public ScheduleServiceImpl()
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
		
		registration = eventBus.addHandler(SendEditInstructorEvent.TYPE, this);
		eventBusRegistration.put(SendEditInstructorEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SendEditCourseEvent.TYPE, this);
		eventBusRegistration.put(SendEditCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SendEditSectionEvent.TYPE, this);
		eventBusRegistration.put(SendEditSectionEvent.TYPE, registration);
		
		registration = eventBus.addHandler(SendValidateEvent.TYPE, this);
		eventBusRegistration.put(SendValidateEvent.TYPE, registration);
	}
	
	@Override
	public void onSendEditInstructor(SendEditInstructorEvent evt)
	{
		SendEditInstructorAction action = evt.getAction();
		EditInstructorActionTranslatorImpl editInstructorActionTranslator = new EditInstructorActionTranslatorImpl();
		JSONObject json = editInstructorActionTranslator.translateToJson(action);
		SendEditInstructorCallback editInstructorCallback = new SendEditInstructorCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.EDIT_INSTRUCTOR, editInstructorCallback, json);
		request.send();
	}
	
	@Override
	public void onSendEditCourse(SendEditCourseEvent evt)
	{
		SendEditCourseAction action = evt.getAction();
		EditCourseActionTranslatorImpl editCourseActionTranslator = new EditCourseActionTranslatorImpl();
		JSONObject json = editCourseActionTranslator.translateToJson(action);
		SendEditCourseCallback editCourseCallback = new SendEditCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.EDIT_COURSE, editCourseCallback, json);
		request.send();
	}
	
	@Override
	public void onSendEditSection(SendEditSectionEvent evt)
	{
		SendEditSectionAction action = evt.getAction();
		EditSectionActionTranslatorImpl editSectionActionTranslator = new EditSectionActionTranslatorImpl();
		JSONObject json = editSectionActionTranslator.translateToJson(action);
		SendEditSectionCallback editSectionCallback = new SendEditSectionCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.REGISTER, editSectionCallback, json);
		request.send();
	}
	
	@Override
	public void onSendSelectInstructor(SendSelectInstructorEvent evt) {
		SendSelectInstructorAction action = evt.getAction();
		SelectInstructorActionTranslatorImpl selectInstructorActionTranslator = new SelectInstructorActionTranslatorImpl();
		JSONObject json = selectInstructorActionTranslator.translateToJson(action);
		SendSelectInstructorCallback selectInstructorCallback = new SendSelectInstructorCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.SELECT_INSTRUCTOR, selectInstructorCallback, json);
		request.send();
	}
	
	@Override
	public void onSendSelectCourse(SendSelectCourseEvent evt) {
		SendSelectCourseAction action = evt.getAction();
		SelectCourseActionTranslatorImpl selectCourseActionTranslator = new SelectCourseActionTranslatorImpl();
		JSONObject json = selectCourseActionTranslator.translateToJson(action);
		SendSelectCourseCallback selectCourseCallback = new SendSelectCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.SELECT_COURSE, selectCourseCallback, json);
		request.send();
	}
	
	@Override
	public void onSendValidate(SendValidateEvent evt)
	{
		SendValidateAction action = evt.getAction();
		ValidateActionTranslatorImpl validateActionTranslator = new ValidateActionTranslatorImpl();
		JSONObject json = validateActionTranslator.translateToJson(action);
		SendValidateCallback validateCallback = new SendValidateCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.REGISTER, validateCallback, json);
		request.send();
	}
	
}
