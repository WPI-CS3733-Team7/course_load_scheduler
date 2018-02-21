package org.dselent.course_load_scheduler.client.action;

public class SendChangePasswordAction extends Action
{
	Integer userId;
	String oldPassword;
	String newPassword;
	
	public SendChangePasswordAction(Integer userId, String oldPassword, String newPassword)
	{
		this.userId = userId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	@Override
	public String toString() {
		return "SendChangePasswordAction [oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
}
