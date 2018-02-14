package org.dselent.course_load_scheduler.client.action;

public class SendRequestAction {
	private String requestType;
	private String requester;
	private String description;
	
	public SendRequestAction(String requester, String requestType, String description) {
		this.requester = requester;
		this.requestType = requestType;
		this.description = description;
	}

	public String getrequester() {
		return requester;
	}

	public String getrequestType() {
		return requestType;
	}
	
	public String getdescription() {
		return description;
	}

	@Override
	public String toString() {
		return "SendRequestAction [re=" + requester + ", requestType=" + requestType + ", description=" + description
				+ "]";
	}	
}
