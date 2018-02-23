package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveEditCourseAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSelectCourseAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSelectInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendSelectCourseAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CourseSection;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditCourseKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditInstructorKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditUserKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendEditCourseKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendSelectKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SelectCourseActionTranslatorImpl implements ActionTranslator<SendSelectCourseAction, ReceiveSelectCourseAction> {
	
	@Override
	public JSONObject translateToJson(SendSelectCourseAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSelectKeys.ID), action.getId().toString());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSelectKeys.TERM), action.getTerm());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSelectKeys.YEAR), action.getYear().toString());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveSelectCourseAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject returnObject = jsonObject.isArray().get(0).isObject();
		
		// extract instructor list
		JSONValue instructorListObjectStart = returnObject.get("instructorList");
		JSONArray instructorListObject = instructorListObjectStart.isArray();
		List<Instructor> instructorList = new ArrayList<Instructor>();
		for (int i = 0; i < instructorListObject.size(); i++) {
			
			JSONObject instructorObject = instructorListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.ID));
			String firstName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.LAST_NAME));
			String rank = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.RANK));
			String email = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditInstructorKeys.EMAIL));
			
			Instructor instructor = new Instructor();
			instructor.setId(id);
			instructor.setFirstName(firstName);
			instructor.setLastName(lastName);
			instructor.setRank(rank);
			instructor.setEmail(email);
			
			instructorList.add(instructor);
		}
		
		// extract course section list
		JSONValue sectionListObjectStart = returnObject.get("sectionList");
		JSONArray sectionListObject = sectionListObjectStart.isArray();
		List<CourseSection> sectionList = new ArrayList<CourseSection>();
		for (int i = 0; i < sectionListObject.size(); i++) {
			
			JSONObject sectionObject = sectionListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.ID));
			String userName = JSONHelper.getStringValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.USER_NAME));
			String firstName = JSONHelper.getStringValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.LAST_NAME));
			
			CourseSection section = new CourseSection();
			section.setId(id);
			section.setUserName(userName);
			section.setFirstName(firstName);
			section.setLastName(lastName);
			
			instructorList.add(section);
		}
		
		// extract calendar info list
		JSONValue calInfoListObjectStart = returnObject.get("calendarInfoList");
		JSONArray calInfoListObject = calInfoListObjectStart.isArray();
		List<CalendarInfo> calInfoList = new ArrayList<CalendarInfo>();
		for (int i = 0; i < calInfoListObject.size(); i++) 
		{
			JSONObject calInfoObject = calInfoListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(calInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.ID));
			Integer userId = JSONHelper.getIntValue(calInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.USER_ID));
			Integer roleId = JSONHelper.getIntValue(calInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.ROLE_ID));
			
			CalendarInfo calInfo = new CalendarInfo();
			calInfo.setId(id);
			calInfo.setUserId(userId);
			calInfo.setRoleId(roleId);
			
			calInfoList.add(calInfo);
		}
		
		// possibly use builder pattern if it is a lot of data
		ReceiveSelectCourseAction action = new ReceiveSelectCourseAction(instructorList, sectionList, calInfoList);	
	
		return action;
	}

}
