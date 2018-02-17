package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidCreateCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidCreateInstructorAction;
import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.InvalidRegisterAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendRegisterAction;
import org.dselent.course_load_scheduler.client.action.SendEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditCourseStrings;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditInstructorStrings;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditSectionStrings;
import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidCreateCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidCreateInstructorEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidRegisterEvent;
import org.dselent.course_load_scheduler.client.event.SendRegisterEvent;
import org.dselent.course_load_scheduler.client.event.SendEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendValidateEvent;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCreateCourseEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCreateInstructorEventHandler;
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

public class SchedulePresenterImpl extends BasePresenterImpl implements SchedulePresenter, InvalidCreateInstructorEventHandler,
InvalidCreateCourseEventHandler, InvalidEditSectionEventHandler {
	
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
		
		registration = eventBus.addHandler(InvalidCreateInstructorEvent.TYPE, this);
		eventBusRegistration.put(InvalidCreateInstructorEvent.TYPE, registration);
		
		registration = eventBus.addHandler(InvalidCreateCourseEvent.TYPE,  this);
		eventBusRegistration.put(InvalidCreateCourseEvent.TYPE, registration);				
		
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
					InvalidCreateInstructorAction iica = new InvalidCreateInstructorAction(invalidReasonList);
					InvalidCreateInstructorEvent iice = new InvalidCreateInstructorEvent(iica);
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
		SendEditInstructorAction siea = new SendEditInstructorAction(id.toString(), firstName, lastName, rank, email, Boolean.toString(deleted));
		SendEditInstructorEvent siee = new SendEditInstructorEvent(siea);
		eventBus.fireEvent(siee);
	}
	
	@Override
	public void onInvalidCreateInstructor(InvalidCreateInstructorEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getAddInstructorButton().setEnabled(true);
		addInstructorClickInProgress = false;
		
		InvalidCreateInstructorAction icia = evt.getAction();
		view.showErrorMessages(icia.toString());
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
					InvalidCreateCourseAction icca = new InvalidCreateCourseAction(invalidReasonList);
					InvalidCreateCourseEvent icce = new InvalidCreateCourseEvent(icca);
					eventBus.fireEvent(icce);
				}
			} else {
				sendCourseEdit(view.getSelectedInstructorButton().getModel().getId(), courseName, courseNumber, frequency, deleting);
			}
			view.getCourseSubmitButton().setEnabled(false);
			
		}
		
	}

	private void sendCourseEdit(Integer id, String courseName, String courseNumber, String frequency, boolean deleted) {
		SendEditCourseAction scea = new SendEditCourseAction(id.toString(), courseName, courseNumber, frequency, Boolean.toString(deleted));
		SendEditCourseEvent scee = new SendEditCourseEvent(scea);
		eventBus.fireEvent(scee);	
	}
	
	@Override
	public void onInvalidCreateCourse(InvalidCreateCourseEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getAddCourseButton().setEnabled(true);
		addCourseClickInProgress = false;
		
		InvalidCreateCourseAction icca = evt.getAction();
		view.showErrorMessages(icca.toString());
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
			boolean validYear = true;
			boolean validTerm = true;
			boolean validDays = true;
			boolean validStartTime = true;
			boolean validEndTime = true;
			
			String sectionName = view.getSectionNameText().getText();
			String sectionId = view.getSectionIdText().getText();
			//String sectionType = view.getSectionTypeListBox().getSelectedItemText();
			String population = view.getPopulationText().getText();
			String year = view.getYearText().getText();
			String term = view.getTermText().getText();
			//String days = view.
			
			String day = "";
			if(view.getMonday().isEnabled() == true) {
				day = "Monday";
			}
			else if(view.getTuesday().isEnabled() == true) {
				day = "Tuesday";
			}
			else if(view.getWednesday().isEnabled() == true) {
				day = "Wednesday";
			}
			else if(view.getThursday().isEnabled() == true) {
				day = "Thursday";
			}
			else if(view.getFriday().isEnabled() == true) {
				day = "Friday";
			}
			
			String startTime = view.getStartTimeText().getText();
			String endTime = view.getEndTimeText().getText();
			
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
			
			try
			{
				validateField(year);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_YEAR);
				validYear = false;
			}
			
			//
			
			try
			{
				validateField(term);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_TERM);
				validTerm = false;
			}
			
			//
			
			try
			{
				validateField(day);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_DAYS);
				validDays = false;
			}
			
			//
			
			try
			{
				validateField(startTime);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_START_TIME);
				validStartTime = false;
			}
			
			//
			
			try
			{
				validateField(endTime);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidEditSectionStrings.NULL_END_TIME);
				validEndTime = false;
			}
			
			if(validSectionName && validSectionId && validSectionType && validPopulation && validYear && validTerm && validDays && validStartTime && validEndTime)
			{
				sendEditSection(sectionName, sectionId, sectionType, population, year, term, day, startTime, endTime);
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
	
	private void sendEditSection(String sectionName, String sectionId, String sectionType, String population, String year, String term, String days, String startTime,
			String endTime)
	{
		SendEditSectionAction sesa = new SendEditSectionAction(sectionName, sectionId, sectionType, population, year, term, days, startTime, endTime);
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
