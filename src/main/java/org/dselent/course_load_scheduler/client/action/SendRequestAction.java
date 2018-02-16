package org.dselent.course_load_scheduler.client.action;

public class SendRequestAction {
	private String RequestType;
	
	public SendRequestAction (String RequestType) {
		this.RequestType = RequestType;
	}

	public String getrequestType() {
		return RequestType;
	}
	
	@Override
	public String toString() {
		return "SendRequestAction [RequestType=" + RequestType + "]";
	}	
}
