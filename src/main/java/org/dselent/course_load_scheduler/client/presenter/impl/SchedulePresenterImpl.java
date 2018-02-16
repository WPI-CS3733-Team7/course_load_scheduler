package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;
import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditSectionStrings;
import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendValidateEvent;
import org.dselent.course_load_scheduler.client.event_handler.InvalidEditSectionEventHandler;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleView;
import org.dselent.course_load_scheduler.client.view.impl.ModelButton;

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
	public void selectInstructor(ModelButton<Instructor> clickedButton) {
		if(view.getSelectedInstructorButton()!=null)
			view.getSelectedInstructorButton().setText(view.getSelectedInstructorButton().getModel().displayText());
		clickedButton.setText("[[[ "+ clickedButton.getModel().displayText() +" ]]]");
		view.setSelectedInstructorButton(clickedButton);
	}

	@Override
	public void selectCourse(ModelButton<Course> clickedButton) {
		if(view.getSelectedCourseButton()!=null)
			view.getSelectedCourseButton().setText(view.getSelectedCourseButton().getModel().displayText());
		clickedButton.setText("[[[ "+ clickedButton.getModel().displayText() +" ]]]");
		view.setSelectedCourseButton(clickedButton);
		
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
				sendEditSection(sectionName, sectionId, sectionType, population);
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
	
	private void sendEditSection(String sectionName, String sectionId, String sectionType, String population)
	{
		SendEditSectionAction sesa = new SendEditSectionAction(sectionName, sectionId, sectionType, population);
		SendEditSectionEvent sese = new SendEditSectionEvent(sesa);
		eventBus.fireEvent(sese);
	}

	@Override
	public void validate() {
		
		if(!validateClickInProgress)
		{
			validateClickInProgress = true;
			view.getValidateButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			sendValidate();
		}
	}
	
	private void sendValidate()
	{
		SendValidateAction sva = new SendValidateAction();
		SendValidateEvent sve = new SendValidateEvent(sva);
		eventBus.fireEvent(sve);
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
