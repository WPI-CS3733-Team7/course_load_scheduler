package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Request;

public class ReceiveClickRequestTabAction extends Action
{
	List<Request> requestList;
	
	public ReceiveClickRequestTabAction(List<Request> requestList) {
		this.requestList = requestList;
	}
	
	public List<Request> getRequestList(){
		return requestList;
	}
	
	public void setRequestList(List<Request> requestList) {
		this.requestList = requestList;
	}
	
	@Override
	public String toString() {
		return "ReceiveClickRequestTabAction [requestList=" + requestList + "]";
	}
}
