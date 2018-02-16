package org.dselent.course_load_scheduler.client.action;

public class SendEditSectionAction {
	
	private String sectionName;
	private String sectionId;
	private String sectionType;
	private String population;
	
	public SendEditSectionAction(String sectionName, String sectionId, String sectionType, String population)
	{
		this.sectionName = sectionName;
		this.sectionId= sectionId;
		this.sectionType = sectionType;
		this.population = population;
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
		builder.append("]");
		return builder.toString();
	}

}
