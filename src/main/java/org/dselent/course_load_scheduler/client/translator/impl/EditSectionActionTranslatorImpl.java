package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendEditSectionAction;
import org.dselent.course_load_scheduler.client.model.CourseSection;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditSectionKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendEditSectionKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class EditSectionActionTranslatorImpl implements ActionTranslator<SendEditSectionAction, ReceiveEditSectionAction>
{
	@Override
	public JSONObject translateToJson(SendEditSectionAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.SECTION_NAME), action.getSectionName());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.SECTION_ID), action.getSectionId());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.SECTION_TYPE), action.getSectionType());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.POPULATION), action.getPopulation());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.YEAR), action.getYear());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.TERM), action.getTerm());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.DAYS), action.getDays());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.START_TIME), action.getStartTime());
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendEditSectionKeys.END_TIME), action.getEndTime());
		
		return jsonObject;
	}
	
	@Override
	public ReceiveEditSectionAction translateToAction(JSONObject json)
	{		
		// null values will not have their keys sent back from the sever
		// this will throw an exception here
		// you may choose to handle the exception as you wish
		
		// sent timestamps as epoch seconds (long)
		
		JSONValue jsonObject = json.get("success");
		JSONObject jsonReturnEditSectionObject = jsonObject.isObject();
		
		JSONValue returnEditSection = jsonReturnEditSectionObject.get("returnObject");
		JSONObject returnEditSectionObject = returnEditSection.isObject();
		
		//Message to display
		
		String message = JSONHelper.getStringValue(returnEditSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.MESSAGE));
		
		//CourseSection object
		
		JSONValue courseSectionObjectStart = returnEditSectionObject.get("courseSection");
		JSONArray courseSectionListObject = courseSectionObjectStart.isArray();
		
		CourseSection courseSection = new CourseSection();
		
		for (int i = 0; i < courseSectionListObject.size(); i++) {
		
			JSONObject courseSectionObject = courseSectionListObject.get(i).isObject();
		
			Integer id = JSONHelper.getIntValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.ID));
			String sectionName = JSONHelper.getStringValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.SECTION_NAME));
			Integer sectionId = JSONHelper.getIntValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.SECTION_ID));
			String sectionType = JSONHelper.getStringValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.SECTION_TYPE));
			Integer population = JSONHelper.getIntValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.POPULATION));
			Integer courseId = JSONHelper.getIntValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.COURSE_ID));
			Integer instructorId = JSONHelper.getIntValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.INSTRUCTOR_ID));
			Integer calendarInfoId = JSONHelper.getIntValue(courseSectionObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.CALENDAR_INFO_ID));
			
			//Add checks for null values?
		
			// TODO look into time conversion more
			// put into JSONHelper?
			
			courseSection.setId(id);
			courseSection.setSectionName(sectionName);
			courseSection.setSectionId(sectionId);
			courseSection.setSectionType(sectionType);
			courseSection.setPopulation(population);
			courseSection.setCourseId(courseId);
			courseSection.setInstructorId(instructorId);
			courseSection.setCalendarInfoId(calendarInfoId);			
		}
		
		//CalendarInfo object
		
		JSONValue calendarInfoObjectStart = returnEditSectionObject.get("calendarInfo");
		JSONArray calendarInfoListObject = calendarInfoObjectStart.isArray();
		
		CalendarInfo calendarInfo = new CalendarInfo();
		
		for (int i = 0; i < calendarInfoListObject.size(); i++) {
			
			JSONObject calendarInfoObject = calendarInfoListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(calendarInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.CALENDAR_INFO_ID));		
			Integer calYear = JSONHelper.getIntValue(calendarInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.CAL_YEAR));
			String calTerm = JSONHelper.getStringValue(calendarInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.CAL_TERM));
			String days = JSONHelper.getStringValue(calendarInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.DAYS));
			Integer startTime = JSONHelper.getIntValue(calendarInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.START_TIME));
			Integer endTime = JSONHelper.getIntValue(calendarInfoObject, JSONHelper.convertKeyName(ReceiveEditSectionKeys.END_TIME));
		
			// TODO look into time conversion more
			// put into JSONHelper?
			
			calendarInfo.setId(id);
			calendarInfo.setCalYear(calYear);
			calendarInfo.setCalTerm(calTerm);
			calendarInfo.setDays(days);
			calendarInfo.setStartTime(startTime);
			calendarInfo.setEndTime(endTime);		
		}
		
		// possibly use builder pattern if it is a lot of data
		
		ReceiveEditSectionAction action = new ReceiveEditSectionAction(message, courseSection, calendarInfo);	
	
		return action;
	}
}
