package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.CourseSection;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;

public class ReceiveEditSectionAction extends Action
{
	private CourseSection courseSection;
	private CalendarInfo calendarInfo;
	
	public ReceiveEditSectionAction(CourseSection courseSection, CalendarInfo calendarInfo) {
		super();
		this.courseSection = courseSection;
		this.calendarInfo = calendarInfo;
	}
	
	public CourseSection getCourseSection() {
		return courseSection;
	}



	public void setCourseSection(CourseSection courseSection) {
		this.courseSection = courseSection;
	}



	public CalendarInfo getCalendarInfo() {
		return calendarInfo;
	}



	public void setCalendarInfo(CalendarInfo calendarInfo) {
		this.calendarInfo = calendarInfo;
	}

	@Override
	public String toString() {
		return "ReceiveEditSectionAction [courseSection=" + courseSection + ", calendarInfo=" + calendarInfo + "]";
	}
}
