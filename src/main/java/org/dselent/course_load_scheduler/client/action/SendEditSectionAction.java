package org.dselent.course_load_scheduler.client.action;

public class SendEditSectionAction {
	
	private String sectionName;
	private String sectionId;
	private String sectionType;
	private String population;
	private String year;
	private String term;
	private String days;
	private String startTime;
	private String endTime;
	
	public SendEditSectionAction(String sectionName, String sectionId, String sectionType, String population, String year, String term, String days, String startTime,
			String endTime)
	{
		this.sectionName = sectionName;
		this.sectionId= sectionId;
		this.sectionType = sectionType;
		this.population = population;
		this.year = year;
		this.term = term;
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
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
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendEditSectionAction [sectionName=");
		builder.append(sectionName);
		builder.append(", sectionId=");
		builder.append(sectionId);
		builder.append(", sectionType=");
		builder.append(sectionType);
		builder.append(", population=");
		builder.append(population);
		builder.append(", year=");
		builder.append(year);
		builder.append(", term=");
		builder.append(term);
		builder.append(", days=");
		builder.append(days);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}

}
