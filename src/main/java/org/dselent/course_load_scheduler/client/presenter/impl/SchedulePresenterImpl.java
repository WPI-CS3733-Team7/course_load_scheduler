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
import org.dselent.course_load_scheduler.client.action.InvalidRegisterAction;
import org.dselent.course_load_scheduler.client.action.SendRegisterAction;
import org.dselent.course_load_scheduler.client.action.SendEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditSectionStrings;
import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidRegisterEvent;
import org.dselent.course_load_scheduler.client.event.SendRegisterEvent;
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
	public void editInstructor(boolean deleting) {
		if (!submitEditInstructorClickInProgress)
		{
			submitEditInstructorClickInProgress = true;
			String firstName = view.getPopInstructorTextFirstName().getText();
			String lastName = view.getPopInstructorTextLastName().getText();
			String rank = view.getPopInstructorTextRank().getText();
			String email = view.getPopInstructorTextEmail().getText();
			if(view.isCreating())
			{
				boolean validFirstName = true;
				boolean validLastName = true;
				boolean validRank = true;
				boolean validEmail = true;
				List<String> invalidReasonList = new ArrayList<>();
				try {
					validateField(firstName);
				} catch (EmptyStringException e)
				{
					invalidReasonList.add(InvalidEditInstructorStrings.NULL_FIRST_NAME);
					validFirstName = false;
				}
				try {
					validateField(lastName);
				} catch (EmptyStringException e)
				{
					invalidReasonList.add(InvalidEditInstructorStrings.NULL_LAST_NAME);
					validLastName = false;
				}
				try {
					validateField(rank);
				} catch (EmptyStringException e)
				{
					invalidReasonList.add(InvalidEditInstructorStrings.NULL_RANK);
					validRank = false;
				}
				try {
					validateField(email);
				} catch (EmptyStringException e)
				{
					invalidReasonList.add(InvalidEditInstructorStrings.NULL_EMAIL);
					validEmail = false;
				}
				
				if(validFirstName && validLastName && validRank && validEmail)
				{
				sendInstructorEdit(null, firstName, lastName, rank, email, false);
				}
				else
				{
					InvalidInstructorCreateAction iica = new InvalidInstructorCreateAction(invalidReasonList);
					InvalidInstructorCreateEvent iice = new InvalidInstructorCreateEvent(iica);
					eventBus.fireEvent(iice);
				}
			} else {
				sendInstructorEdit(view.getSelectedInstructorButton().getModel().getId(), firstName, lastName, rank, email, deleting);
			}
			view.getInstructorSubmitButton().setEnabled(false);
			
		}
		
	}
	
	
	private void sendInstructorEdit(Integer id, String firstName, String lastName, String rank, String email, boolean deleted)
	{
		SendInstructorEditAction siea = new SendInstructorEditAction(firstName, lastName, rank, email, deleted);
		SendInstructorEditEvent siee = new SendInstructorEditEvent(siea);
		eventBus.fireEvent(siee);
	}


	@Override
	public void editCourse(boolean deleting) {
		if (!submitEditCourseClickInProgress)
		{
			submitEditCourseClickInProgress = true;
			String courseName = view.getPopCourseTextName().getText();
			String courseNumber = view.getPopCourseTextNumber().getText();
			String frequency = view.getPopCourseTextFrequency().getText();
			if(view.isCreating())
			{
				boolean validCourseName = true;
				boolean validCourseNumber = true;
				boolean validFrequency = true;
				List<String> invalidReasonList = new ArrayList<>();
				try {
					validateField(courseName);
				} catch (EmptyStringException e)
				{
					invalidReasonList.add(InvalidEditCourseStrings.NULL_NAME);
					validCourseName = false;
				}
				try {
					validateField(courseNumber);
				} catch (EmptyStringException e)
				{
					invalidReasonList.add(InvalidEditCourseStrings.NULL_NUMBER);
					validCourseNumber = false;
				}
				try {
					validateField(frequency);
				} catch (EmptyStringException e)
				{
					invalidReasonList.add(InvalidEditCourseStrings.NULL_FREQUENCY);
					validFrequency = false;
				}
				
				if(validCourseName && validCourseNumber && validFrequency)
				{
					sendCourseEdit(null, courseName, courseNumber, frequency, false);
				}
				else
				{
					InvalidCourseCreateAction icca = new InvalidCourseCreateAction(invalidReasonList);
					InvalidCourseCreateEvent icce = new InvalidCourseCreateEvent(icca);
					eventBus.fireEvent(icce);
				}
			} else {
				sendInstructorEdit(view.getSelectedInstructorButton().getModel().getId(), courseName, courseNumber, frequency, deleting);
			}
			view.getInstructorSubmitButton().setEnabled(false);
			
		}
		
	}

	private void sendCourseEdit(Integer id, String courseName, String courseNumber, String frequency, boolean deleted) {
		SendCourseEditAction scea = new SendCourseEditAction(id, courseName, courseNumber, frequency, deleted);
		SendCourseEditEvent scee = new SendCourseEditEvent(scea);
		eventBus.fireEvent(scee);	
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
