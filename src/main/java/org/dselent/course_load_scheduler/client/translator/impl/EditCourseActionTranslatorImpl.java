package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditCourseKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendEditCourseKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class EditCourseActionTranslatorImpl implements ActionTranslator<SendEditCourseAction, ReceiveEditCourseAction> {
	
	@Override
	public JSONObject translateToJson(SendEditCourseAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.ID), action.getCourseId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.COURSE_NAME), action.getCourseName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditCourseKeys.COURSE_NUMBER), action.getCourseNumber());
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
		JSONObject jsonReturnCourseObject = jsonObject.isObject();
		
		JSONValue returnCourse = jsonReturnCourseObject.get("returnObject");
		JSONObject returnCourseObject = returnCourse.isObject();
		
		Integer id = JSONHelper.getIntValue(returnCourseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.ID));
		String courseName = JSONHelper.getStringValue(returnCourseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.COURSE_NAME));
		String courseNumber = JSONHelper.getStringValue(returnCourseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.COURSE_NUMBER));
		String frequency = JSONHelper.getStringValue(returnCourseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.FREQUENCY));
		Boolean deleted = JSONHelper.getBooleanValue(returnCourseObject, JSONHelper.convertKeyName(ReceiveEditCourseKeys.DELETED));
		
		// TODO look into time conversion more
		// put into JSONHelper?
		
		Course course = new Course();
		course.setId(id);
		course.setCourseName(courseName);
		course.setCourseNumber(courseNumber);
		course.setFrequency(frequency);
		course.setDeleted(deleted);
		
		// possibly use builder pattern if it is a lot of data
		ReceiveEditCourseAction action = new ReceiveEditCourseAction(course);	
	
		return action;
	}

}
