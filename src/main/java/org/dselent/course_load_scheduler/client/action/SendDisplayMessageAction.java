package org.dselent.course_load_scheduler.client.action;

public class SendDisplayMessageAction
{
	private String message;	
	
	public SendDisplayMessageAction(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SendDisplayMessageAction [message=" + message + "]";
	}
}
