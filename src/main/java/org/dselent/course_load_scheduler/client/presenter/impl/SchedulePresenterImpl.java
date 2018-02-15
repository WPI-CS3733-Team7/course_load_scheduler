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
import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditSectionStrings;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEditSectionEventHandler;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleView;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class SchedulePresenterImpl extends BasePresenterImpl implements SchedulePresenter, InvalidEditSectionEventHandler {
	
	private IndexPresenter parentPresenter;
	private ScheduleView view;
	private boolean addInstructorClickInProgress;
	private boolean editInstructorClickInProgress;
	private boolean addCourseClickInProgress;
	private boolean editCourseClickInProgress;
	private boolean createSectionClickInProgress;
	private boolean editSectionClickInProgress;
	private boolean validateClickInProgress;
	private boolean submitEditInstructorClickInProgress;
	private boolean submitEditCourseClickInProgress;
	private boolean submitEditSectionClickInProgress;
	
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
		submitEditInstructorClickInProgress = false;
		submitEditCourseClickInProgress = false;
		submitEditSectionClickInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidEditSectionEvent.TYPE, this);
		eventBusRegistration.put(InvalidEditSectionEvent.TYPE, registration);
		
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
		
		if (!submitEditSectionClickInProgress)
		{
			submitEditSectionClickInProgress = true;
			view.getSectionSubmitButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			boolean validSectionName = true;
			boolean validSectionId = true;
			boolean validSectionType = true;
			boolean validPopulation = true;
			
			String sectionName = view.getSectionNameText().getText();
			String sectionId = view.getSectionIdText().getText();
			String sectionType = view.getSectionTypeText().getText();
			String population = view.getPopulationText().getText();
			
			List<String> invalidReasonList = new ArrayList<>();
			
			//
			
			try
			{
				validateField(sectionName);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_SECTION_NAME);
				validSectionName = false;
			}
			
			//
			
			try
			{
				validateField(sectionId);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_SECTION_ID);
				validSectionId = false;
			}
			
			//
			
			try
			{
				validateField(sectionType);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_SECTION_TYPE);
				validSectionType = false;
			}
			
			//
			
			try
			{
				validateField(population);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_POPULATION);
				validPopulation = false;
			}

			//
			
			if(validSectionName && validSectionId && validSectionType && validPopulation)
			{
				//sendRegister(userName, firstName, lastName, email, password);
			}
			else
			{
				InvalidEditSectionAction iesa = new InvalidEditSectionAction(invalidReasonList);
				InvalidEditSectionEvent iese = new InvalidEditSectionEvent(iesa);
				eventBus.fireEvent(iese);
			}
		}
		
	}
	
	@Override
	public void onInvalidEditSection(InvalidEditSectionEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getSectionSubmitButton().setEnabled(true);
		submitEditSectionClickInProgress = false;
		
		InvalidEditSectionAction iesa = evt.getAction();
		view.showErrorMessages(iesa.toString());
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}
	
	private void validateField(String field) throws EmptyStringException
	{
		checkEmptyString(field);
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
}
