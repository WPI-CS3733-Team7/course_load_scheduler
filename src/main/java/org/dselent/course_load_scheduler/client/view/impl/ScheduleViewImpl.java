package org.dselent.course_load_scheduler.client.view.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ScheduleViewImpl extends Composite implements ScheduleView {

	private static MainViewImplUiBinder uiBinder = GWT.create(MainViewImplUiBinder.class);
	
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

	@UiTemplate(value = "MainViewImpl.ui.xml")
	interface MainViewImplUiBinder extends UiBinder<Widget, ScheduleViewImpl> {
	}

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
}
