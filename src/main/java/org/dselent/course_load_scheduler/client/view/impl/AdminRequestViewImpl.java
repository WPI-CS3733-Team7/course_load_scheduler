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

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.Request;


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
	
	private List<Request> requests = new ArrayList<>();

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
	
	public void addRequest(Request r) {
		this.requests.add(r);
		this.requestList.addItem(r.getRequestDetails());
	}
	
	@Override
	public Request getRequest(int index) {
		return requests.get(index);
	}
	
	public void setRequest(List<Request> requests) {
		this.requests = requests;
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
	public void setRequestList(List<Request> requests) {
		for(Request r : requests) {
			addRequest(r);
		}
	}
	
	@Override
	public Label getUserRequestLabel() {
		return setUserLabel;
	}
	
	@Override
	public void setUserRequestLabel(String requester) {
		this.setUserLabel.setText(requester);
	}
	
	@Override
	public Label getTypeLabel() {
		return setTypeLabel;
	}
	
	@Override
	public void setTypeLabel(String requestType) {
		this.setTypeLabel.setText(requestType);
	}
	
	@Override
	public Label getRequesterDescriptLabel() {
		return setUserDescriptLabel;
	}
	
	@Override
	public void setRequesterDescriptLabel(String requestDetail) {
		this.setUserDescriptLabel.setText(requestDetail);
	}
	
	@Override
	public TextArea getReplyTextArea() {
		return replyTextArea;
	}
	
	@Override
	public void setReplyTextArea(String Text) {
		this.replyTextArea.setText(Text);
	}
	
	@Override
	public RadioButton getApproved() {
		return approvedRdo;
	}

	@Override
	public void setApproved(RadioButton approvedRdo) {
		this.approvedRdo = approvedRdo;
	}

	@Override
	public RadioButton getTentative() {
		return tentativeRdo;
	}

	@Override
	public void setTentative(RadioButton tentativeRdo) {
		this.tentativeRdo = tentativeRdo;
		
	}

	@Override
	public RadioButton getRejected() {
		return rejectedRdo;
	}

	@Override
	public void setRejected(RadioButton rejectedRdo) {
		this.rejectedRdo = rejectedRdo;
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
		presenter.reply();
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
