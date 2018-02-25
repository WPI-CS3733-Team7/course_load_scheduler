package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.List;
import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveEditUserAction;
import org.dselent.course_load_scheduler.client.action.SendEditUserAction;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.InstructorUserLink;
import org.dselent.course_load_scheduler.client.model.User;
import org.dselent.course_load_scheduler.client.model.UsersRolesLink;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveEditUserKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendEditUserKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class EditUserActionTranslatorImpl implements ActionTranslator<SendEditUserAction, ReceiveEditUserAction>
{
	@Override
	public JSONObject translateToJson(SendEditUserAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendEditUserKeys.EDIT_ID), action.getEditId());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendEditUserKeys.USER_ROLE), action.getUserRole());
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendEditUserKeys.LINKED_INSTRUCTOR), action.getLinkedInstructor());
		JSONHelper.putBooleanValue(jsonObject, JSONHelper.convertKeyName(SendEditUserKeys.DELETED), action.getDeleted());
		
		return jsonObject;
	}

	@Override
	public ReceiveEditUserAction translateToAction(JSONObject json) {
		
		JSONValue jsonEditUserObject = json.get("success");
		JSONObject editUserObject = jsonEditUserObject.isObject();
		
		JSONValue jsonEditUser = editUserObject.get("returnObject");
		JSONObject editUser = jsonEditUser.isObject();
		
		// extract user list
		JSONValue userListObjectStart = editUser.get("userList");
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
		JSONValue userRoleLinkListObjectStart = editUser.get("userRoleLinkList");
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
		JSONValue instructorListObjectStart = editUser.get("instructorList");
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
		JSONValue instructorLinkListObjectStart = editUser.get("instructorUserLinkList");
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
		}
		
		return new ReceiveEditUserAction(userList, userRoleLinkList, instructorList, instructorLinkList);
	}
}
