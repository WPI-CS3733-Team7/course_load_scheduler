package org.dselent.course_load_scheduler.client.action;

public class ReceiveSelectRequestAction extends Action{
	
	private Integer requesterId;
	private String type;
	private String detail;
	
	public ReceiveSelectRequestAction(Integer requesterId, String type, String detail) {
		this.requesterId = requesterId;
		this.type = type;
		this.detail = detail;
	}
	
	public Integer getRequesterId() {
		return requesterId;
	}
	
	public void setRequesterId(Integer requesterId) {
		this.requesterId = requesterId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveSelectRequestAction [requesterId=");
		builder.append(requesterId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", detail=");
		builder.append(detail);
		builder.append("]");
		return builder.toString();
	}
}
