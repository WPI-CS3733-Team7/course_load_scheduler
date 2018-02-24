package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.CreateRequestEvent;
import org.dselent.course_load_scheduler.client.event.InvalidChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.InvalidCreateCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidCreateInstructorEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditUserEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidRegisterEvent;
import org.dselent.course_load_scheduler.client.event.InvalidReplyEvent;
import org.dselent.course_load_scheduler.client.event.InvalidRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveClickAccountTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveClickScheduleTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditUserEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveRegisterEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveReplyEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectInstructorEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveValidateEvent;
import org.dselent.course_load_scheduler.client.event.SelectRequestEvent;
import org.dselent.course_load_scheduler.client.event.SendChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.SendClickAccountTabEvent;
import org.dselent.course_load_scheduler.client.event.SendClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.event.SendClickScheduleTabEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendEditUserEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.event.SendRegisterEvent;
import org.dselent.course_load_scheduler.client.event.SendReplyEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestEvent;
import org.dselent.course_load_scheduler.client.event.SendSelectCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendSelectInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendValidateEvent;

/**
 * Adapter class for convenience
 * All classes that need to implement an event handler can extend from this class
 * This allows for presenters or other classes not to implement a large number of handler interfaces
 * Need to register all event handling functions with this class by implementing the handler and
 * overriding with an empty method
 * 
 * @author dselent
 * 
 */
public abstract class EventHandlerAdapter implements 
CreateRequestEventHandler,
InvalidChangePasswordEventHandler,
InvalidCreateCourseEventHandler,
InvalidCreateInstructorEventHandler,
InvalidEditSectionEventHandler,
InvalidEditUserEventHandler,
InvalidLoginEventHandler,
InvalidRegisterEventHandler,
InvalidReplyEventHandler,
InvalidRequestEventHandler,
ReceiveChangePasswordEventHandler,
ReceiveClickAccountTabEventHandler,
ReceiveClickScheduleTabEventHandler,
ReceiveClickRequestTabEventHandler,
ReceiveEditCourseEventHandler,
ReceiveEditInstructorEventHandler,
ReceiveEditSectionEventHandler,
ReceiveEditUserEventHandler,
ReceiveLoginEventHandler,
ReceiveRegisterEventHandler,
ReceiveReplyEventHandler,
ReceiveRequestEventHandler,
ReceiveValidateEventHandler,
ReceiveSelectInstructorEventHandler,
ReceiveSelectCourseEventHandler,
SelectRequestEventHandler,
SendChangePasswordEventHandler,
SendClickAccountTabEventHandler,
SendClickScheduleTabEventHandler,
SendClickRequestTabEventHandler,
SendEditCourseEventHandler,
SendEditInstructorEventHandler,
SendEditSectionEventHandler,
SendEditUserEventHandler,
SendLoginEventHandler,
SendLogoutEventHandler,
SendRegisterEventHandler,
SendReplyEventHandler,
SendRequestEventHandler,
SendValidateEventHandler,
SendSelectInstructorEventHandler,
SendSelectCourseEventHandler
{
	@Override
	public void onCreateRequest(CreateRequestEvent evt) {}
	
	@Override
	public void onInvalidChangePassword(InvalidChangePasswordEvent evt) {}
	
	@Override
	public void onInvalidCreateCourse(InvalidCreateCourseEvent evt) {}
	
	@Override
	public void onInvalidCreateInstructor(InvalidCreateInstructorEvent evt) {}
	
	@Override
	public void onInvalidEditSection(InvalidEditSectionEvent evt) {}
	
	@Override
	public void onInvalidEditUser(InvalidEditUserEvent evt) {}
	
	@Override
	public void onInvalidLogin(InvalidLoginEvent evt) {}
	
	@Override
	public void onInvalidRegister(InvalidRegisterEvent evt) {}
	
	@Override
	public void onInvalidRequest(InvalidRequestEvent evt) {}
	
	@Override
	public void onInvalidReply(InvalidReplyEvent evt) {}
	
	@Override
	public void onReceiveChangePassword(ReceiveChangePasswordEvent evt) {}
	
	@Override
	public void onReceiveClickAccountTab(ReceiveClickAccountTabEvent evt) {}
	
	@Override
	public void onReceiveClickScheduleTab(ReceiveClickScheduleTabEvent evt) {}
	
	@Override
	public void onReceiveClickRequestTab(ReceiveClickRequestTabEvent evt) {}
	
	@Override
	public void onReceiveEditCourse(ReceiveEditCourseEvent evt) {}
	
	@Override
	public void onReceiveEditInstructor(ReceiveEditInstructorEvent evt) {}
	
	@Override
	public void onReceiveEditSection(ReceiveEditSectionEvent evt) {}
	
	@Override
	public void onReceiveEditUser(ReceiveEditUserEvent evt) {}

	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt) {}
	
	@Override
	public void onReceiveRegister(ReceiveRegisterEvent evt) {}
	
	@Override
	public void onReceiveReply(ReceiveReplyEvent evt) {}
	
	@Override
	public void onReceiveRequest(ReceiveRequestEvent evt) {}
	
	@Override
	public void onReceiveValidate(ReceiveValidateEvent evt) {}
	
	@Override
	public void onReceiveSelectInstructor(ReceiveSelectInstructorEvent evt) {}
	
	@Override
	public void onReceiveSelectCourse(ReceiveSelectCourseEvent evt) {}
	
	@Override
	public void onSelectRequest(SelectRequestEvent evt) {}
	
	@Override
	public void onSendClickAccountTab(SendClickAccountTabEvent evt) {}
	
	@Override
	public void onSendClickScheduleTab(SendClickScheduleTabEvent evt) {}
	
	@Override
	public void onSendClickRequestTab(SendClickRequestTabEvent evt) {}
	
	@Override
	public void onSendChangePassword(SendChangePasswordEvent evt) {}
		
	@Override
	public void onSendEditCourse(SendEditCourseEvent evt) {}
	
	@Override
	public void onSendEditInstructor(SendEditInstructorEvent evt) {}
	
	@Override
	public void onSendEditSection(SendEditSectionEvent evt) {}
	
	@Override
	public void onSendEditUser(SendEditUserEvent evt) {}
	
	@Override
	public void onSendLogin(SendLoginEvent evt) {}
	
	@Override
	public void onSendLogout(SendLogoutEvent evt) {}
	
	@Override
	public void onSendRegister(SendRegisterEvent evt) {}
	
	@Override
	public void onSendReply(SendReplyEvent evt) {}
	
	@Override
	public void onSendRequest(SendRequestEvent evt) {}
	
	@Override
	public void onSendValidate(SendValidateEvent evt) {}
	
	@Override
	public void onSendSelectInstructor(SendSelectInstructorEvent evt) {}
	
	@Override
	public void onSendSelectCourse(SendSelectCourseEvent evt) {}
}
