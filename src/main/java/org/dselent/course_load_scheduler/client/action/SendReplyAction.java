package org.dselent.course_load_scheduler.client.action;

public class SendReplyAction {

	private String response;
	private String replyType;
	
	public SendReplyAction(String response, String replyType) {
		this.response = response;
		this.replyType = replyType;
	}

	public String getresponse() {
		return response;
	}

	public String getrequestType() {
		return replyType;
	}
	

	@Override
	public String toString() {
		return "SendReplyAction [response=" + response + ", replyType=" + replyType + "]";
	}	

}
