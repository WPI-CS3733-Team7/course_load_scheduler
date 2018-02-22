package org.dselent.course_load_scheduler.client.action;

public class SendRequestAction extends Action
{
	Integer userId;
	String RequestType;
	String Description;
	
	public SendRequestAction (String Description, String RequestType) {
		//this.userId = userId;
		this.RequestType = RequestType;
		this.Description = Description;
	}
	
	public String getDescription() {
		return Description;
	}

	public String getrequestType() {
		return RequestType;
	}
	
	/*@Override
	public String toString() {
		return "SendRequestAction [Description=" + Description + " RequestType=" + RequestType + "]";
	}*/

	public Integer getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}	
}
