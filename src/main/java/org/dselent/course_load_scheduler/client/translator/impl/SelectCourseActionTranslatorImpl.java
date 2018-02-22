package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendSelectCourseAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditCourseKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendEditCourseKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SelectCourseActionTranslatorImpl implements ActionTranslator<SendSelectCourseAction, ReceiveSelectCourseAction> {
	
	@Override
	public JSONObject translateToJson(SendSelectCourseAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.ID), action.getCourseId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.NAME), action.getCourseName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.NUMBER), action.getCourseNumber());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.FREQUENCY), action.getFrequency());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.DELETED), action.getDeleted());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveEditCourseAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject courseObject = jsonObject.isArray().get(0).isObject();
		
		Integer id = JSONHelper.getIntValue(courseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.ID));
		String courseName = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.NAME));
		String courseNumber = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.NUMBER));
		String frequency = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.FREQUENCY));
		Long createdAt = JSONHelper.getLongValue(courseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.CREATED_AT));
		Long updatedAt = JSONHelper.getLongValue(courseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.UPDATED_AT));
		Boolean deleted = JSONHelper.getBooleanValue(courseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.DELETED));
		
		// TODO look into time conversion more
		// put into JSONHelper?
		
		Course course = new Course();
		course.setId(id);
		course.setCourseName(courseName);
		course.setCourseNumber(courseNumber);
		course.setFrequency(frequency);
		course.setCreatedAt(new Date(createdAt));
		course.setUpdatedAt(new Date(updatedAt));
		course.setDeleted(deleted);
		
		// possibly use builder pattern if it is a lot of data
		ReceiveEditCourseAction action = new ReceiveEditCourseAction(course);	
	
		return action;
	}

}
