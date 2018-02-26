package org.dselent.course_load_scheduler.client.action;

public class SendEditSectionAction extends Action
{
	private Integer userId;
	private String id;
	private String instructorId;
	private String calendarInfoId;
	private String courseId;
	private String sectionName;
	private String sectionId;
	private String sectionType;
	private String population;
	private String year;
	private String term;
	private String days;
	private String startTime;
	private String endTime;
	private String deleted;
	
	public SendEditSectionAction(Integer userId, String id, String instructorId, String calendarInfoId, String courseId, String sectionName, String sectionId, String sectionType, String population, String year, String term, String days, String startTime,
			String endTime, String deleted)
	{
		this.userId = userId;
		this.id = id;
		this.instructorId = instructorId;
		this.calendarInfoId = calendarInfoId;
		this.courseId = courseId;
		this.sectionName = sectionName;
		this.sectionId= sectionId;
		this.sectionType = sectionType;
		this.population = population;
		this.year = year;
		this.term = term;
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
		this.deleted = "false";
	}

	public Integer getUserId() {
		return userId;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getInstructorId()
	{
		return instructorId;
	}
	
	public String getCalendarInfoId()
	{
		return calendarInfoId;
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	public String getSectionName()
	{
		return sectionName;
	}

	public String getSectionId()
	{
		return sectionId;
	}
	
	public String getSectionType()
	{
		return sectionType;
	}
	
	public String getPopulation()
	{
		return population;
	}
	
	public String getYear() {
		return year;
	}

	public String getTerm() {
		return term;
	}

	public String getDays() {
		return days;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "SendEditSectionAction [userId=" + userId + ", id=" + id + ", instructorId=" + instructorId
				+ ", calendarInfoId=" + calendarInfoId + ", courseId=" + courseId + ", sectionName=" + sectionName
				+ ", sectionId=" + sectionId + ", sectionType=" + sectionType + ", population=" + population + ", year="
				+ year + ", term=" + term + ", days=" + days + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", deleted=" + deleted + "]";
	}

	public String getDeleted() {
		// TODO Auto-generated method stub
		return deleted;
	}
}
