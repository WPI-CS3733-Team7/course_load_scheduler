package org.dselent.course_load_scheduler.client.action;

public class SendClickAccountTabAction extends Action
{
	Integer userId;

	public SendClickAccountTabAction(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "SendClickAccountTabAction [userId=" + userId + "]";
	}
}
