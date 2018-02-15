package org.dselent.course_load_scheduler.client.view.impl;

	import java.util.ArrayList;
	import java.util.List;
	import org.dselent.course_load_scheduler.client.model.Instructor;
	import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
	import org.dselent.course_load_scheduler.client.view.ScheduleView;
	import com.google.gwt.core.client.GWT;
	import com.google.gwt.event.dom.client.ClickEvent;
	import com.google.gwt.event.dom.client.ClickHandler;
	import com.google.gwt.uibinder.client.UiBinder;
	import com.google.gwt.uibinder.client.UiField;
	import com.google.gwt.uibinder.client.UiHandler;
	import com.google.gwt.user.client.ui.Button;
	import com.google.gwt.user.client.ui.Grid;
	import com.google.gwt.user.client.ui.HasWidgets;
	import com.google.gwt.user.client.ui.Label;
	import com.google.gwt.user.client.ui.ListBox;
	import com.google.gwt.user.client.ui.PopupPanel;
	import com.google.gwt.user.client.ui.TextBox;
	import com.google.gwt.user.client.ui.VerticalPanel;
	import com.google.gwt.user.client.ui.Widget;
	import com.google.gwt.user.client.ui.HorizontalPanel;
	import com.google.gwt.user.client.Window;

	public class ScheduleViewImpl extends BaseViewImpl<SchedulePresenter> implements ScheduleView {

		private static ScheduleViewImplUiBinder uiBinder = GWT.create(ScheduleViewImplUiBinder.class);
		
		//@UiTemplate(value = "MainViewImpl.ui.xml")
		interface ScheduleViewImplUiBinder extends UiBinder<Widget, ScheduleViewImpl>{}

		SchedulePresenter presenter;
		
		List<ModelButton<Instructor>> instructorButtons = new ArrayList<ModelButton<Instructor>>();
		List<Button> courseButtons = new ArrayList<Button>();
		
		ModelButton<Instructor> selectedInstructorButton = null;
		Button selectedCourseButton = null;
		
		@UiField
		VerticalPanel scheduleInstructorsPanel;
		
		@UiField
		VerticalPanel scheduleCoursesPanel;
		
		@UiField
		Button scheduleAddInstructor;
		
		@UiField
		Button scheduleEditInstructor;
		
		@UiField
		Button scheduleAddCourse;
		
		@UiField
		Button scheduleEditCourse;
		
		@UiField
		Button createSection;
		
		@UiField
		Button editSection;
		
		@UiField 
		Button validate;
		
		@UiField 
		ListBox yearSelect;
		
		@UiField 
		ListBox termSelect;
		
		@UiField 
		HorizontalPanel scheduleViewPanel;
		

		/* Pop-up Widgets for Instructor */
		Label popInstructorLabelFirstName = new Label("First Name:");
		Label popInstructorLabelLastName = new Label("Last Name:");
		Label popInstructorLabelRank = new Label("Rank:");
		Label popInstructorLabelEmail = new Label("Email:");
		TextBox popInstructorTextFirstName = new TextBox();
		TextBox popInstructorTextLastName = new TextBox();
		TextBox popInstructorTextRank = new TextBox();
		TextBox popInstructorTextEmail = new TextBox();
		Button popIntructorButtonDelete = new Button("Delete", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.deleteInstructor();
			}
		});
		Button popIntructorButtonSubmit = new Button("Submit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.editInstructor();
				addInstructorButton(new Instructor());
			}
		});

		/* Pop-up Widgets for Course Sections */
		Label sectionLabel = new Label("Create/Edit a Section");
		Label sectionNameLabel = new Label("Section Name");
		Label sectionIdLabel = new Label("Section ID (CRN)");
		Label sectionTypeLabel = new Label("Section Type");
		Label populationLabel = new Label("Population");
		TextBox sectionNameText = new TextBox();
		TextBox sectionIdText = new TextBox();
		TextBox sectionTypeText = new TextBox();
		TextBox populationText = new TextBox();
		Button submitButton = new Button("Submit", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//presenter.();
			}
		});

		/* Pop-up Widgets for Course */
		Label popCourseLabelName = new Label("Course Name:");
		Label popCourseLabelNumber = new Label("Course Number:");
		Label popCourseLabelFrequency = new Label("Required Frequency:");
		TextBox popCourseTextName = new TextBox();
		TextBox popCourseTextNumber = new TextBox();
		TextBox popCourseTextFrequency = new TextBox();
		Button popCourseButtonDelete = new Button();
		Button popCourseButtonSubmit = new Button();

		/* Constructor */
		public ScheduleViewImpl() {
			initWidget(uiBinder.createAndBindUi(this));
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
			popGrid.setWidget(4, 1, popIntructorButtonSubmit);
			if(!creating) {
				popGrid.setWidget(4, 0, popIntructorButtonDelete);
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
			popGrid.setWidget(3, 1, popCourseButtonSubmit);
			if(!creating) {
				popGrid.setWidget(3, 0, popCourseButtonDelete);
			}
			
			PopupPanel editPopup = new PopupPanel(true);
			editPopup.add(popGrid);
			editPopup.isGlassEnabled();
			editPopup.center();
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

		/* Getters and Setters for year and term dropdowns */
		
		public ListBox getYearSelect() {
			return yearSelect;
		}

		public void setYearSelect(ListBox yearSelect) {
			this.yearSelect = yearSelect;
		}

		public ListBox getTermSelect() {
			return termSelect;
		}

		public void setTermSelect(ListBox termSelect) {
			this.termSelect = termSelect;
		}
		
		/* Bound UI Event Handlers */

		@UiHandler("scheduleAddInstructor")
		void onClickAddInstructor(ClickEvent event) {

			makeInstructorPopUp(true);
		}
		
		@UiHandler("scheduleEditInstructor")
		void onClickEditInstructor(ClickEvent event) {

			makeInstructorPopUp(false);
		}
		
		@UiHandler("scheduleAddCourse")
		void onClickAddCourse(ClickEvent event) {

			makeCoursePopUp(true);
		}
		
		@UiHandler("scheduleEditCourse")
		void onClickEditCourse(ClickEvent event) {

			makeCoursePopUp(false);
		}
		
		@UiHandler("createSection")
		void onClickAddSection(ClickEvent event) {
			Grid sectionGrid = new Grid(4, 2);		
			sectionGrid.setWidget(0, 0, sectionNameLabel);
			sectionGrid.setWidget(0, 1, sectionNameText);
			sectionGrid.setWidget(1, 0, sectionIdLabel);
			sectionGrid.setWidget(1, 1, sectionIdText);
			sectionGrid.setWidget(2, 0, sectionTypeLabel);
			sectionGrid.setWidget(2, 1, sectionTypeText);
			sectionGrid.setWidget(3, 0, populationLabel);
			sectionGrid.setWidget(3, 1, populationText);
			
			VerticalPanel vertPanel = new VerticalPanel();
			vertPanel.add(sectionLabel);
			vertPanel.add(sectionGrid);
			vertPanel.add(submitButton);
			
			PopupPanel registerPopup = new PopupPanel(true);
			registerPopup.add(vertPanel);
			registerPopup.isGlassEnabled();
			registerPopup.center();
			
		}
		
		@UiHandler("editSection")
		void onClickEditSection(ClickEvent event) {
			Grid sectionGrid = new Grid(4, 2);		
			sectionGrid.setWidget(0, 0, sectionNameLabel);
			sectionGrid.setWidget(0, 1, sectionNameText);
			sectionGrid.setWidget(1, 0, sectionIdLabel);
			sectionGrid.setWidget(1, 1, sectionIdText);
			sectionGrid.setWidget(2, 0, sectionTypeLabel);
			sectionGrid.setWidget(2, 1, sectionTypeText);
			sectionGrid.setWidget(3, 0, populationLabel);
			sectionGrid.setWidget(3, 1, populationText);
			
			VerticalPanel vertPanel = new VerticalPanel();
			vertPanel.add(sectionLabel);
			vertPanel.add(sectionGrid);
			vertPanel.add(submitButton);
			
			PopupPanel registerPopup = new PopupPanel(true);
			registerPopup.add(vertPanel);
			registerPopup.isGlassEnabled();
			registerPopup.center();
		}
		
		@UiHandler("validate")
		void onClickValidate(ClickEvent event) {
			//presenter.
		}
		
		//UiHandlers for select year/term labels and list boxes needed?

		private class instructorClickHandler implements ClickHandler{
			private ModelButton<Instructor> linkedButton;
			
			public instructorClickHandler(ModelButton<Instructor> instButton) {
				linkedButton = instButton;
			}

			@Override
			public void onClick(ClickEvent event) {
				if(selectedInstructorButton!=null)
					selectedInstructorButton.setText(selectedInstructorButton.getModel().displayText());
				linkedButton.setText("[[[ "+ selectedInstructorButton.getModel().displayText() +" ]]]");
				selectedInstructorButton = linkedButton;
				presenter.selectInstructor();
			}
		}
		
		private class courseClickHandler implements ClickHandler{
			private Button linkedButton;
			
			public courseClickHandler(Button courseButton) {
				linkedButton = courseButton;
			}

			@Override
			public void onClick(ClickEvent event) {
				if(selectedCourseButton!=null)
					selectedCourseButton.setText(selectedCourseButton.getText().substring(4, selectedCourseButton.getText().length()-4));
				linkedButton.setText("[[[ "+ linkedButton.getText() +" ]]]");
				selectedCourseButton = linkedButton;
				presenter.selectCourse();
			}
		}
		
		//Gets the currently selected button
		@Override
		public Button getSelectedInstructor() {
			return selectedInstructorButton;
		}
		
		//Gets the currently selected course
		@Override
		public Button getSelectedCourse() {
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
		public void addCourseButton(String courseName) {
			Button courseButton = new Button();
			courseButton.setText(courseName);
			courseButton.addClickHandler(new courseClickHandler(courseButton));
			scheduleCoursesPanel.add(courseButton);
			courseButtons.add(courseButton);
		}

		//Removes a button for a given instructor from the list of instructor buttons
		@Override
		public void removeInstructorButton(String instructorName) {
			for(Button b : instructorButtons) {
				if(b.getText().equals(instructorName)) {
					scheduleInstructorsPanel.remove(b);
					instructorButtons.remove(b);
					return;
				}
			}
		}

		//Removes a button for a given course from the list of course buttons
		@Override
		public void removeCourseButton(String courseName) {
			for(Button b : courseButtons) {
				if(b.getText().equals(courseName)) {
					scheduleCoursesPanel.remove(b);
					courseButtons.remove(b);
					return;
				}
			}
		}

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
		public TextBox getSectionTypeText() {
			return sectionTypeText;
		}

		@Override
		public void setSectionTypeText(TextBox sectionTypeTextBox) {
			this.sectionTypeText = sectionTypeTextBox;			
		}

		@Override
		public TextBox getPopulationText() {
			return populationText;
		}

		@Override
		public void setPopulationText(TextBox populationTextBox) {
			this.populationText = populationTextBox;			
		}
		
		public Button getSubmitButton() {
			return submitButton;
		}

		public void setSubmitButton(Button submitButton) {
			this.submitButton = submitButton;
		}
	}