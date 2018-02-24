package org.dselent.course_load_scheduler.client.action;

public class SendReplyAction extends Action
{
	private Integer userId;
	private Integer requestId;
	private String response;
	private String replyType;
	
	public SendReplyAction(Integer requestId, String response, String replyType) {
		
		this.response = response;
		this.replyType = replyType;
	}

	public Integer getRequestId() {
		return requestId;
	}
	
	public String getResponse() {
		return response;
	}

	public String getReplyType() {
		return replyType;
	}
	
	public Integer getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}	

	/*@Override
	public String toString() {
		return "SendReplyAction [requestId=" + requestId + "response=" + response + ", replyType=" + replyType + "]";
	}	*/

}
