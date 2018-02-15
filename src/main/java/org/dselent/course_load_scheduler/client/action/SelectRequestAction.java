package org.dselent.course_load_scheduler.client.action;

public class SelectRequestAction {
	private String requestType;
	private String requester;
	private String description;
	
	public SelectRequestAction(String requester, String requestType, String description) {
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
		return "SelectRequestAction [requester=" + requester + ", requestType=" + requestType + ", description=" + description
				+ "]";
	}	
}
