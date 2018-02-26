package org.dselent.course_load_scheduler.client.action;

public class SendSelectCourseAction extends Action
{
	private Integer courseId;
	private Integer year;
	private String term;
	private Integer userId;

	public SendSelectCourseAction(Integer userId, Integer id, String term, Integer year) {
		courseId = id;
		this.term = term;
		this.year = year;
		this.userId = userId;
	}

	public Integer getId()
	{
		return courseId;
	}

	public Integer getYear() {
		return year;
	}

	public String getTerm() {
		return term;
	}

	public Integer getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendSelectCourseAction [userId=");
		builder.append(userId);
		builder.append(", courseId=");
		builder.append(courseId);
		builder.append(", year=");
		builder.append(year);
		builder.append(", term=");
		builder.append(term);
		builder.append("]");
		return builder.toString();
	}

	

}
