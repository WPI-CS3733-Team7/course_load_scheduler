package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.RadioButton;

//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.ListBox;

public class MainViewImpl extends Composite implements HasText {

	private static MainViewImplUiBinder uiBinder = GWT.create(MainViewImplUiBinder.class);
	//@UiField Button button;
	//@UiField Button button_1;

	@UiField RadioButton rdoCourse;
	@UiField RadioButton rdoOther;
	@UiField Button rdoSubmit;

	/*@UiField Button createSection;
	@UiField Button editSection;
	@UiField Button validate;
	@UiField Label selectYear;
	@UiField Label selectTerm;
	@UiField ListBox yearSelect;
	@UiField ListBox termSelect;*/



	interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
	}

	public MainViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public MainViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
		// todo
	}

	public String getText() {
		// todo
		return null;
	}
}
