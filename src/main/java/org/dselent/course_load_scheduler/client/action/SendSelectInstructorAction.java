package org.dselent.course_load_scheduler.client.action;

public class SendSelectInstructorAction extends Action
{
	private Integer instructorId;
	private String term;
	private Integer year;

	public SendSelectInstructorAction(Integer id, String term, Integer year) {
		instructorId = id;
		this.term = term;
		this.year = year;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendSelectInstructorAction [instructorId=");
		builder.append(instructorId);
		builder.append(", term=");
		builder.append(term);
		builder.append(", year=");
		builder.append(year);
		builder.append("]");
		return builder.toString();
	}
}
