package org.dselent.course_load_scheduler.client.action;

public class ReceiveChangePasswordAction extends Action
{
	private String message;

	public ReceiveChangePasswordAction(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveChangePasswordAction [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}


}
