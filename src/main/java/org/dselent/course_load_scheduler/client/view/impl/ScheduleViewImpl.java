package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;

public class ScheduleViewImpl extends BaseViewImpl<SchedulePresenter> implements ScheduleView {

	private static ScheduleViewImplUiBinder uiBinder = GWT.create(ScheduleViewImplUiBinder.class);
		
	interface ScheduleViewImplUiBinder extends UiBinder<Widget, ScheduleViewImpl>{}

	SchedulePresenter presenter;
	
	/* Removed lists of ModelButtons now that we are using listboxes
	List<ModelButton<Instructor>> instructorButtons = new ArrayList<ModelButton<Instructor>>();
	List<ModelButton<Course>> courseButtons = new ArrayList<ModelButton<Course>>();
		
	ModelButton<Instructor> selectedInstructorButton = null;
	ModelButton<Course> selectedCourseButton = null;
	*/	
	
	@UiField VerticalPanel scheduleInstructorsPanel;		
	@UiField VerticalPanel scheduleCoursesPanel;
	@UiField Button scheduleAddInstructor;
	@UiField Button scheduleEditInstructor;
	@UiField Button scheduleAddCourse;
	@UiField Button scheduleEditCourse;
	@UiField Button createSection;
	@UiField Button editSection;
	@UiField Button validate;
	@UiField ListBox yearSelect;
	@UiField ListBox termSelect;
	@UiField HorizontalPanel scheduleViewPanel;
	@UiField ListBox instructorBox;
	@UiField ListBox courseBox;
	@UiField Grid calendar;
		
		boolean isCreating;
		
		Button selectedCourseSection;

		/* Pop-up Widgets for Instructor */
		Label popInstructorLabelFirstName = new Label("First Name:");
		Label popInstructorLabelLastName = new Label("Last Name:");
		Label popInstructorLabelRank = new Label("Rank:");
		Label popInstructorLabelEmail = new Label("Email:");
		TextBox popInstructorTextFirstName = new TextBox();
		TextBox popInstructorTextLastName = new TextBox();
		TextBox popInstructorTextRank = new TextBox();
		TextBox popInstructorTextEmail = new TextBox();
		Button popInstructorButtonDelete = new Button("Delete", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editInstructor(false, true);
			}
		});
		Button popInstructorButtonSubmit = new Button("Submit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editInstructor(false, false);
				//isCreating=false;
			}
		});
		Button popInstructorButtonCreate = new Button("Submit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editInstructor(true, false);
				//isCreating=false;
			}
		});

		/* Pop-up Widgets for Course */
		Label popCourseLabelName = new Label("Course Name:");
		Label popCourseLabelNumber = new Label("Course Number:");
		Label popCourseLabelFrequency = new Label("Required Frequency:");
		TextBox popCourseTextName = new TextBox();
		TextBox popCourseTextNumber = new TextBox();
		TextBox popCourseTextFrequency = new TextBox();
		Button popCourseButtonDelete = new Button("Delete", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editCourse(false, true);
			}
		});
		Button popCourseButtonSubmit = new Button("Submit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editCourse(false, false);
				
			}
		});
		Button popCourseButtonCreate = new Button("Submit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editCourse(true, false);
				
			}
		});
		
		/* Pop-up Widgets for Course Sections */
		Label sectionLabel = new Label("Create/Edit a Section");
		Label sectionNameLabel = new Label("Section Name");
		Label sectionIdLabel = new Label("Section ID (CRN)");
		Label sectionTypeLabel = new Label("Section Type");
		Label populationLabel = new Label("Population");
		Label yearLabel = new Label("Year");
		Label termLabel = new Label("Term");
		Label daysLabel = new Label("Days of the Week");
		Label mondayLabel = new Label("M");
		Label tuesdayLabel = new Label("T");
		Label wednesdayLabel = new Label("W");
		Label thursdayLabel = new Label("R");
		Label fridayLabel = new Label("F");
		Label startTimeLabel = new Label("Start Time");
		Label endTimeLabel = new Label("End Time");
		TextBox sectionNameText = new TextBox();
		TextBox sectionIdText = new TextBox();
		ListBox sectionTypeListBox = new ListBox();
		TextBox populationText = new TextBox();
		TextBox yearText = new TextBox();
		TextBox termText = new TextBox();
		CheckBox monday = new CheckBox();
		CheckBox tuesday = new CheckBox();
		CheckBox wednesday = new CheckBox();
		CheckBox thursday = new CheckBox();
		CheckBox friday = new CheckBox();
		TextBox startTimeText = new TextBox();
		TextBox endTimeText = new TextBox();
		Button sectionSubmitButton = new Button("Submit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editSection();
			}
		});

		/* Constructor */
		public ScheduleViewImpl() {
			initWidget(uiBinder.createAndBindUi(this));
			
			yearSelect.addItem("2018");
			yearSelect.addItem("2017");
			yearSelect.addItem("2016");
			yearSelect.addItem("2015");
			yearSelect.addItem("2014");
			yearSelect.addItem("2013");
			yearSelect.addItem("2012");
			yearSelect.addItem("2011");
			yearSelect.addItem("2010");			
			
			termSelect.addItem("A");
			termSelect.addItem("B");
			termSelect.addItem("C");
			termSelect.addItem("D");
			termSelect.addItem("E1");
			termSelect.addItem("E2");
			
			sectionTypeListBox.addItem("LECTURE");
			sectionTypeListBox.addItem("LAB");
			sectionTypeListBox.addItem("CONFERENCE");
		}
		
		/* Methods to generate pop-up windows */

		private void makeInstructorPopUp(boolean creating) {
			Grid popGrid = new Grid(5, 2);
			popGrid.setWidget(0, 0, popInstructorLabelFirstName);
			popGrid.setWidget(1, 0, popInstructorLabelLastName);
			popGrid.setWidget(2, 0, popInstructorLabelRank);
			popGrid.setWidget(3, 0, popInstructorLabelEmail);
			popGrid.setWidget(0, 1, popInstructorTextFirstName);
			popGrid.setWidget(1, 1, popInstructorTextLastName);
			popGrid.setWidget(2, 1, popInstructorTextRank);
			popGrid.setWidget(3, 1, popInstructorTextEmail);
			
			if(!creating) {
				popGrid.setWidget(4, 1, popInstructorButtonSubmit);
				popGrid.setWidget(4, 0, popInstructorButtonDelete);
				presenter.fillInstructorFields();
			} else {
				popGrid.setWidget(4, 1, popInstructorButtonCreate);
				popInstructorTextFirstName.setText("");
				popInstructorTextLastName.setText("");
				popInstructorTextRank.setText("");
				popInstructorTextEmail.setText("");
			}
			PopupPanel editPopup = new PopupPanel(true);
			editPopup.add(popGrid);
			editPopup.isGlassEnabled();
			editPopup.center();
		}
		
		private void makeCoursePopUp(boolean creating) {
			Grid popGrid = new Grid(4, 2);
			popGrid.setWidget(0, 0, popCourseLabelName);
			popGrid.setWidget(1, 0, popCourseLabelNumber);
			popGrid.setWidget(2, 0, popCourseLabelFrequency);
			popGrid.setWidget(0, 1, popCourseTextName);
			popGrid.setWidget(1, 1, popCourseTextNumber);
			popGrid.setWidget(2, 1, popCourseTextFrequency);
			
			if(!creating) {
				popGrid.setWidget(3, 1, popCourseButtonSubmit);
				popGrid.setWidget(3, 0, popCourseButtonDelete);
				presenter.fillCourseFields();
			} else {
				popGrid.setWidget(3, 1, popCourseButtonCreate);
				popCourseTextName.setText("");
				popCourseTextNumber.setText("");
				popCourseTextFrequency.setText("");
			}
			
			PopupPanel editPopup = new PopupPanel(true);
			editPopup.add(popGrid);
			editPopup.isGlassEnabled();
			editPopup.center();
		}
		
		//Creates the grid for the section name, section id, section type, population, year, term
		
		private Grid makeFirstGrid() {
			Grid firstGrid = new Grid(6, 2);
			firstGrid.setWidget(0, 0, sectionNameLabel);
			firstGrid.setWidget(0, 1, sectionNameText);
			firstGrid.setWidget(1, 0, sectionIdLabel);
			firstGrid.setWidget(1, 1, sectionIdText);
			firstGrid.setWidget(2, 0, sectionTypeLabel);
			firstGrid.setWidget(2, 1, sectionTypeListBox);
			firstGrid.setWidget(3, 0, populationLabel);
			firstGrid.setWidget(3, 1, populationText);
			firstGrid.setWidget(4, 0, yearLabel);
			firstGrid.setWidget(4, 1, yearText);
			firstGrid.setWidget(5, 0, termLabel);
			firstGrid.setWidget(5, 1, termText);
			
			return firstGrid;
			
		}
		
		//Creates the grid for the days of the week check boxes in the Course Section pop-up
		
		private Grid makeCalendarInfoGrid() {
			Grid calendarInfoGrid = new Grid(1, 10);
			calendarInfoGrid.setWidget(0, 0, monday);
			calendarInfoGrid.setWidget(0, 1, mondayLabel);
			calendarInfoGrid.setWidget(0, 2, tuesday);
			calendarInfoGrid.setWidget(0, 3, tuesdayLabel);
			calendarInfoGrid.setWidget(0, 4, wednesday);
			calendarInfoGrid.setWidget(0, 5, wednesdayLabel);
			calendarInfoGrid.setWidget(0, 6, thursday);
			calendarInfoGrid.setWidget(0, 7, thursdayLabel);
			calendarInfoGrid.setWidget(0, 8, friday);
			calendarInfoGrid.setWidget(0, 9, fridayLabel);
			
			return calendarInfoGrid;
			
		}
		
		// Creates the grid for start time, end time
		
		private Grid makeLastGrid() {
			Grid lastGrid = new Grid(2, 2);
			lastGrid.setWidget(0, 0, startTimeLabel);
			lastGrid.setWidget(0, 1, startTimeText);
			lastGrid.setWidget(1, 0, endTimeLabel);
			lastGrid.setWidget(1, 1, endTimeText);
			
			return lastGrid;
			
		}
		
		//Combines all 3 grids into one pop-up
		
		private void makeSectionPopUp() {
		Grid sectionGrid = new Grid(4, 1);		
		sectionGrid.setWidget(0, 0, makeFirstGrid());
		sectionGrid.setWidget(1, 0, daysLabel);
		sectionGrid.setWidget(2, 0, makeCalendarInfoGrid());
		sectionGrid.setWidget(3, 0, makeLastGrid());
		
		VerticalPanel vertPanel = new VerticalPanel();
		vertPanel.add(sectionLabel);
		vertPanel.add(sectionGrid);
		vertPanel.add(sectionSubmitButton);
		
		PopupPanel sectionPopup = new PopupPanel(true);
		sectionPopup.add(vertPanel);
		sectionPopup.isGlassEnabled();
		sectionPopup.center();
	}
		
	/* Getters and Setters for pop-up text boxes */
		
	public TextBox getPopInstructorTextFirstName() {
		return popInstructorTextFirstName;
	}

		public void setPopInstructorTextFirstName(TextBox popInstructorTextFirstName) {
			this.popInstructorTextFirstName = popInstructorTextFirstName;
		}

		public TextBox getPopInstructorTextLastName() {
			return popInstructorTextLastName;
		}

		public void setPopInstructorTextLastName(TextBox popInstructorTextLastName) {
			this.popInstructorTextLastName = popInstructorTextLastName;
		}

		public TextBox getPopInstructorTextRank() {
			return popInstructorTextRank;
		}

		public void setPopInstructorTextRank(TextBox popInstructorTextRank) {
			this.popInstructorTextRank = popInstructorTextRank;
		}

		public TextBox getPopInstructorTextEmail() {
			return popInstructorTextEmail;
		}

		public void setPopInstructorTextEmail(TextBox popInstructorTextEmail) {
			this.popInstructorTextEmail = popInstructorTextEmail;
		}

		public TextBox getPopCourseTextName() {
			return popCourseTextName;
		}

		public void setPopCourseTextName(TextBox popCourseTextName) {
			this.popCourseTextName = popCourseTextName;
		}

		public TextBox getPopCourseTextNumber() {
			return popCourseTextNumber;
		}

		public void setPopCourseTextNumber(TextBox popCourseTextNumber) {
			this.popCourseTextNumber = popCourseTextNumber;
		}

		public TextBox getPopCourseTextFrequency() {
			return popCourseTextFrequency;
		}

		public void setPopCourseTextFrequency(TextBox popCourseTextFrequency) {
			this.popCourseTextFrequency = popCourseTextFrequency;
		}
		
		@Override
		public TextBox getSectionNameText() {
			return sectionNameText;
		}

		@Override
		public void setSectionNameText(TextBox sectionNameTextBox) {
			this.sectionNameText = sectionNameTextBox;			
		}

		@Override
		public TextBox getSectionIdText() {
			return sectionIdText;
		}

		@Override
		public void setSectionIdText(TextBox sectionIdTextBox) {
			this.sectionIdText = sectionIdTextBox;			
		}

		@Override
		public ListBox getSectionTypeListBox() {
			return sectionTypeListBox;
		}

		@Override
		public void setSectionTypeListBox(ListBox sectionTypeListBox) {
			this.sectionTypeListBox = sectionTypeListBox;			
		}

		@Override
		public TextBox getPopulationText() {
			return populationText;
		}

		@Override
		public void setPopulationText(TextBox populationTextBox) {
			this.populationText = populationTextBox;			
		}
		
		@Override
		public TextBox getYearText() {
			return yearText;
		}

		@Override
		public void setYearText(TextBox yearText) {
			this.yearText = yearText;
		}

		@Override
		public TextBox getTermText() {
			return termText;
		}

		@Override
		public void setTermText(TextBox termText) {
			this.termText = termText;
		}

		@Override
		public CheckBox getMonday() {
			return monday;
		}

		@Override
		public void setMonday(CheckBox monday) {
			this.monday = monday;
		}

		@Override
		public CheckBox getTuesday() {
			return tuesday;
		}

		@Override
		public void setTuesday(CheckBox tuesday) {
			this.tuesday = tuesday;
		}

		@Override
		public CheckBox getWednesday() {
			return wednesday;
		}

		@Override
		public void setWednesday(CheckBox wednesday) {
			this.wednesday = wednesday;
		}

		@Override
		public CheckBox getThursday() {
			return thursday;
		}
		
		@Override
		public void setThursday(CheckBox thursday) {
			this.thursday = thursday;
		}

		@Override
		public CheckBox getFriday() {
			return friday;
		}

		@Override
		public void setFriday(CheckBox friday) {
			this.friday = friday;
		}

		@Override
		public TextBox getStartTimeText() {
			return startTimeText;
		}

		@Override
		public void setStartTimeText(TextBox startTimeText) {
			this.startTimeText = startTimeText;
		}

		@Override
		public TextBox getEndTimeText() {
			return endTimeText;
		}

		@Override
		public void setEndTimeText(TextBox endTimeText) {
			this.endTimeText = endTimeText;
		}

		public Button getInstructorSubmitButton() {
			return popInstructorButtonSubmit;
		}
		
		public void setInstructorSubmitButton(Button submitButton) {
			this.popInstructorButtonSubmit = submitButton;
		}
		
		public Button getCourseSubmitButton() {
			return popCourseButtonSubmit;
		}
		
		public void setCourseSubmitButton(Button submitButton) {
			this.popCourseButtonSubmit = submitButton;
		}
		
		public Button getSectionSubmitButton() {
			return sectionSubmitButton;
		}

		public void setSectionSubmitButton(Button submitButton) {
			this.sectionSubmitButton = submitButton;
		}

		/* Getters and Setters for year and term dropdowns */
		
		@Override
		public ListBox getYearSelect() {
			return yearSelect;
		}

		@Override
		public void setYearSelect(ListBox yearSelect) {
			this.yearSelect = yearSelect;
		}

		@Override
		public ListBox getTermSelect() {
			return termSelect;
		}

		@Override
		public void setTermSelect(ListBox termSelect) {
			this.termSelect = termSelect;
		}
		
		/* Bound UI Event Handlers */

		@UiHandler("scheduleAddInstructor")
		void onClickAddInstructor(ClickEvent event) {
			popInstructorButtonCreate.setEnabled(true);
			makeInstructorPopUp(true);
		}
		
		@UiHandler("scheduleEditInstructor")
		void onClickEditInstructor(ClickEvent event) {
			popInstructorButtonSubmit.setEnabled(true);
			popInstructorButtonDelete.setEnabled(true);
			makeInstructorPopUp(false);
		}
		
		@UiHandler("scheduleAddCourse")
		void onClickAddCourse(ClickEvent event) {
			popCourseButtonCreate.setEnabled(true);
			makeCoursePopUp(true);
		}
		
		@UiHandler("scheduleEditCourse")
		void onClickEditCourse(ClickEvent event) {
			popCourseButtonSubmit.setEnabled(true);
			popCourseButtonDelete.setEnabled(true);
			makeCoursePopUp(false);
		}
		
		@UiHandler("createSection")
		void onClickAddSection(ClickEvent event) {
			isCreating=true;
			makeSectionPopUp();
		}
		
		@UiHandler("editSection")
		void onClickEditSection(ClickEvent event) {
			isCreating=false;
			makeSectionPopUp();
		}
		
		@UiHandler("instructorBox")
		void onSelectInstructor(ClickEvent event) {
			presenter.selectInstructor();
		}
		
		@UiHandler("courseBox")
		void onSelectCourse(ClickEvent event) {
			presenter.selectCourse();
		}
		
	@UiHandler("validate")
	void onClickValidate(ClickEvent event) {
		presenter.validate();
	}

/*
 * DEAD CODE
 * This code was used when we were trying to use a list of special "ModelButtons" instead of a listbox for selecting instructors and courses.
 * When we realized the listbox was a better way to do this, we removed references to ModelButtons.
 * We kept the code related to ModelButtons around in comments in case we might need it later.
 
		private class instructorClickHandler implements ClickHandler{
			private ModelButton<Instructor> linkedButton;
			
			public instructorClickHandler(ModelButton<Instructor> instButton) {
				linkedButton = instButton;
			}

			@Override
			public void onClick(ClickEvent event) {
				presenter.selectInstructor(linkedButton);
			}
		}
		
		private class courseClickHandler implements ClickHandler{
			private ModelButton<Course> linkedButton;
			
			public courseClickHandler(ModelButton<Course> courseButton) {
				linkedButton = courseButton;
			}

			@Override
			public void onClick(ClickEvent event) {
				
				presenter.selectCourse(linkedButton);
			}
		}
		
		//Gets the currently selected button
		@Override
		public ModelButton<Instructor> getSelectedInstructorButton() {
			return selectedInstructorButton;
		}
		
		//Gets the currently selected course
		@Override
		public ModelButton<Course> getSelectedCourseButton() {
			return selectedCourseButton;
		}
		
		//Adds a button for a given instructor to the list of instructor buttons
		@Override
		public void addInstructorButton(Instructor instructor) {
			ModelButton<Instructor> instButton = new ModelButton<Instructor>(instructor);
			instButton.addClickHandler(new instructorClickHandler(instButton));
			scheduleInstructorsPanel.add(instButton);
			instructorButtons.add(instButton);
		}

		//Adds a button for a given course to the list of course buttons
		@Override
		public void addCourseButton(Course course) {
			ModelButton<Course> courseButton = new ModelButton<Course>(course);
			courseButton.addClickHandler(new courseClickHandler(courseButton));
			scheduleCoursesPanel.add(courseButton);
			courseButtons.add(courseButton);
		}

		//Removes a button for a given instructor from the list of instructor buttons
		@Override
		public void removeInstructorButton(Instructor instructor) {
			for(ModelButton<Instructor> b : instructorButtons) {
				if(b.getModel().equals(instructor)) {
					scheduleInstructorsPanel.remove(b);
					instructorButtons.remove(b);
					return;
				}
			}
		}

		//Removes a button for a given course from the list of course buttons
		@Override
		public void removeCourseButton(Course course) {
			for(ModelButton<Course> b : courseButtons) {
				if(b.getModel().equals(course)) {
					scheduleCoursesPanel.remove(b);
					courseButtons.remove(b);
					return;
				}
			}
		}
*/

		@Override
		public void setPresenter(SchedulePresenter presenter) {
			this.presenter = presenter;			
		}

		@Override
		public Widget getWidgetContainer() {
			
			return this;
		}

		@Override
		public HasWidgets getViewRootPanel() {
			
			return scheduleViewPanel;
		}
		
		/* Getters/setters for calendar */
		
		@Override
		public Grid getCalendar() {
			return calendar;
		}
		
		@Override
		public void setCalendar(Grid calendar) {
			this.calendar = calendar;
		}
		
		/* Adding and removing stuff from calendar */
		
		@Override
		public void addToCalendar(int row, int column, String text) {
			Button courseSectionButton = new Button(text);
			courseSectionButton.addClickHandler(new sectionButtonClickHandler());
			calendar.setWidget(row, column, courseSectionButton);
		}
		
		@Override
		public void removeFromCalendar(int row, int column) {
			calendar.clearCell(row, column);
		}
		
		private class sectionButtonClickHandler implements ClickHandler{
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				selectedCourseSection.setEnabled(true);
				selectedCourseSection = (Button)event.getSource(); // may be errors
				selectedCourseSection.setEnabled(false);
			}
		}
		
		/* Getters for buttons */

		@Override
		public Button getSelectedCourseSection() {
			return selectedCourseSection;
		}

		@Override
		public void setSelectedCourseSection(Button selectedCourseSection) {
			this.selectedCourseSection = selectedCourseSection;
		}
		
		@Override
		public Button getAddInstructorButton() {
			return scheduleAddInstructor;
		}

		@Override
		public Button getEditInstructorButton() {
			return scheduleEditInstructor;
		}

		@Override
		public Button getAddCourseButton() {
			return scheduleAddCourse;
		}

		@Override
		public Button getEditCourseButton() {
			return scheduleEditCourse;
		}

		@Override
		public Button getCreateSectionButton() {
			return createSection;
		}

		@Override
		public Button getEditSectionButton() {
			return editSection;
		}

		@Override
		public Button getValidateButton() {
			return validate;
		}

		@Override
		public void showErrorMessages(String errorMessages) {
			Window.alert(errorMessages);			
		}

/*
 * DEAD CODE
 * See above for more information on "ModelButton" methods

		@Override
		public void setSelectedInstructorButton(ModelButton<Instructor> selection) {
			selectedInstructorButton = selection;
			
		}

		@Override
		public void setSelectedCourseButton(ModelButton<Course> selection) {
			selectedCourseButton = selection;
		}
*/

		public boolean isCreating() {
			return isCreating;
		}

		public void setCreating(boolean isCreating) {
			this.isCreating = isCreating;
		}

		@Override
		public ListBox getInstructorBox() {
			return instructorBox;
		}

		@Override
		public ListBox getCourseBox() {
			return courseBox;
		}

		@Override
		public Button getInstructorDeleteButton() {
			return popInstructorButtonDelete;
		}

		@Override
		public Button getCourseDeleteButton() {
			return popInstructorButtonDelete;
		}

		@Override
		public Button getInstructorCreateButton() {
			return popInstructorButtonCreate;
		}

		@Override
		public Button getCourseCreateButton() {
			return popCourseButtonCreate;
		}
	}