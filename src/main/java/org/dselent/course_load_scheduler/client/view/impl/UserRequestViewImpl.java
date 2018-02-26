package org.dselent.course_load_scheduler.client.view.impl;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.presenter.UserRequestPresenter;
import org.dselent.course_load_scheduler.client.view.UserRequestView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;

public class UserRequestViewImpl extends BaseViewImpl<UserRequestPresenter> implements UserRequestView {

	private static UserRequestViewImplUiBinder uiBinder = GWT.create(UserRequestViewImplUiBinder.class);

	interface UserRequestViewImplUiBinder extends UiBinder<Widget, UserRequestViewImpl>{}
	
	@UiField 
	Label createLabel;
	
	@UiField 
	HorizontalPanel requestTabPanel;
	
	@UiField 
	VerticalPanel createPanel;
	
	@UiField 
	VerticalPanel requestHistoryPanel;
	
	@UiField 
	Label requestTypeLabel;
	
	@UiField 
	RadioButton courseRdo;
	
	@UiField 
	RadioButton otherRdo;
	
	@UiField 
	TextArea descriptTextArea;
	
	@UiField 
	Button submitButton;
	
	@UiField 
	Label requestHistoryLabel;
	
	@UiField 
	ListBox requestHistoryList;

	public UserRequestViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setPresenter(UserRequestPresenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
		
	}



	@Override
	public RadioButton getCourseRdo() {
		// TODO Auto-generated method stub
		
		return courseRdo;
	}



	@Override
	public void setCourseRdo(RadioButton courseRdo) {
		// TODO Auto-generated method stub
		this.courseRdo = courseRdo;
	}



	@Override
	public RadioButton getOtherRdo() {
		// TODO Auto-generated method stub
		return otherRdo;
	}



	@Override
	public void setOtherRdo(RadioButton otherRdo) {
		// TODO Auto-generated method stub
		this.otherRdo = otherRdo;
	}



	@Override
	public Button getSubmitButton() {
		// TODO Auto-generated method stub
		return submitButton;
	}
	
	@Override
	public ListBox getRequestHistoryList() {
		return requestHistoryList;
	}
	
	@Override
	public void setRequestHistoryList(ListBox requestHistoryList) {
		this.requestHistoryList = requestHistoryList;
	}
	
	@Override
	public void setRequestHistoryList(List<Request> requestList) {
		for (Request r: requestList) {
			requestHistoryList.addItem(r.getRequestDetails());
		}
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return requestTabPanel;
	}
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	
	@UiHandler("submitButton")
	void onSubmitButtonClicked(ClickEvent evt)
	{
		presenter.submit();
	}


	@Override
	public TextArea getDescriptionTextArea() {
		return descriptTextArea;
	}
	
	@Override
	public void setDescriptionTextArea(TextArea descriptionTextArea) {
		this.descriptTextArea = descriptionTextArea;
	}
	
}
