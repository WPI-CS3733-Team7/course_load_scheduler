package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Request;

public class ReceiveReplyAction extends Action
{
	private Request request;

	public ReceiveReplyAction(Request request)
	{
		this.request = request;
	}

	public Request getRequest()
	{
		return request;
	}

	public void setModel(Request request)
	{
		this.request = request;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveReplyAction [request=");
		builder.append(request);
		builder.append("]");
		return builder.toString();
	}
}
