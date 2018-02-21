package org.dselent.course_load_scheduler.client.action;

public class SendEditUserAction extends Action
{
	Integer userId;
	Integer editId;
	String userRole;
	Integer linkedInstructor;
	Boolean deleted;
	
	public SendEditUserAction(Integer userId, Integer editId, String userRole, Integer linkedInstructor, Boolean deleted)
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

	public Integer getLinkedInstructor() {
		return linkedInstructor;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getEditId() {
		return editId;
	}

	public Boolean getDeleted() {
		return deleted;
	}
}
