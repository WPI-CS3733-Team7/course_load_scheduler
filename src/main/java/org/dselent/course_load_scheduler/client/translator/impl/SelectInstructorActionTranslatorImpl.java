package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveSelectInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendSelectInstructorAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseSection;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarInfoKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditSectionKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendSelectKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SelectInstructorActionTranslatorImpl implements ActionTranslator<SendSelectInstructorAction, ReceiveSelectInstructorAction>{
	
	@Override
	public JSONObject translateToJson(SendSelectInstructorAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSelectKeys.INSTRUCTOR_ID), action.getId().toString());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSelectKeys.TERM), action.getTerm());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendSelectKeys.YEAR), action.getYear().toString());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveSelectInstructorAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnObject = jsonObject.isObject();
		
		JSONValue returnInstructor = jsonReturnObject.get("returnObject");		
		JSONObject returnObject = returnInstructor.isObject();
		
		// extract course section list
		JSONValue sectionListObjectStart = returnObject.get("sectionList");
		JSONArray sectionListObject = sectionListObjectStart.isArray();
		List<CourseSection> sectionList = new ArrayList<CourseSection>();
		for (int i = 0; i < sectionListObject.size(); i++) {
			
			JSONObject sectionObject = sectionListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.ID));
			String sectionName = JSONHelper.getStringValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.SECTION_NAME));
			Integer sectionId = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.SECTION_ID));
			String sectionType = JSONHelper.getStringValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.SECTION_TYPE));
			Integer population = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.POPULATION));
			Integer courseId = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.COURSE_ID));
			Integer instructorId = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.INSTRUCTOR_ID));
			Integer calInfoId = JSONHelper.getIntValue(sectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.CALENDAR_INFO_ID));
			
			CourseSection section = new CourseSection();
			section.setId(id);
			section.setSectionName(sectionName);
			section.setSectionId(sectionId);
			section.setSectionType(sectionType);
			section.setPopulation(population);
			section.setCourseId(courseId);
			section.setInstructorId(instructorId);
			section.setCalendarInfoId(calInfoId);
			
			sectionList.add(section);
		}
		
		// extract calendar info list
		JSONValue calInfoListObjectStart = returnObject.get("calendarInfoList");
		JSONArray calInfoListObject = calInfoListObjectStart.isArray();
		List<CalendarInfo> calInfoList = new ArrayList<CalendarInfo>();
		for (int i = 0; i < calInfoListObject.size(); i++) 
		{
			JSONObject calInfoObject = calInfoListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(calInfoObject, JSONHelper.convertKeyName(ReceiveCalendarInfoKeys.ID));
			Integer year = JSONHelper.getIntValue(calInfoObject, JSONHelper.convertKeyName(ReceiveCalendarInfoKeys.CAL_YEAR));
			String term = JSONHelper.getStringValue(calInfoObject, JSONHelper.convertKeyName(ReceiveCalendarInfoKeys.CAL_TERM));
			String days = JSONHelper.getStringValue(calInfoObject, JSONHelper.convertKeyName(ReceiveCalendarInfoKeys.DAYS));
			Integer startTime = JSONHelper.getIntValue(calInfoObject, JSONHelper.convertKeyName(ReceiveCalendarInfoKeys.START_TIME));
			Integer endTime = JSONHelper.getIntValue(calInfoObject, JSONHelper.convertKeyName(ReceiveCalendarInfoKeys.END_TIME));
			
			CalendarInfo calInfo = new CalendarInfo();
			calInfo.setId(id);
			calInfo.setCalYear(year);
			calInfo.setCalTerm(term);
			calInfo.setDays(days);
			calInfo.setStartTime(startTime);
			calInfo.setEndTime(endTime);
			
			calInfoList.add(calInfo);
		}
		
		// possibly use builder pattern if it is a lot of data
		ReceiveSelectInstructorAction action = new ReceiveSelectInstructorAction(sectionList, calInfoList);	
	
		return action;
	}

}
