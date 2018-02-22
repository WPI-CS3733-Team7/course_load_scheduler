package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.action.SendClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseLoad;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveClickScheduleTabKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditInstructorKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditCourseKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditSectionKeys;
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
		/*JSONValue jsonObject = json.get("success");
		JSONObject returnObject = jsonObject.isArray().get(0).isObject();

		String uFirstName = JSONHelper.getStringValue(returnObject, JSONHelper.convertKeyName(ReceiveClickAccountTabKeys.FIRST_NAME));
		String uLastName = JSONHelper.getStringValue(returnObject, JSONHelper.convertKeyName(ReceiveClickAccountTabKeys.LAST_NAME));
		String username = JSONHelper.getStringValue(returnObject, JSONHelper.convertKeyName(ReceiveClickAccountTabKeys.USER_NAME));;
		String userRole = JSONHelper.getStringValue(returnObject, JSONHelper.convertKeyName(ReceiveClickAccountTabKeys.ROLE_ID));;
		String email = JSONHelper.getStringValue(returnObject, JSONHelper.convertKeyName(ReceiveClickAccountTabKeys.EMAIL));;
		
		JSONValue userListObjectStart = returnObject.get("userList");
		JSONArray userListObject = userListObjectStart.isArray();
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < userListObject.size(); i++) {
			
			JSONObject userObject = userListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.ID));
			String userName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.USER_NAME));
			String firstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.LAST_NAME));
			
			User user = new User();
			user.setId(id);
			user.setUserName(userName);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			
			userList.add(user);
		}
		
		// extract user role link list
		JSONValue userRoleLinkListObjectStart = returnObject.get("userRoleLinkList");
		JSONArray userRoleLinkListObject = userRoleLinkListObjectStart.isArray();
		List<UsersRolesLink> userRoleLinkList = new ArrayList<UsersRolesLink>();
		for (int i = 0; i < userRoleLinkListObject.size(); i++) 
		{
			JSONObject userRoleLinkObject = userRoleLinkListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(userRoleLinkObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.ID));
			Integer userId = JSONHelper.getIntValue(userRoleLinkObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.USER_ID));
			Integer roleId = JSONHelper.getIntValue(userRoleLinkObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.ROLE_ID));
			
			UsersRolesLink userRoleLink = new UsersRolesLink();
			userRoleLink.setId(id);
			userRoleLink.setUserId(userId);
			userRoleLink.setRoleId(roleId);
			
			userRoleLinkList.add(userRoleLink);
		}
		
		// instructorList
		JSONValue instructorListObjectStart = returnObject.get("instructorList");
		JSONArray instructorListObject = instructorListObjectStart.isArray();
		List<Instructor> instructorList = new ArrayList<Instructor>();
		for (int i = 0; i < instructorListObject.size(); i++) 
		{
			JSONObject instructorObject = instructorListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.ID));
			String firstName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.LAST_NAME));
			
			Instructor instructor = new Instructor();
			instructor.setId(id);
			instructor.setFirstName(firstName);
			instructor.setLastName(lastName);
			
			instructorList.add(instructor);
		}
		
		// get instructor user link list
		JSONValue instructorLinkListObjectStart = returnObject.get("instructorUserLinkList");
		JSONArray instructorLinkListObject = instructorLinkListObjectStart.isArray();
		List<InstructorUserLink> instructorLinkList = new ArrayList<InstructorUserLink>();
		for (int i = 0; i < instructorLinkListObject.size(); i++) 
		{
			JSONObject instructorLinkObject = instructorLinkListObject.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(instructorLinkObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.ID));
			Integer instructorId = JSONHelper.getIntValue(instructorLinkObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.INSTRUCTOR_ID));
			Integer linkedUserId = JSONHelper.getIntValue(instructorLinkObject, JSONHelper.convertKeyName(ReceiveEditUserKeys.LINKED_USER_ID));
			
			InstructorUserLink instructorUserLink = new InstructorUserLink();
			instructorUserLink.setId(id);
			instructorUserLink.setInstructorId(instructorId);
			instructorUserLink.setLinkedUserId(linkedUserId);
			
			instructorLinkList.add(instructorUserLink);
		}*/
		
		ReceiveClickScheduleTabAction action = new ReceiveClickScheduleTabAction(uFirstName, uLastName, username, userRole, email, userList, userRoleLinkList, instructorLinkList, instructorList);
		return action;
	}

}
