package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.model.Course;
import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.impl.ModelButton;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface ScheduleView extends BaseView<SchedulePresenter>{
	
	public void addInstructorButton(Instructor instructor);
	public void addCourseButton(Course course);
	public void removeInstructorButton(Instructor instructor);
	public void removeCourseButton(Course course);
	public ModelButton<Instructor> getSelectedInstructorButton();
	public ModelButton<Course> getSelectedCourseButton();
	public void setSelectedInstructorButton(ModelButton<Instructor> selection);
	public void setSelectedCourseButton(ModelButton<Course> selection);
	
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
	Button getSubmitButton();
}
