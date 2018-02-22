package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Request;

public class ReceiveRequestAction extends Action
{
	private List<Request> requestList;
	private String message;
	
	public ReceiveRequestAction(List<Request> requestList) {
		this.requestList = requestList;
	}

	public List<Request> getRequestList() {
		return requestList;
	}
	
	public ReceiveRequestAction(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String toString() {
		return "ReceiveRequestAction [requestList=" + requestList + " message= " + message + "]";
	}
}
