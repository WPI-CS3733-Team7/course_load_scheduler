package org.dselent.course_load_scheduler.client.action;

public class SelectRequestAction {
	private String requestType;
	private Integer requester;
	private String description;
	
	public SelectRequestAction(Integer requester, String requestType, String description) {
		this.requester = requester;
		this.requestType = requestType;
		this.description = description;
	}

	public Integer getrequester() {
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
