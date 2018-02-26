package org.dselent.course_load_scheduler.client.action;

public class SendSelectInstructorAction extends Action
{
	private Integer instructorId;
	private String term;
	private Integer year;
	private Integer userId;

	public SendSelectInstructorAction(Integer userId, Integer id, String term, Integer year) {
		instructorId = id;
		this.term = term;
		this.year = year;
		this.userId = userId;
	}

	public Integer getId() {
		return instructorId;
	}
	
	public String getTerm() {
		return term;
	}

	public Integer getYear() {
		return year;
	}
	
	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendSelectInstructorAction [userId=");
		builder.append(userId);
		builder.append(", instructorId=");
		builder.append(instructorId);
		builder.append(", term=");
		builder.append(term);
		builder.append(", year=");
		builder.append(year);
		builder.append("]");
		return builder.toString();
	}
}
