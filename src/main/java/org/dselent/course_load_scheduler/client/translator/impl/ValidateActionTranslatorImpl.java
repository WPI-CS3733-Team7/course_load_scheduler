package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveValidateAction;
import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveValidateKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ValidateActionTranslatorImpl implements ActionTranslator<SendValidateAction, ReceiveValidateAction> {
	
	@Override
	public JSONObject translateToJson(SendValidateAction action)
	{		
		JSONObject jsonObject = new JSONObject();		
		return jsonObject;
	}
	
	@Override
	public ReceiveValidateAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject returnObject = jsonObject.isArray().get(0).isObject();
		
		// Message to display	
		String message = JSONHelper.getStringValue(returnObject, JSONHelper.convertKeyName(ReceiveValidateKeys.MESSAGE));
		
		// instructorList
		JSONValue instructorListObjectStart = returnObject.get("instructorList");
		JSONArray instructorListObject = instructorListObjectStart.isArray();
		List<Instructor> instructorList = new ArrayList<Instructor>();
		for (int i = 0; i < instructorListObject.size(); i++) 
		{
			JSONObject instructorObject = instructorListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveValidateKeys.INSTRUCTOR_ID));
			String rank = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveValidateKeys.RANK));
			String firstName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveValidateKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveValidateKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveValidateKeys.EMAIL));
					
			Instructor instructor = new Instructor();
			instructor.setId(id);
			instructor.setRank(rank);
			instructor.setFirstName(firstName);
			instructor.setLastName(lastName);
			instructor.setEmail(email);
			
			instructorList.add(instructor);
		}
		
		//courseList
		JSONValue courseListObjectStart = returnObject.get("courseList");
		JSONArray courseListObject = courseListObjectStart.isArray();
		List<Course> courseList = new ArrayList<Course>();
		for (int i = 0; i < courseListObject.size(); i++) 
		{
			JSONObject courseObject = courseListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(courseObject, JSONHelper.convertKeyName(ReceiveValidateKeys.COURSE_ID));
			String courseName = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveValidateKeys.COURSE_NAME));
			String courseNumber = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveValidateKeys.COURSE_NUMBER));
			String frequency = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveValidateKeys.FREQUENCY));
			
			
			Course course = new Course();
			course.setId(id);
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setFrequency(frequency);
			
			courseList.add(course);
		}
		
		// possibly use builder pattern if it is a lot of data
		
		ReceiveValidateAction action = new ReceiveValidateAction(message, instructorList, courseList);
		
		return action;
	}
}
