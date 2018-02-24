package org.dselent.course_load_scheduler.client.action;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseSection;
import org.dselent.course_load_scheduler.client.model.Instructor;

public class ReceiveSelectCourseAction extends Action
{
	private List<Instructor> instructorList;
	private List<CourseSection> sectionList;
	private List<CalendarInfo> calInfoList;

	public ReceiveSelectCourseAction(List<Instructor> instructorList, List<CourseSection> sectionList, List<CalendarInfo> calInfoList) {
		this.instructorList = instructorList;
		this.sectionList = sectionList;
		this.calInfoList = calInfoList;
	}

	public List<Instructor> getInstructorList() {
		return instructorList;
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
		builder.append("ReceiveSelectCourseAction [instructorList=");
		builder.append(instructorList);
		builder.append(", sectionList=");
		builder.append(sectionList);
		builder.append(", calInfoList=");
		builder.append(calInfoList);
		builder.append("]");
		return builder.toString();
	}

}
