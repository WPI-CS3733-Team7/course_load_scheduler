package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.SchedulePresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox; 

public interface ScheduleView extends BaseView<SchedulePresenter>{
	

	/* Removed ModelButton methods
	public void addInstructorButton(Instructor instructor);
	public void addCourseButton(Course course);
	public void removeInstructorButton(Instructor instructor);
	public void removeCourseButton(Course course);
	public ModelButton<Instructor> getSelectedInstructorButton();
	public ModelButton<Course> getSelectedCourseButton();
	public void setSelectedInstructorButton(ModelButton<Instructor> selection);
	public void setSelectedCourseButton(ModelButton<Course> selection);*/
	
	Button getAddInstructorButton();
	Button getEditInstructorButton();
	Button getAddCourseButton();
	Button getEditCourseButton();
	Button getCreateSectionButton();
	Button getEditSectionButton();
	Button getValidateButton();
	void showErrorMessages(String errorMessages);
	
	public Grid getCalendar();
	public void setCalendar(Grid calendar);
	
	TextBox getSectionNameText();
	void setSectionNameText(TextBox sectionNameTextBox);
	TextBox getSectionIdText();
	void setSectionIdText(TextBox sectionIdTextBox);
	ListBox getSectionTypeListBox();
	void setSectionTypeListBox(ListBox sectionTypeListBox);
	TextBox getPopulationText();
	void setPopulationText(TextBox populationTextBox);
	
	Button getSectionSubmitButton();
	Button getInstructorSubmitButton();
	Button getCourseSubmitButton();
	
	public TextBox getPopInstructorTextFirstName();
	public void setPopInstructorTextFirstName(TextBox popInstructorTextFirstName);
	public TextBox getPopInstructorTextLastName();
	public void setPopInstructorTextLastName(TextBox popInstructorTextLastName);
	public TextBox getPopInstructorTextRank();
	public void setPopInstructorTextRank(TextBox popInstructorTextRank);
	public TextBox getPopInstructorTextEmail();
	public void setPopInstructorTextEmail(TextBox popInstructorTextEmail);
	public RadioButton getRegular();
	public void setRegular(RadioButton regular);
	public RadioButton getSpecial();
	public void setSpecial(RadioButton special);
	public TextBox getCourseLoadDescriptionText();
	public void setCourseLoadDescriptionText(TextBox courseLoadDescriptionText);
	public TextBox getPopCourseTextName();
	public void setPopCourseTextName(TextBox popCourseTextName);
	public TextBox getPopCourseTextNumber();
	public void setPopCourseTextNumber(TextBox popCourseTextNumber);
	public TextBox getPopCourseTextFrequency();
	public void setPopCourseTextFrequency(TextBox popCourseTextFrequency);
	
	public ListBox getInstructorBox();
	public ListBox getCourseBox();
	
	
	public Button getInstructorDeleteButton();
	public Button getCourseDeleteButton();
	public Button getInstructorCreateButton();
	public Button getCourseCreateButton();
	
	boolean isCreating();
	void setCreating(boolean c);
	TextBox getYearText();
	void setYearText(TextBox yearText);
	TextBox getTermText();
	void setTermText(TextBox termText);
	CheckBox getMonday();
	void setMonday(CheckBox monday);
	CheckBox getTuesday();
	void setTuesday(CheckBox tuesday);
	CheckBox getWednesday();
	void setWednesday(CheckBox wednesday);
	CheckBox getThursday();
	void setThursday(CheckBox thursday);
	CheckBox getFriday();
	void setFriday(CheckBox friday);
	TextBox getStartTimeText();
	void setStartTimeText(TextBox startTimeText);
	TextBox getEndTimeText();
	void setEndTimeText(TextBox endTimeText);
	ListBox getYearSelect();
	void setYearSelect(ListBox yearSelect);
	ListBox getTermSelect();
	void setTermSelect(ListBox termSelect);
	void addToCalendar(int row, int column, String text);
	void removeFromCalendar(int row, int column);
	
	Button getSelectedCourseSection();
	void setSelectedCourseSection(Button selectedCourseSection);
}
