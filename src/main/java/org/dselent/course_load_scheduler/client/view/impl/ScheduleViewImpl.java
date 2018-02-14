package org.dselent.course_load_scheduler.client.view.impl;

	import java.util.ArrayList;
	import java.util.List;

import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleView;

	import com.google.gwt.core.client.GWT;
	import com.google.gwt.event.dom.client.ClickEvent;
	import com.google.gwt.event.dom.client.ClickHandler;
	import com.google.gwt.uibinder.client.UiBinder;
	import com.google.gwt.uibinder.client.UiField;
	import com.google.gwt.uibinder.client.UiHandler;
	import com.google.gwt.uibinder.client.UiTemplate;
	import com.google.gwt.user.client.ui.Button;
	import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
	import com.google.gwt.user.client.ui.ListBox;
	import com.google.gwt.user.client.ui.VerticalPanel;
	import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HorizontalPanel;

	public class ScheduleViewImpl extends BaseViewImpl<SchedulePresenter> implements ScheduleView {

		private static ScheduleViewImplUiBinder uiBinder = GWT.create(ScheduleViewImplUiBinder.class);
		
		//@UiTemplate(value = "MainViewImpl.ui.xml")
		interface ScheduleViewImplUiBinder extends UiBinder<Widget, ScheduleViewImpl>{}

		
		List<Button> instructorButtons = new ArrayList<Button>();
		List<Button> courseButtons = new ArrayList<Button>();
		
		Button selectedInstructorButton = null;
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
		Label selectYear;
		
		@UiField 
		Label selectTerm;
		
		@UiField 
		ListBox yearSelect;
		
		@UiField 
		ListBox termSelect;
		
		@UiField
		Label instructorsTitle;
		
		@UiField 
		Label coursesTitle;
		
		@UiField 
		Button instructor1;
		
		@UiField
		Button instructor2;
		
		@UiField 
		Button instructor3;
		
		@UiField
		Button course1;
		
		@UiField 
		Button course2;
		
		@UiField 
		Button course3;
		
		@UiField 
		Label scheduleTitle;
		
		@UiField 
		HorizontalPanel scheduleViewPanel;

		public ScheduleViewImpl() {
			initWidget(uiBinder.createAndBindUi(this));
		}

		@UiHandler("scheduleAddInstructor")
		void onClickAddInstructor(ClickEvent event) {
		}
		
		@UiHandler("scheduleEditInstructor")
		void onClickEditInstructor(ClickEvent event) {
		}
		
		@UiHandler("scheduleAddCourse")
		void onClickAddCourse(ClickEvent event) {
		}
		
		@UiHandler("scheduleEditCourse")
		void onClickEditCourse(ClickEvent event) {
		}
		
		@UiHandler("createSection")
		void onClickAddSection(ClickEvent event) {
		}
		
		@UiHandler("editSection")
		void onClickEditSection(ClickEvent event) {
		}
		
		@UiHandler("validate")
		void onClickValidate(ClickEvent event) {
		}
		
		//UiHandlers for select year/term labels and list boxes needed?

		private class instructorClickHandler implements ClickHandler{
			private Button linkedButton;
			
			public instructorClickHandler(Button instButton) {
				linkedButton = instButton;
			}

			@Override
			public void onClick(ClickEvent event) {
				if(selectedInstructorButton!=null)
					selectedInstructorButton.setText(selectedInstructorButton.getText().substring(4, selectedInstructorButton.getText().length()-5));
				linkedButton.setText("[[[ "+ linkedButton.getText() +" ]]]");
				selectedInstructorButton = linkedButton;
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
					selectedCourseButton.setText(selectedCourseButton.getText().substring(4, selectedCourseButton.getText().length()-5));
				linkedButton.setText("[[[ "+ linkedButton.getText() +" ]]]");
				selectedCourseButton = linkedButton;
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
		public void addInstructorButton(String instructorName) {
			Button instButton = new Button();
			instButton.setText(instructorName);
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public Widget getWidgetContainer() {
			
			return this;
		}

		@Override
		public HasWidgets getViewRootPanel() {
			
			return scheduleViewPanel;
		}		
	}