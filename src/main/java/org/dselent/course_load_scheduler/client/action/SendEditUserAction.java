package org.dselent.course_load_scheduler.client.action;

public class SendEditUserAction {
	
	String userRole;
	String linkedInstructor;
	String deleted;
	
	public SendEditUserAction(String userRole, String linkedInstructor, String deleted)
	{
		this.userRole = userRole;
		this.linkedInstructor = linkedInstructor;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getLinkedInstructor() {
		return linkedInstructor;
	}

	public String getDeleted() {
		return deleted;
	}
	
	@Override
	public String toString() {
		return "SendEditUserAction [userRole=" + userRole + ", linkedInstructor=" + linkedInstructor + ", deleted=" + deleted + "]";
	}

}
