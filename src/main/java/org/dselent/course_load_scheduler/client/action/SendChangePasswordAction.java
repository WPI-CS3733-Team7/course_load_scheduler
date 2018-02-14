package org.dselent.course_load_scheduler.client.action;

public class SendChangePasswordAction
{
	String oldPassword;
	String newPassword;
	
	public SendChangePasswordAction(String oldPassword, String newPassword)
	{
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
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
