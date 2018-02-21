package org.dselent.course_load_scheduler.client.action;

public class ReceiveRegisterAction extends Action
{
	private String message;

	public ReceiveRegisterAction(String message)
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
		builder.append("ReceiveRegisterAction [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}


}
