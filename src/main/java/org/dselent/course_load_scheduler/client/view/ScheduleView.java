package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface ScheduleView extends BaseView<SchedulePresenter>{
	
	public void addInstructorButton(Instructor instructor);
	public void addCourseButton(String courseName);
	public void removeInstructorButton(String instructorName);
	public void removeCourseButton(String courseName);
	public Button getSelectedInstructor();
	public Button getSelectedCourse();
	
	Button getAddInstructorButton();
	Button getEditInstructorButton();
	Button getAddCourseButton();
	Button getEditCourseButton();
	Button getCreateSectionButton();
	Button getEditSectionButton();
	Button getValidateButton();
	void showErrorMessages(String errorMessages);
	
	TextBox getSectionNameText();
	void setSectionNameText(TextBox sectionNameTextBox);
	TextBox getSectionIdText();
	void setSectionIdText(TextBox sectionIdTextBox);
	TextBox getSectionTypeText();
	void setSectionTypeText(TextBox sectionTypeTextBox);
	TextBox getPopulationText();
	void setPopulationText(TextBox populationTextBox);
	
	Button getSectionSubmitButton();
	Button getInstructorSubmitButton();
	Button getCourseSubmitButton();
}
