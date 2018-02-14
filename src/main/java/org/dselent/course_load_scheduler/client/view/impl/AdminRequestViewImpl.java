package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.AdminRequestPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserRequestPresenter;
import org.dselent.course_load_scheduler.client.view.AdminRequestView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class AdminRequestViewImpl extends BaseViewImpl<AdminRequestPresenter> implements AdminRequestView {

	private static AdminRequestViewImplUiBinder uiBinder = GWT.create(AdminRequestViewImplUiBinder.class);
	@UiField 
	HorizontalPanel adminRequestPanel;
	
	@UiField 
	Label requestListLabel;
	
	@UiField 
	ListBox requestList;
	
	@UiField 
	VerticalPanel requestListPanel;
	
	@UiField 
	AbsolutePanel replyPanel;
	
	@UiField 
	Label fromLabel;
	
	@UiField 
	Label typeLabel;
	
	@UiField 
	Label descriptLabel;
	
	@UiField 
	Label setUserLabel;
	
	@UiField 
	Label setTypeLabel;
	
	@UiField 
	Label setUserDescriptLabel;
	
	@UiField 
	Label responseLabel;
	
	@UiField 
	TextArea replyTextArea;
	
	@UiField 
	RadioButton approvedRdo;
	
	@UiField 
	RadioButton tentativeRdo;
	
	@UiField 
	RadioButton rejectedRdo;
	
	@UiField 
	Button replyButton;

	interface AdminRequestViewImplUiBinder extends UiBinder<Widget, AdminRequestViewImpl> {
	}

	public AdminRequestViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setPresenter(AdminRequestPresenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
		
	}
	
	@Override
	public ListBox getRequestList() {
		return requestList;
	}
	
	@Override
	public void setRequestList(ListBox requestList) {
		this.requestList = requestList;
	}
	
	@Override
	public Label getUserRequestLabel() {
		return setUserLabel;
	}
	
	@Override
	public void setUserRequestLabel(Label setUserLabel) {
		this.setUserLabel = setUserLabel;
	}
	
	@Override
	public Label getTypeLabel() {
		return setTypeLabel;
	}
	
	@Override
	public void setTypeLabel(Label setTypeLabel) {
		this.setTypeLabel = setTypeLabel;
	}
	
	@Override
	public Label getRequesterDescriptLabel() {
		return setUserDescriptLabel;
	}
	
	@Override
	public void setRequesterDescriptLabel(Label setDescriptLabel) {
		this.setUserDescriptLabel = setDescriptLabel;
	}
	
	@Override
	public TextArea getReplyTextArea() {
		return replyTextArea;
	}
	
	@Override
	public void setReplyTextArea(TextArea replyTextArea) {
		this.replyTextArea = replyTextArea;
	}
	
	@Override
	public Button getReplyButton() {
		return replyButton;
	}
	public void showErrorMessages(String errorMessages) {
		Window.alert(errorMessages);
	}

	@UiHandler("replyButton")
	void onReplyButtonClick(ClickEvent event) {
	}

	@Override
	public Widget getWidgetContainer() {
		// TODO Auto-generated method stub
		
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		// TODO Auto-generated method stub
		return adminRequestPanel;
	}
}
