package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidReplyAction;
import org.dselent.course_load_scheduler.client.action.ReceiveClickRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SelectRequestAction;
import org.dselent.course_load_scheduler.client.action.SendReplyAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidReplyStrings;
import org.dselent.course_load_scheduler.client.event.InvalidReplyEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveChangePasswordEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveReplyEvent;
import org.dselent.course_load_scheduler.client.event.SelectRequestEvent;
import org.dselent.course_load_scheduler.client.event.SendReplyEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.presenter.AdminRequestPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import org.dselent.course_load_scheduler.client.view.AdminRequestView;

import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AdminRequestPresenterImpl extends BasePresenterImpl implements AdminRequestPresenter
{
	private IndexPresenter parentPresenter;
	private MainPresenter mainPresenter;
	private AdminRequestView view;
	private GlobalData globalData;
	private boolean replyClickInProgress;
	private boolean selectClickInProgress;
	
	@Inject
	public AdminRequestPresenterImpl(IndexPresenter parentPresenter, AdminRequestView view, MainPresenter mainPresenter, GlobalData globalData)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		this.mainPresenter = mainPresenter;
		this.globalData = globalData;
		view.setPresenter(this);
		replyClickInProgress = false;
		selectClickInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidReplyEvent.TYPE, this);
		eventBusRegistration.put(InvalidReplyEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container)
	{
		// need to make changes here
		
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public AdminRequestView getView() {
		// TODO Auto-generated method stub
		return view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		// TODO Auto-generated method stub
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		// TODO Auto-generated method stub
		this.parentPresenter = parentPresenter;
	}
	
	@Override
	public void reply() {
		if(!replyClickInProgress) {
			replyClickInProgress = true;
			view.getReplyButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			Integer requestId = Integer.parseInt(view.getUserRequestLabel().getText());
			String description = view.getReplyTextArea().getText();
			boolean approved = view.getApproved().getValue();
			boolean tentative = view.getTentative().getValue();
			boolean rejected = view.getRejected().getValue();
			String replyType = "";
			
			boolean validDescription = true;
			boolean validReplyType = true;
			
			List<String> invalidReasonList= new ArrayList<>();
			
			try {
				validateField(description);
			}
			catch(EmptyStringException e) {
				invalidReasonList.add(InvalidReplyStrings.NULL_DESCRIPTION);
				validDescription = false;
			}
			
			if(approved) {
				replyType = "approved";
			}
			else if(tentative){
				replyType = "tentative";
			}
			else if(rejected) {
				replyType = "rejected";
			}
			else {
				replyType = null; //None of radio button selected
				invalidReasonList.add(InvalidReplyStrings.NULL_REPLYTYPE);
				validReplyType = false;
			}
			
			if(validDescription && validReplyType) {
				sendReply(requestId, description, replyType);
			}
			else {
				InvalidReplyAction ira = new InvalidReplyAction(invalidReasonList);
				InvalidReplyEvent ire = new InvalidReplyEvent(ira);
				onInvalidReply(ire);
				eventBus.fireEvent(ire);
			}
		}


	}
	
	private void sendReply(Integer requestId, String description, String replyType) {
		parentPresenter.hideLoadScreen();
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendReplyAction sra = new SendReplyAction(requestId, description, replyType);
		SendReplyEvent sre = new SendReplyEvent(sra, container);
		eventBus.fireEvent(sre);
	}

	@Override
	public void selectRequest() {
		if(!selectClickInProgress) {
			selectClickInProgress = true;
			view.getRequestList().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			int selectedIndex = view.getRequestList().getSelectedIndex();
			//String selectedItem = view.getRequestList().getValue(selectedIndex);
			Request selectedRequest = view.getRequest(selectedIndex);
			String requester = String.valueOf(selectedRequest.getRequesterId());
			String requestType = selectedRequest.getRequestType();
			String requestDetail = selectedRequest.getRequestDetails();
			selectRequestAction(selectedRequest.getRequesterId(), requestType, requestDetail);
			view.setUserRequestLabel(requester);
			view.setTypeLabel(requestType);
			view.setRequesterDescriptLabel(requestDetail);			
		}		
		
		
	}
	
	private void selectRequestAction(Integer requester, String requestType, String Description) {
		parentPresenter.hideLoadScreen();
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SelectRequestAction sra = new SelectRequestAction(requester, requestType, Description);
		SelectRequestEvent sre = new SelectRequestEvent(sra, container);
		eventBus.fireEvent(sre);
	}
	
	private void validateField(String field) throws EmptyStringException
	{
		checkEmptyString(field);
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}

	@Override
	public void onInvalidReply(InvalidReplyEvent evt) {
		parentPresenter.hideLoadScreen();
		view.getReplyButton().setEnabled(true);
		replyClickInProgress = false;
		
		InvalidReplyAction ira = evt.getAction();
		view.showErrorMessages(ira.toString());
	}

	public void onReceiveReply(ReceiveReplyEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getReplyButton().setEnabled(true);
		replyClickInProgress = false;
	}
	
	public void onReceiveClickRequestTab(ReceiveClickRequestTabEvent evt)
	{	
		this.go(mainPresenter.getRequestPanel());
		/*
		ReceiveClickRequestTabAction action = evt.getAction();
		view.setChangingUsernameLabelText(action.getUserName());
		view.setChangingNameLabelText(action.getFirstName() + " " + action.getLastName());
		view.setChangingRequestStateLabelText(action.getUserRole());
		view.setChangingEmailLabelText(action.getEmail());
		
		populateRequestList(action.getRequestList());
		*/
		parentPresenter.hideLoadScreen();
	}
	
	@Override
	public void populateRequestList(List<Request> requestList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillRequestFields() {
		// TODO Auto-generated method stub
		
	}

	
}
