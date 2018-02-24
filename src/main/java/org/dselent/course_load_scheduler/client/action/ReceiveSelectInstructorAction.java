package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseSection;

public class ReceiveSelectInstructorAction extends Action
{
	private List<CourseSection> sectionList;
	private List<CalendarInfo> calInfoList;

	public ReceiveSelectInstructorAction(List<CourseSection> sectionList, List<CalendarInfo> calInfoList) {
		// TODO Auto-generated constructor stub
	}

	public List<CourseSection> getSectionList() {
		return sectionList;
	}

	public List<CalendarInfo> getCalInfoList() {
		return calInfoList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveSelectInstructorAction [sectionList=");
		builder.append(sectionList);
		builder.append(", calInfoList=");
		builder.append(calInfoList);
		builder.append("]");
		return builder.toString();
	}

}
