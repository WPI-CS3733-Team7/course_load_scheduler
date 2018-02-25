package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidRequestAction;
import org.dselent.course_load_scheduler.client.action.ReceiveClickUserRequestTabAction;
import org.dselent.course_load_scheduler.client.action.SendRequestAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidSubmitStrings;
import org.dselent.course_load_scheduler.client.event.InvalidRequestEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveClickAccountTabEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveUserClickRequestTabEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.MainPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserRequestPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.UserRequestView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class UserRequestPresenterImpl extends BasePresenterImpl implements UserRequestPresenter
{
	private IndexPresenter parentPresenter;
	private MainPresenter mainPresenter;
	private UserRequestView view;
	private GlobalData globalData;
	private boolean submitClickInProgress;
	
	@Inject
	public UserRequestPresenterImpl(IndexPresenter parentPresenter, MainPresenter mainPresenter, UserRequestView view, GlobalData globalData)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		this.mainPresenter = mainPresenter;
		this.globalData = globalData;
		view.setPresenter(this);
		submitClickInProgress = false;
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
		
		registration = eventBus.addHandler(InvalidRequestEvent.TYPE, this);
		eventBusRegistration.put(InvalidRequestEvent.TYPE, registration);
		
		registration = eventBus.addHandler(ReceiveUserClickRequestTabEvent.TYPE, this);
		eventBusRegistration.put(ReceiveUserClickRequestTabEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
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
	public void submit() {
		// TODO Auto-generated method stub
		if(!submitClickInProgress)
		{
			submitClickInProgress = true;
			view.getSubmitButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			boolean courses = view.getCourseRdo().getValue(); //Check click or not on radio button course
			boolean other = view.getOtherRdo().getValue(); ////Check click or not on radio button other
			String requestType = "";
			
			String description = view.getDescriptionTextArea().getText();
			
			boolean validRequesttype = true; //Manage request type
			boolean validDescription = true; //Manage description

			List<String> invalidReasonList = new ArrayList<>();
			
			try
			{
				validateField(description);
			}
			catch(EmptyStringException e) //Empty description
			{
				invalidReasonList.add(InvalidSubmitStrings.NULL_DESCRIPTION); //Null description error message
				validDescription = false;
			}
			
			if(courses) {
				requestType = "courses"; //return courses if clicked course radio button
			}
			else if(other){
				requestType = "others"; ////return other if clicked other radio button
			}
			else {
				requestType = null; //None of radio button selected
				invalidReasonList.add(InvalidSubmitStrings.NULL_REQUESTTYPE); //Null request Type error message
				validRequesttype = false;
			}
			
			if(validRequesttype && validDescription) { //Both True
				sendRequest(description, requestType); //Show both informations
			}
			else									//Return error messages
			{
				InvalidRequestAction ira = new InvalidRequestAction(invalidReasonList);
				InvalidRequestEvent ire = new InvalidRequestEvent(ira);
				onInvalidRequest(ire);
				eventBus.fireEvent(ire);
			}
		}
	}
	
	public void onInvalidRequest(InvalidRequestEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getSubmitButton().setEnabled(true);
		submitClickInProgress = false;
		
		InvalidRequestAction ira = evt.getAction();
		view.showErrorMessages(ira.toString());
	}
	
	private void sendRequest(String Description, String Requesttype)
	{
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendRequestAction sra = new SendRequestAction(Description, Requesttype);
		SendRequestEvent sre = new SendRequestEvent(sra, container);
		eventBus.fireEvent(sre);
	}
	
	public void onReceiveUserClickRequestTab(ReceiveUserClickRequestTabEvent evt) {
		this.go(mainPresenter.getRequestPanel());
		
		ReceiveClickUserRequestTabAction action = evt.getAction();
		populateRequestList(action.getRequestList());
		
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
	public void populateRequestList(List<Request> requestList) {
		view.setRequestHistoryList(requestList);
		
	}

}
