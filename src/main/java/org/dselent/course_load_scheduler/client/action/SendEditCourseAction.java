package org.dselent.course_load_scheduler.client.action;

public class SendEditCourseAction extends Action
{
	private Integer userId;
	private String courseId;
	private String courseName;
	private String courseNumber;
	private String frequency;
	private String deleted;
	
	public SendEditCourseAction(Integer userId, String courseId, String courseName, String courseNumber, String frequency, String deleted)
	{
		this.userId = userId;
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.frequency = frequency;
		this.deleted = deleted;
	}

	public Integer getUserId()
	{
		return userId;
	}
	
	public String getCourseId()
	{
		return courseId;
	}

	public String getCourseName()
	{
		return courseName;
	}
	
	public String getCourseNumber()
	{
		return courseNumber;
	}
	
	public String getFrequency()
	{
		return frequency;
	}
	
	public String getDeleted()
	{
		return deleted;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendEditCourseAction [courseId=");
		builder.append(courseId);
		builder.append(", courseName=");
		builder.append(courseName);
		builder.append(", courseNumber=");
		builder.append(courseNumber);
		builder.append(", frequency=");
		builder.append(frequency);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}

}
