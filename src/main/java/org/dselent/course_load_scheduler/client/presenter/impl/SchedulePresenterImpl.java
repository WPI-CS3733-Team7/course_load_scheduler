package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;
//import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
//import org.dselent.course_load_scheduler.client.action.InvalidRegisterAction;
//import org.dselent.course_load_scheduler.client.action.SendLoginAction;
//import org.dselent.course_load_scheduler.client.action.SendRegisterAction;
//import org.dselent.course_load_scheduler.client.errorstring.InvalidLoginStrings;
//import org.dselent.course_load_scheduler.client.errorstring.InvalidRegisterStrings;
//import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
//import org.dselent.course_load_scheduler.client.event.InvalidRegisterEvent;
//import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
//import org.dselent.course_load_scheduler.client.event.SendRegisterEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleView;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class SchedulePresenterImpl extends BasePresenterImpl implements SchedulePresenter {
	
	private IndexPresenter parentPresenter;
	private ScheduleView view;
	private boolean addInstructorClickInProgress;
	private boolean editInstructorClickInProgress;
	private boolean addCourseClickInProgress;
	private boolean editCourseClickInProgress;
	private boolean createSectionClickInProgress;
	private boolean editSectionClickInProgress;
	private boolean validateClickInProgress;
	private boolean submitClickInProgress;
	
	@Inject
	public SchedulePresenterImpl(IndexPresenter parentPresenter, ScheduleView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		addInstructorClickInProgress = false;
		editInstructorClickInProgress = false;
		addCourseClickInProgress = false;
		editCourseClickInProgress = false;
		createSectionClickInProgress = false;
		editSectionClickInProgress = false;
		validateClickInProgress = false;
		submitClickInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	// event handlers - CHANGE FROM REGISTER AND LOGIN
	
	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		/*registration = eventBus.addHandler(InvalidLoginEvent.TYPE, this);
		eventBusRegistration.put(InvalidLoginEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidRegisterEvent.TYPE, this);
		eventBusRegistration.put(InvalidRegisterEvent.TYPE, registration);*/
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());		
	}
	
	@Override
	public ScheduleView getView()
	{
		return view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;		
	}

	@Override
	public void deleteInstructor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editInstructor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectInstructor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editSection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
