package org.dselent.course_load_scheduler.client.action;

public class SendClickUserRequestTabAction extends Action
{
	Integer userId;

	public SendClickUserRequestTabAction(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "SendClickUserRequestTabAction [userId=" + userId + "]";
	}
}
