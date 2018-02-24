package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidCreateCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidCreateInstructorAction;
import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.action.ReceiveClickScheduleTabAction;
import org.dselent.course_load_scheduler.client.action.ReceiveEditSectionAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveValidateAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendSelectCourseAction;
import org.dselent.course_load_scheduler.client.action.SendSelectInstructorAction;
import org.dselent.course_load_scheduler.client.action.SendValidateAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditCourseStrings;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditInstructorStrings;
import org.dselent.course_load_scheduler.client.errorstring.InvalidEditSectionStrings;
import org.dselent.course_load_scheduler.client.event.SendEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidCreateCourseEvent;
import org.dselent.course_load_scheduler.client.event.InvalidCreateInstructorEvent;
import org.dselent.course_load_scheduler.client.event.InvalidEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveClickScheduleTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSelectInstructorEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveValidateEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendSelectCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendSelectInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendValidateEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.CourseSection;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class SchedulePresenterImpl extends BasePresenterImpl implements SchedulePresenter {
	
	private IndexPresenter parentPresenter;
	private ScheduleView view;
	private GlobalData globalData;
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
	
	List<Instructor> instructorList = new ArrayList<Instructor>();
	List<Course> courseList = new ArrayList<Course>();
	List<CourseSection> courseSectionList = new ArrayList<CourseSection>();
	List<CalendarInfo> calendarInfoList = new ArrayList<CalendarInfo>();
	
	@Inject
	public SchedulePresenterImpl(IndexPresenter parentPresenter, ScheduleView view, GlobalData globalData)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		this.globalData = globalData;
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
		
		/* 
		 * These are placeholders for testing and will need to be passed from the server to the
		 * populateInstructorList and populateCourseList functions when loading up this view */
		/*
		--- DEAD CODE ---
		Instructor placeholderInstructor = new Instructor();
		Course placeholderCourse = new Course();
		
		placeholderInstructor.setId(0);
		placeholderInstructor.setFirstName("Place");
		placeholderInstructor.setLastName("Holder");
		placeholderInstructor.setRank("Holder of Places");
		placeholderInstructor.setEmail("place@holder.com");
		placeholderInstructor.setDeleted(false);
		
		placeholderCourse.setId(0);
		placeholderCourse.setCourseName("Placeholder");
		placeholderCourse.setCourseNumber("PH1000");
		placeholderCourse.setFrequency("place/holder");
		placeholderCourse.setDeleted(false);
		
		List<Instructor> placeholderInstList = new ArrayList<Instructor>();
		placeholderInstList.add(placeholderInstructor);
		List<Course> placeholderCourseList = new ArrayList<Course>();
		placeholderCourseList.add(placeholderCourse);
		
		populateInstructorList(placeholderInstList);
		populateCourseList(placeholderCourseList);*/
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
		
		registration = eventBus.addHandler(ReceiveLoginEvent.TYPE, this);
		eventBusRegistration.put(ReceiveLoginEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveSelectInstructorEvent.TYPE, this);
		eventBusRegistration.put(ReceiveSelectInstructorEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveSelectCourseEvent.TYPE, this);
		eventBusRegistration.put(ReceiveSelectCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveEditInstructorEvent.TYPE, this);
		eventBusRegistration.put(ReceiveEditInstructorEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveClickScheduleTabEvent.TYPE, this);
		eventBusRegistration.put(ReceiveClickScheduleTabEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveEditCourseEvent.TYPE, this);
		eventBusRegistration.put(ReceiveEditCourseEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveEditSectionEvent.TYPE, this);
		eventBusRegistration.put(ReceiveEditSectionEvent.TYPE, registration);
	}

	@Override
	public void go(HasWidgets container) {
		// one handler will populate data into models for this view
		// and then will call go (this function)
		// go will use that data to determine the visibility
		// in views with potentially hidden fields, create .defaul css styling
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
	
	
	/* Helper methods to fill out the instructor and course lists and to fill out their associated pop-ups when editing */
	
	public void populateInstructorList(List<Instructor> iList) {
		instructorList = iList;
		view.getInstructorBox().clear();
		for(Instructor i : instructorList) {
			view.getInstructorBox().addItem(i.displayText());
		}
	}
	
	public void populateCourseList(List<Course> cList) {
		courseList = cList;
		view.getCourseBox().clear();
		for(Course c : courseList) {
			view.getCourseBox().addItem(c.displayText());
		}
	}
	
	@Override
	public void fillInstructorFields() {
		int selectedInstructor = view.getInstructorBox().getSelectedIndex();
		Instructor selected = instructorList.get(selectedInstructor);
		view.getPopInstructorTextFirstName().setText(selected.getFirstName());
		view.getPopInstructorTextLastName().setText(selected.getLastName());
		view.getPopInstructorTextRank().setText(selected.getRank());
		view.getPopInstructorTextEmail().setText(selected.getEmail());
	}

	@Override
	public void fillCourseFields() {
		int selectedCourse = view.getCourseBox().getSelectedIndex();
		Course selected = courseList.get(selectedCourse);
		view.getPopCourseTextName().setText(selected.getCourseName());
		view.getPopCourseTextNumber().setText(selected.getCourseNumber());
		view.getPopCourseTextFrequency().setText(selected.getFrequency());
		
	}
	
	@Override
	public void fillCourseSectionFields() {
		Button selectedCourseSection = view.getSelectedCourseSection();
		for(int i = 0; i < courseSectionList.size(); i++) {
			if(courseSectionList.get(i).displayText().equals(selectedCourseSection.getText())) {
				view.getSectionNameText().setText(courseSectionList.get(i).getSectionName());
				view.getSectionIdText().setText(courseSectionList.get(i).getSectionId().toString());
				
				int index;
				if(courseSectionList.get(i).getSectionType() == "LECTURE") {
					index = 0;
				}
				else if(courseSectionList.get(i).getSectionType() == "LAB") {
					index = 1;
				}
				else if(courseSectionList.get(i).getSectionType() == "CONFERENCE") {
					index = 2;
				}
				else {
					index = -1;
				}
				view.getSectionTypeListBox().setItemSelected(index, true);
				view.getPopulationText().setText(courseSectionList.get(i).getPopulation().toString());
				
				for(int j = 0; j < calendarInfoList.size(); j++) {
					if(courseSectionList.get(i).getCalendarInfoId() == calendarInfoList.get(j).getId()) {
						view.getYearText().setText(calendarInfoList.get(j).getCalYear().toString());
						view.getTermText().setText(calendarInfoList.get(j).getCalTerm());
						
						if(calendarInfoList.get(j).getDays().contains("M")) {
							view.getMonday().setValue(true);
						}
						else {
							view.getMonday().setValue(false);
						}
						if(calendarInfoList.get(j).getDays().contains("T")) {
							view.getTuesday().setValue(true);
						}
						else {
							view.getTuesday().setValue(false);
						}
						if(calendarInfoList.get(j).getDays().contains("W")) {
							view.getWednesday().setValue(true);
						}
						else {
							view.getWednesday().setValue(false);
						}
						if(calendarInfoList.get(j).getDays().contains("R")) {
							view.getThursday().setValue(true);
						}
						else {
							view.getThursday().setValue(false);
						}
						if(calendarInfoList.get(j).getDays().contains("F")) {
							view.getFriday().setValue(true);
						}
						else {
							view.getFriday().setValue(false);
						}
						
						view.getStartTimeText().setText(calendarInfoList.get(j).getStartTime().toString());
						view.getEndTimeText().setText(calendarInfoList.get(j).getEndTime().toString());						
						
						break;
					}
				}
				break;
			}
		}		
	}
	
	

	/* Primary methods for courses and instructors */
	
	/**
	 * This is a method for editing an instructor, called from the view class after the submit button is pressed
	 * @param creating whether a new instructor is being created or an existing one edited
	 * @param deleting whether the instructor should be deleted
	 * @author Leif Sahyun
	 */
	@Override
	public void editInstructor(boolean creating, boolean deleting) {
		if (!submitEditInstructorClickInProgress)
		{
			submitEditInstructorClickInProgress = true;
			parentPresenter.showLoadScreen();
			String firstName = view.getPopInstructorTextFirstName().getText();
			String lastName = view.getPopInstructorTextLastName().getText();
			String rank = view.getPopInstructorTextRank().getText();
			String email = view.getPopInstructorTextEmail().getText();
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
				view.getInstructorCreateButton().setEnabled(false);
				view.getInstructorSubmitButton().setEnabled(false);
				view.getInstructorDeleteButton().setEnabled(false);
				if(creating) {
					sendInstructorEdit(null, firstName, lastName, rank, email, false);
					
				} else {
					sendInstructorEdit(instructorList.get(view.getInstructorBox().getSelectedIndex()).getId(), firstName, lastName, rank, email, deleting);
					
				}
				
			}
			else
			{
				InvalidCreateInstructorAction iica = new InvalidCreateInstructorAction(invalidReasonList);
				InvalidCreateInstructorEvent iice = new InvalidCreateInstructorEvent(iica);
				eventBus.fireEvent(iice);
			}

			
		}
		
	}
	
	/* The following methods are for sending and listening for events related to instructors
	 * such as SendEditInstructor, ReceiveEditInstructor, ReceiveSelectInstructor, and InvalidCreateInstructor */
	
	private void sendInstructorEdit(Integer id, String firstName, String lastName, String rank, String email, boolean deleted)
	{
		String idString = null;
		if(id!=null)
			idString = id.toString();
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendEditInstructorAction siea = new SendEditInstructorAction(idString, firstName, lastName, rank, email, Boolean.toString(deleted));
		SendEditInstructorEvent siee = new SendEditInstructorEvent(siea, container);
		submitEditInstructorClickInProgress = false;
		eventBus.fireEvent(siee);
	}
	
	@Override
	public void onReceiveEditInstructor(ReceiveEditInstructorEvent evt)
	{
		Instructor editedInstructor = evt.getAction().getModel();
		int match = -1;
		for(int i=0; i<instructorList.size(); i++)
		{
			if(instructorList.get(i).getId()==editedInstructor.getId())
				match = i;
		}
		if(match<0) {
			String instFullName = editedInstructor.displayText();
			int begin = 0;
			int end = instructorList.size();
			while(begin<end) {
				if(instFullName.compareToIgnoreCase(instructorList.get((begin+end)/2).displayText())<0) {
					end = (begin+end)/2;
				} else {
					begin = (begin+end)/2+1;
				}		
			}
			if(end>=instructorList.size())
				instructorList.add(editedInstructor);
			else
				instructorList.add(end, editedInstructor);
			view.getInstructorBox().insertItem(editedInstructor.displayText(), end);
		} else {
			if(editedInstructor.getDeleted()) {
				instructorList.remove(match);
				view.getInstructorBox().removeItem(match);
			} else {
				instructorList.set(match, editedInstructor);
				view.getInstructorBox().setItemText(match, editedInstructor.displayText());
			}
		}
		parentPresenter.hideLoadScreen();
	}
	
	@Override
	public void selectInstructor() {
		view.getEditInstructorButton().setEnabled(true);

		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendSelectInstructorAction ssia = new SendSelectInstructorAction(instructorList.get(view.getInstructorBox().getSelectedIndex()).getId(), view.getTermSelect().getItemText(view.getTermSelect().getSelectedIndex()), Integer.parseInt(view.getYearSelect().getItemText(view.getYearSelect().getSelectedIndex())));
		SendSelectInstructorEvent ssie = new SendSelectInstructorEvent(ssia, container);
		eventBus.fireEvent(ssie);
	}
	
	@Override
	public void onReceiveSelectInstructor(ReceiveSelectInstructorEvent evt) {
		/* TODO
		 * Insert code here for what to do when an instructor is selected
		 * display their course sections, etc.
		 */
		evt.getAction().getSectionList();
	}
	
	@Override
	public void onInvalidCreateInstructor(InvalidCreateInstructorEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getInstructorSubmitButton().setEnabled(true);
		submitEditInstructorClickInProgress = false;
		
		InvalidCreateInstructorAction icia = evt.getAction();
		view.showErrorMessages(icia.toString());
	}

	/**
	 * This is a method for editing an course, called from the view class after the submit button is pressed
	 * @param creating whether a new instructor is being created or an existing one edited
	 * @param deleting whether the instructor should be deleted
	 * @author Leif Sahyun
	 */
	@Override
	public void editCourse(boolean creating, boolean deleting) {
		if (!submitEditCourseClickInProgress)
		{
			submitEditCourseClickInProgress = true;
			parentPresenter.showLoadScreen();
			String courseName = view.getPopCourseTextName().getText();
			String courseNumber = view.getPopCourseTextNumber().getText();
			String frequency = view.getPopCourseTextFrequency().getText();
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
				view.getCourseCreateButton().setEnabled(false);
				view.getCourseSubmitButton().setEnabled(false);
				view.getCourseDeleteButton().setEnabled(false);
				if(creating) {
					sendCourseEdit(null, courseName, courseNumber, frequency, false);
					
				} else {
					sendCourseEdit(courseList.get(view.getCourseBox().getSelectedIndex()).getId(), courseName, courseNumber, frequency, deleting);
					
				}
			}
			else
			{
				InvalidCreateCourseAction icca = new InvalidCreateCourseAction(invalidReasonList);
				InvalidCreateCourseEvent icce = new InvalidCreateCourseEvent(icca);
				eventBus.fireEvent(icce);
			}
			
		}
		
	}
	
	/* The following methods are for sending and listening for events related to courses
	 * such as SendEditCourse, ReceiveEditCourse, ReceiveSelectCourse, and InvalidCreateCourse */

	private void sendCourseEdit(Integer id, String courseName, String courseNumber, String frequency, boolean deleted) {
		String idString = null;
		if(id!=null)
			idString = id.toString();
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendEditCourseAction scea = new SendEditCourseAction(idString, courseName, courseNumber, frequency, Boolean.toString(deleted));
		SendEditCourseEvent scee = new SendEditCourseEvent(scea, container);
		submitEditCourseClickInProgress = false;
		eventBus.fireEvent(scee);	
	}
	
	@Override
	public void onReceiveEditCourse(ReceiveEditCourseEvent evt)
	{
		Course editedCourse = evt.getAction().getModel();
		int match = -1;
		for(int i=0; i<courseList.size(); i++)
		{
			if(courseList.get(i).getId()==editedCourse.getId())
				match = i;
		}
		if(match<0) {
			String displayText = editedCourse.displayText();
			int begin = 0;
			int end = courseList.size();
			while(begin<end) {
				if(displayText.compareToIgnoreCase(courseList.get((begin+end)/2).displayText())<0) {
					end = (begin+end)/2;
				} else {
					begin = (begin+end)/2+1;
				}		
			}
			if(end>=courseList.size())
				courseList.add(editedCourse);
			else
				courseList.add(end, editedCourse);
			view.getInstructorBox().insertItem(editedCourse.displayText(), end);
		} else {
			if(editedCourse.getDeleted()) {
				courseList.remove(match);
				view.getInstructorBox().removeItem(match);
			} else {
				courseList.set(match, editedCourse);
				view.getInstructorBox().setItemText(match, editedCourse.displayText());
			}
		}
		parentPresenter.hideLoadScreen();
	}
	
	@Override
	public void selectCourse() {
		view.getEditCourseButton().setEnabled(true);

		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendSelectCourseAction ssca = new SendSelectCourseAction(courseList.get(view.getCourseBox().getSelectedIndex()).getId(), view.getTermSelect().getItemText(view.getTermSelect().getSelectedIndex()), Integer.parseInt(view.getYearSelect().getItemText(view.getYearSelect().getSelectedIndex())));
		SendSelectCourseEvent ssce = new SendSelectCourseEvent(ssca, container);
		eventBus.fireEvent(ssce);
	}
	
	@Override
	public void onReceiveSelectCourse(ReceiveSelectCourseEvent evt) {
		/* TODO
		 * Insert code here for what to do when an course is selected
		 * display its course sections, etc.
		 */
	}
	
	@Override
	public void onInvalidCreateCourse(InvalidCreateCourseEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getCourseSubmitButton().setEnabled(true);
		submitEditCourseClickInProgress = false;
		
		InvalidCreateCourseAction icca = evt.getAction();
		view.showErrorMessages(icca.toString());
	}
	
	/* Methods below are for course sections and validation */


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
			String sectionType = view.getSectionTypeListBox().getItemText(view.getSectionTypeListBox().getSelectedIndex());
			String population = view.getPopulationText().getText();
			String year = view.getYearText().getText();
			String term = view.getTermText().getText();
			
			String days = "";
			if(view.getMonday().getValue() == true) {
				days += "M";
			}
			if(view.getTuesday().getValue() == true) {
				days += "T";
			}
			if(view.getWednesday().getValue() == true) {
				days += "W";
			}
			if(view.getThursday().getValue() == true) {
				days += "R";
			}
			if(view.getFriday().getValue() == true) {
				days += "F";
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
				validateField(days);
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
				sendEditSection(sectionName, sectionId, sectionType, population, year, term, days, startTime, endTime);
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
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendEditSectionAction sesa = new SendEditSectionAction(sectionName, sectionId, sectionType, population, year, term, days, startTime, endTime);
		SendEditSectionEvent sese = new SendEditSectionEvent(sesa,container);
		eventBus.fireEvent(sese);
	}
	
	private void createCourseSection(CourseSection courseSection, CalendarInfo calendarInfo) {
	
		String calInfoDays = calendarInfo.getDays();
		Integer calInfoStartTime = calendarInfo.getStartTime();
		Integer calInfoEndTime = calendarInfo.getEndTime();
				
		List<Integer> columnList = new ArrayList<Integer>();
				
		if(calInfoDays.contains("M")) {
			columnList.add(1);
		}
		if(calInfoDays.contains("T")) {
			columnList.add(2);
		}
		if(calInfoDays.contains("W")) {
			columnList.add(3);
		}
		if(calInfoDays.contains("R")) {
			columnList.add(4);
		}
		if(calInfoDays.contains("F")) {
			columnList.add(5);
		}
				
		Integer startTimeIndex = (int)Math.ceil(calInfoStartTime/50.0) - 15;
		Integer endTimeIndex = (int)Math.ceil(calInfoEndTime/50.0) - 15;
				
		for(; startTimeIndex < endTimeIndex; startTimeIndex++) {
			for(Integer n: columnList) {
				view.addToCalendar(startTimeIndex, n, courseSection.displayText());
						
			}
		}		
	}
	
	@Override
	public void onReceiveEditSection(ReceiveEditSectionEvent evt)
	{
		ReceiveEditSectionAction action = evt.getAction();
		
		CourseSection courseSection = action.getCourseSection();
		CalendarInfo calendarInfo = action.getCalendarInfo();
		
		boolean found = false;
		
		for(int i = 0; i < courseSectionList.size(); i++) {
		
			if(courseSection.getId() == courseSectionList.get(i).getId()) {
				// something
				found = true;
				Integer calInfoId = courseSectionList.get(i).getCalendarInfoId();
				for(int j = 0; j < calendarInfoList.size(); j++) {
					if(calendarInfoList.get(j).getId() == calInfoId) {
						
						String calInfoDays = calendarInfoList.get(j).getDays();
						Integer calInfoStartTime = calendarInfoList.get(j).getStartTime();
						Integer calInfoEndTime = calendarInfoList.get(j).getEndTime();
						
						List<Integer> columnList = new ArrayList<Integer>();
						
						if(calInfoDays.contains("M")) {
							columnList.add(1);
						}
						if(calInfoDays.contains("T")) {
							columnList.add(2);
						}
						if(calInfoDays.contains("W")) {
							columnList.add(3);
						}
						if(calInfoDays.contains("R")) {
							columnList.add(4);
						}
						if(calInfoDays.contains("F")) {
							columnList.add(5);
						}
						
						Integer startTimeIndex = (int)Math.ceil(calInfoStartTime/50.0) - 15;
						Integer endTimeIndex = (int)Math.ceil(calInfoEndTime/50.0) - 15;
						
						for(; startTimeIndex < endTimeIndex; startTimeIndex++) {
							for(Integer n: columnList) {
								view.removeFromCalendar(startTimeIndex, n);
								
							}
						}
						calendarInfoList.set(j, calendarInfo);
						break;
					}
				}
				courseSectionList.set(i, courseSection);
				break;
			}
			
		}
		
		if(found) {
			courseSectionList.add(courseSection);
			calendarInfoList.add(calendarInfo);
		}
		
		createCourseSection(courseSection, calendarInfo);
		
//----------------------------------------------------------------------------------------------------------------------------------------------------
		
		parentPresenter.hideLoadScreen();
		
		String message = action.getMessage();
		view.showErrorMessages(message);
		
		
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
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendValidateAction sva = new SendValidateAction();
		SendValidateEvent sve = new SendValidateEvent(sva, container);
		eventBus.fireEvent(sve);
	}
	
	@Override
	public void onReceiveValidate(ReceiveValidateEvent evt) {
		
		ReceiveValidateAction action = evt.getAction();
		populateInstructorList(action.getInstructorList());
		populateCourseList(action.getCourseList());
		
		parentPresenter.hideLoadScreen();
		view.getValidateButton().setEnabled(true);
		validateClickInProgress = false;
		
		String message = action.getMessage();
		view.showErrorMessages(message);
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
	
	/*
	 * For this method, it would be better to implement the global data setting as part of the onReceiveLogin in the mainPresenter
	 * and implement the other parts of this method - which should happen not only on login, but any time the tab is visited - below in the onReceiveClickScheduleTab
	 * */
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt)
	{
		ReceiveLoginAction action = evt.getAction();
		globalData.setLinkedInstructorId(action.getLinkedInstructorId());
		globalData.setRole(action.getUserRole());
		globalData.setUserId(action.getUserId());
		
		populateInstructorList(action.getInstructorList());
		populateCourseList(action.getCourseList());
		// need to populate course load list with this action
		
		// default selected instructor to linked instructor if possible
		int linkedInstructorId = action.getLinkedInstructorId();
		if (linkedInstructorId != -1)
		{
			for (int i = 0; i < instructorList.size(); i++)
			{
				if (instructorList.get(i).getId() == linkedInstructorId)
				{
					view.getInstructorBox().setSelectedIndex(i);
					selectInstructor(); //Added this line because this method is usually called when the user clicks on an instructor and we still want it here
					break;
				}
			}
		}
	}
	
	@Override
	public void onReceiveClickScheduleTab(ReceiveClickScheduleTabEvent evt)
	{
		ReceiveClickScheduleTabAction action = evt.getAction();
		populateInstructorList(action.getInstructorList());
		populateCourseList(action.getCourseList());
		// need to populate course load list with this action
		
		// default selected instructor to linked instructor if possible
		int linkedInstructorId = action.getLinkedInstructorId();
		if (linkedInstructorId != -1)
		{
			for (int i = 0; i < instructorList.size(); i++)
			{
				if (instructorList.get(i).getId() == linkedInstructorId)
				{
					view.getInstructorBox().setSelectedIndex(i);
					selectInstructor(); //Added this line because this method is usually called when the user clicks on an instructor and we still want it here
					break;
				}
			}
		}
	}
	
}
