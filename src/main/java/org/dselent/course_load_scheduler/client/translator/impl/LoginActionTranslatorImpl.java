package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CourseLoad;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLoginKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveRegisterKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendLoginKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONArray;

public class LoginActionTranslatorImpl implements ActionTranslator<SendLoginAction, ReceiveLoginAction>
{
	@Override
	public JSONObject translateToJson(SendLoginAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendLoginKeys.USER_NAME), action.getUserName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendLoginKeys.PASSWORD), action.getPassword());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveLoginAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnLoginObject = jsonObject.isObject();
		
		JSONValue returnLogin = jsonReturnLoginObject.get("returnObject");
		JSONObject returnLoginObject = returnLogin.isObject();
		
		// message, userId, userRole, linkedInstructorId, instructorList, courseList, courseLoadList
		
		String message = JSONHelper.getStringValue(returnLoginObject, JSONHelper.convertKeyName(ReceiveLoginKeys.MESSAGE));
		Integer userId = JSONHelper.getIntValue(returnLoginObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USER_ID));
		String userRole = JSONHelper.getStringValue(returnLoginObject, JSONHelper.convertKeyName(ReceiveLoginKeys.USER_ROLE));
		Integer linkedInstructorId = JSONHelper.getIntValue(returnLoginObject, JSONHelper.convertKeyName(ReceiveLoginKeys.LINKED_INSTRUCTOR_ID));
		
		JSONArray instructorListObject = returnLoginObject.get("instructorList").isArray();
		List<Instructor> instructorList = new ArrayList<Instructor>();
		for (int i = 0; i < instructorListObject.size(); i++)
		{
			JSONObject instructorObject = instructorListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveLoginKeys.ID));
			String rank = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveLoginKeys.RANK));
			String firstName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveLoginKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveLoginKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveLoginKeys.EMAIL));
			//Boolean deleted = JSONHelper.getBooleanValue(instructorObject, JSONHelper.convertKeyName(ReceiveLoginKeys.DELETED));
			
			Instructor instructor = new Instructor();
			instructor.setId(id);
			instructor.setRank(rank);
			instructor.setFirstName(firstName);
			instructor.setLastName(lastName);
			instructor.setEmail(email);
			//instructor.setDeleted(deleted);
			
			instructorList.add(instructor);
		}
		
		JSONArray courseListObject = returnLoginObject.get("courseList").isArray();
		List<Course> courseList = new ArrayList<Course>();
		for (int i = 0; i < courseListObject.size(); i++)
		{
			JSONObject courseObject = courseListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(courseObject, JSONHelper.convertKeyName(ReceiveLoginKeys.ID));
			String course_name = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveLoginKeys.COURSE_NAME));
			String course_number = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveLoginKeys.COURSE_NUMBER));
			String frequency = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveLoginKeys.FREQUENCY));
			//Boolean deleted = JSONHelper.getBooleanValue(courseObject, JSONHelper.convertKeyName(ReceiveLoginKeys.DELETED));
			
			Course course = new Course();
			course.setId(id);
			course.setCourseName(course_name);
			course.setCourseNumber(course_number);
			course.setFrequency(frequency);
			//course.setDeleted(deleted);
			
			courseList.add(course);
		}
		
		JSONArray courseLoadListObject = returnLoginObject.get("courseLoadList").isArray();
		List<CourseLoad> courseLoadList = new ArrayList<CourseLoad>();
		
		for (int i = 0; i < courseLoadListObject.size(); i++)
		{
			JSONObject courseLoadObject = courseLoadListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveLoginKeys.ID));
			String loadType = JSONHelper.getStringValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveLoginKeys.LOAD_TYPE));
			String loadDescription = JSONHelper.getStringValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveLoginKeys.LOAD_DESCRIPTION));
			Integer instructorId = JSONHelper.getIntValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveLoginKeys.INSTRUCTOR_ID));
			//Boolean deleted = JSONHelper.getBooleanValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveLoginKeys.DELETED));
		
			CourseLoad courseLoad = new CourseLoad();
			courseLoad.setId(id);
			courseLoad.setLoadType(loadType);
			courseLoad.setLoadDescription(loadDescription);
			courseLoad.setInstructorId(instructorId);
			//courseLoad.setDeleted(deleted);
			
			courseLoadList.add(courseLoad);
		
		}
		
		ReceiveLoginAction action = new ReceiveLoginAction(message, userId, userRole, linkedInstructorId, instructorList, courseList, courseLoadList);	
	
		return action;
	}
}