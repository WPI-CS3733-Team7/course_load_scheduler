package org.dselent.course_load_scheduler.client.action;

public class CreateRequestAction extends Action
{
	private String requestType;
	
	public CreateRequestAction(String requestType) {
		this.requestType = requestType;
	}

	public String getrequestType() {
		return requestType;
	}
	
	@Override
	public String toString() {
		return "CreateRequestAction [requestType=" + requestType + "]";
	}	
}
