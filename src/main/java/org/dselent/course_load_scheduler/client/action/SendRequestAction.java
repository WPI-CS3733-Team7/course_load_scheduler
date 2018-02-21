package org.dselent.course_load_scheduler.client.action;

public class SendRequestAction extends Action
{
	private String RequestType;
	private String Description;
	
	public SendRequestAction (String Description, String RequestType) {
		this.RequestType = RequestType;
		this.Description = Description;
	}
	
	public String getDescription() {
		return Description;
	}

	public String getrequestType() {
		return RequestType;
	}
	
	@Override
	public String toString() {
		return "SendRequestAction [Description=" + Description + " RequestType=" + RequestType + "]";
	}	
}
