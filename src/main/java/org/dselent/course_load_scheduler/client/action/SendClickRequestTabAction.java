package org.dselent.course_load_scheduler.client.action;

public class SendClickRequestTabAction {
	Integer userId;

	public SendClickRequestTabAction(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "SendClickRequestTabAction [userId=" + userId + "]";
	}
}
