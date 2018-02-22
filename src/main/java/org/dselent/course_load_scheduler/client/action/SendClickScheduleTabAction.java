package org.dselent.course_load_scheduler.client.action;

public class SendClickScheduleTabAction extends Action 
{	
	Integer userId;

	public SendClickScheduleTabAction(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "SendClickScheduleTabAction [userId=" + userId + "]";
	}

}
