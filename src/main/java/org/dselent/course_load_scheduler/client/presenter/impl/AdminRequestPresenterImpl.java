package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidReplyAction;
import org.dselent.course_load_scheduler.client.action.SendReplyAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidRequestStrings;
import org.dselent.course_load_scheduler.client.event.InvalidReplyEvent;
import org.dselent.course_load_scheduler.client.event.InvalidRequestEvent;
import org.dselent.course_load_scheduler.client.event.SendReplyEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.AdminRequestPresenter;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserRequestPresenter;
import org.dselent.course_load_scheduler.client.view.AdminRequestView;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.UserRequestView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AdminRequestPresenterImpl extends BasePresenterImpl implements AdminRequestPresenter{
	private IndexPresenter parentPresenter;
	private AdminRequestView view;
	private boolean replyClickInProgress;
	
	@Inject
	public AdminRequestPresenterImpl(IndexPresenter parentPresenter, AdminRequestView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		replyClickInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void go(HasWidgets container) {
	
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidReplyEvent.TYPE, this);
		eventBusRegistration.put(InvalidReplyEvent.TYPE, registration);
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
			
			String description = view.getReplyTextArea().getText();
			String approved = view.getApproved().getText();
			String tentative = view.getTentative().getText();
			String rejected = view.getRejected().getText();
			
			boolean validDescription = true;
			boolean validReplyType = true;
			
			List<String> invalidReasonList= newArrayList<>();
			
			try {
				validateField(description);
			}
		}
	}

	/*@Override
	public void submit() {
		// TODO Auto-generated method stub
		if(!submitClickInProgress)
		{
			submitClickInProgress = true;
			view.getSubmitButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			
			String description = view.getDescriptionText().getText();
			String courseType = view.getCourseRdo().getText();
			String otherType = view.getOtherRdo().getText();
			
			
			boolean validRequest = true;
			boolean validDescription = true;
			
			List<String> invalidReasonList = new ArrayList<>();
			
			try
			{
				validateField(description);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidRequestStrings.NULL_DESCRIPTION);
				
				validDescription = false;
			}
			
			if(validDescription)
			{
				sendRequest(description);
			}
			else
			{
				InvalidRequestAction ira = new InvalidRequestAction(invalidReasonList);
				InvalidRequestEvent ire = new InvalidRequestEvent(ira);
				eventBus.fireEvent(ire);
			}
		}
	}
	private void sendRequest(String description)
	{
		SendRequestAction sra = new SendRequestAction(description);
		SendRequestEvent sre = new SendRequestEvent(sra);
		eventBus.fireEvent(sre);
	}*/
	
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
}
