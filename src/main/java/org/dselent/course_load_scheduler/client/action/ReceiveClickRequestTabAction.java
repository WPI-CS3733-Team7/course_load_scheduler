package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Request;


public class ReceiveClickRequestTabAction {
	List<Request> requestList;

	public ReceiveClickRequestTabAction(List<Request> requestList) 
	{
		super();
		this.requestList = requestList;
	}

	public List<Request> getRequestList() {
		return requestList;
	}

	@Override
	public String toString() {
		return "ReceiveClickAccountTabAction [requestList=" + requestList + "]";
	}	
}

