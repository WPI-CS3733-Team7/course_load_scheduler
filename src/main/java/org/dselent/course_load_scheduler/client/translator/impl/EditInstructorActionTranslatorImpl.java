package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveEditInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditInstructorKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendEditInstructorKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class EditInstructorActionTranslatorImpl implements ActionTranslator<SendEditInstructorAction, ReceiveEditInstructorAction>{
	
	@Override
	public JSONObject translateToJson(SendEditInstructorAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditInstructorKeys.ID), action.getId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditInstructorKeys.RANK), action.getRank());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditInstructorKeys.FIRST_NAME), action.getFirstName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditInstructorKeys.LAST_NAME), action.getLastName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditInstructorKeys.EMAIL), action.getEmail());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditInstructorKeys.DELETED), action.getDeleted());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveEditInstructorAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnInstructorObject = jsonObject.isObject();
		
		JSONValue returnInstructor = jsonReturnInstructorObject.get("returnObject");
		JSONObject returnInstructorObject = returnInstructor.isObject();
		
		Integer id = JSONHelper.getIntValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.ID));
		String rank = JSONHelper.getStringValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.RANK));
		String firstName = JSONHelper.getStringValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.FIRST_NAME));
		String lastName = JSONHelper.getStringValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.LAST_NAME));
		String email = JSONHelper.getStringValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.EMAIL));
		//Long createdAt = JSONHelper.getLongValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.CREATED_AT));
		//Long updatedAt = JSONHelper.getLongValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.UPDATED_AT));
		Boolean deleted = JSONHelper.getBooleanValue(returnInstructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.DELETED));
		
		// TODO look into time conversion more
		// put into JSONHelper?
		
		Instructor instructor = new Instructor();
		instructor.setId(id);
		instructor.setRank(rank);
		instructor.setFirstName(firstName);
		instructor.setLastName(lastName);
		instructor.setEmail(email);
		//instructor.setCreatedAt(new Date(createdAt));
		//instructor.setUpdatedAt(new Date(updatedAt));
		instructor.setDeleted(deleted);
		
		// possibly use builder pattern if it is a lot of data
		ReceiveEditInstructorAction action = new ReceiveEditInstructorAction(instructor);	
	
		return action;
	}

}
