package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CourseLoad;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveClickScheduleTabKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ClickScheduleTabActionTranslatorImpl implements ActionTranslator<SendClickScheduleTabAction, ReceiveClickScheduleTabAction> {
	
	@Override
	public JSONObject translateToJson(SendClickScheduleTabAction object)
	{	
		JSONObject jsonObject = new JSONObject();		
		return jsonObject;
	}

	@Override
	public ReceiveClickScheduleTabAction translateToAction(JSONObject json)
	{
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnClickScheduleTabObject = jsonObject.isObject();
		
		JSONValue returnClickScheduleTab = jsonReturnClickScheduleTabObject.get("returnObject");
		JSONObject returnClickScheduleTabObject = returnClickScheduleTab.isObject();
		
		//Linked instructor id		
		Integer linkedInstructorId = JSONHelper.getIntValue(returnClickScheduleTabObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.LINKED_INSTRUCTOR_ID));
		
		//Extract instructor list
		JSONValue instructorListObjectStart = returnClickScheduleTabObject.get("instructorList");
		JSONArray instructorListObject = instructorListObjectStart.isArray();
		List<Instructor> instructorList = new ArrayList<Instructor>();
		for (int i = 0; i < instructorListObject.size(); i++) 
		{
			JSONObject instructorObject = instructorListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.INSTRUCTOR_ID));
			String rank = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.RANK));
			String firstName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.EMAIL));
			
			Instructor instructor = new Instructor();
			instructor.setId(id);
			instructor.setRank(rank);
			instructor.setFirstName(firstName);
			instructor.setLastName(lastName);
			instructor.setEmail(email);
			
			instructorList.add(instructor);
		}
		
		// Extract course list
		JSONValue courseListObjectStart = returnClickScheduleTabObject.get("courseList");
		JSONArray courseListObject = courseListObjectStart.isArray();
		List<Course> courseList = new ArrayList<Course>();
		for (int i = 0; i < courseListObject.size(); i++) 
		{
			JSONObject courseObject = courseListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(courseObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.COURSE_ID));
			String courseName = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.COURSE_NAME));
			String courseNumber = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.COURSE_NUMBER));
			String frequency = JSONHelper.getStringValue(courseObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.FREQUENCY));
			
			
			Course course = new Course();
			course.setId(id);
			course.setCourseName(courseName);
			course.setCourseNumber(courseNumber);
			course.setFrequency(frequency);
			
			courseList.add(course);
		}
		
		// Extract course load list
		JSONValue courseLoadListObjectStart = returnClickScheduleTabObject.get("courseLoadList");
		JSONArray courseLoadListObject = courseLoadListObjectStart.isArray();
		List<CourseLoad> courseLoadList = new ArrayList<CourseLoad>();
		for (int i = 0; i < courseLoadListObject.size(); i++) 
		{
			JSONObject courseLoadObject = courseLoadListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.COURSE_LOAD_ID));
			String loadType = JSONHelper.getStringValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.LOAD_TYPE));
			String loadDescription = JSONHelper.getStringValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.LOAD_DESCRIPTION));
			Integer instructorId = JSONHelper.getIntValue(courseLoadObject, JSONHelper.convertKeyName(ReceiveClickScheduleTabKeys.INSTRUCTOR_ID));
			
			CourseLoad courseLoad = new CourseLoad();
			courseLoad.setId(id);
			courseLoad.setLoadType(loadType);
			courseLoad.setLoadDescription(loadDescription);
			courseLoad.setInstructorId(instructorId);
			
			courseLoadList.add(courseLoad);
		}
		
		ReceiveClickScheduleTabAction action = new ReceiveClickScheduleTabAction(linkedInstructorId, instructorList, courseList, courseLoadList);
		
		return action;
	}

}
