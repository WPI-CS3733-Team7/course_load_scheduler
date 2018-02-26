package org.dselent.course_load_scheduler.client.action;

public class SendRequestAction extends Action
{
	Integer User_Id;
	String RequestType;
	String Description;
	
	public SendRequestAction (Integer userId, String Description, String RequestType) {
		this.User_Id = userId;
		this.RequestType = RequestType;
		this.Description = Description;
	}
	
	public Integer getUserId() {
		return User_Id;
	}
	
	public String getDescription() {
		return Description;
	}

	public String getrequestType() {
		return RequestType;
	}
	
	@Override
	public String toString() {
		return "SendRequestAction [UserID =" + User_Id + " Description=" + Description + " RequestType=" + RequestType + "]";
	}
}
