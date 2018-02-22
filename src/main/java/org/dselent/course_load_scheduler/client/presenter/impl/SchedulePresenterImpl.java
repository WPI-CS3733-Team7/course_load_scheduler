package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidCreateCourseAction;
import org.dselent.course_load_scheduler.client.action.InvalidCreateInstructorAction;
import org.dselent.course_load_scheduler.client.action.InvalidEditSectionAction;
import org.dselent.course_load_scheduler.client.action.SendEditCourseAction;
import org.dselent.course_load_scheduler.client.action.SendEditInstructorAction;
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
import org.dselent.course_load_scheduler.client.event.ReceiveEditCourseEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveEditInstructorEvent;
import org.dselent.course_load_scheduler.client.event.SendEditSectionEvent;
import org.dselent.course_load_scheduler.client.event.SendValidateEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleView;
import com.google.gwt.event.shared.HandlerRegistration;
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
	int selectedInstructor = -1;
	int selectedCourse = -1;
	
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
		
		/* These are placeholders for testing and will need to be passed from the server to the
		 * populateInstructorList and populateCourseList functions when loading up this view */
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
		populateCourseList(placeholderCourseList);
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
		// one handler will populate data into models for this view
		// and then will call go (this function)
		// go will use that data to determine the visibility
		// in views with potentially hidden fields, create .defaul css styling
		container.clear();
		container.add(view.getWidgetContainer());		
	}
	
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
					sendInstructorEdit(instructorList.get(selectedInstructor).getId(), firstName, lastName, rank, email, deleting);
					
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
	public void onInvalidCreateInstructor(InvalidCreateInstructorEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getInstructorSubmitButton().setEnabled(true);
		submitEditInstructorClickInProgress = false;
		
		InvalidCreateInstructorAction icia = evt.getAction();
		view.showErrorMessages(icia.toString());
	}
	
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
					sendCourseEdit(courseList.get(selectedCourse).getId(), courseName, courseNumber, frequency, deleting);
					
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
	public void onInvalidCreateCourse(InvalidCreateCourseEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getCourseSubmitButton().setEnabled(true);
		submitEditCourseClickInProgress = false;
		
		InvalidCreateCourseAction icca = evt.getAction();
		view.showErrorMessages(icca.toString());
	}
	
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
			
			String day = "";
			if(view.getMonday().getValue() == true) {
				day = "Monday";
			}
			else if(view.getTuesday().getValue() == true) {
				day = "Tuesday";
			}
			else if(view.getWednesday().getValue() == true) {
				day = "Wednesday";
			}
			else if(view.getThursday().getValue() == true) {
				day = "Thursday";
			}
			else if(view.getFriday().getValue() == true) {
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
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendEditSectionAction sesa = new SendEditSectionAction(sectionName, sectionId, sectionType, population, year, term, days, startTime, endTime);
		SendEditSectionEvent sese = new SendEditSectionEvent(sesa,container);
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
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendValidateAction sva = new SendValidateAction();
		SendValidateEvent sve = new SendValidateEvent(sva, container);
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

	@Override
	public void fillInstructorFields() {
		selectedInstructor = view.getInstructorBox().getSelectedIndex();
		Instructor selected = instructorList.get(selectedInstructor);
		view.getPopInstructorTextFirstName().setText(selected.getFirstName());
		view.getPopInstructorTextLastName().setText(selected.getLastName());
		view.getPopInstructorTextRank().setText(selected.getRank());
		view.getPopInstructorTextEmail().setText(selected.getEmail());
	}

	@Override
	public void fillCourseFields() {
		selectedCourse = view.getCourseBox().getSelectedIndex();
		Course selected = courseList.get(selectedCourse);
		view.getPopCourseTextName().setText(selected.getCourseName());
		view.getPopCourseTextNumber().setText(selected.getCourseNumber());
		view.getPopCourseTextFrequency().setText(selected.getFrequency());
		
	}
}
