package org.dselent.course_load_scheduler.client.action;

public class SendEditUserAction extends Action
{
	Integer userId;
	Integer editId;
	String userRole;
	String linkedInstructor;
	String deleted;
	
	public SendEditUserAction(Integer userId, Integer editId, String userRole, String linkedInstructor, String deleted)
	{
		this.userId = userId;
		this.editId = editId;
		this.userRole = userRole;
		this.linkedInstructor = linkedInstructor;
		this.deleted = deleted;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getLinkedInstructor() {
		return linkedInstructor;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getEditId() {
		return editId;
	}

	public String getDeleted() {
		return deleted;
	}
}
