package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidRequestAction;
import org.dselent.course_load_scheduler.client.action.SendRequestAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidSubmitStrings;
import org.dselent.course_load_scheduler.client.event.InvalidRequestEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.UserRequestPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.UserRequestView;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class UserRequestPresenterImpl extends BasePresenterImpl implements UserRequestPresenter{
	private IndexPresenter parentPresenter;
	private UserRequestView view;
	private boolean submitClickInProgress;
	
	@Inject
	public UserRequestPresenterImpl(IndexPresenter parentPresenter, UserRequestView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
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
		/*HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidRequestEvent.TYPE, this);
		eventBusRegistration.put(InvalidRequestEvent.TYPE, registration); */
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
			
			String description = view.getDescriptionTextArea().getText();
			
			boolean validRequesttype = true;

			List<String> invalidReasonList = new ArrayList<>();
			
			try
			{
				validateField(description);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidSubmitStrings.NULL_REQUESTTYPE);
				validRequesttype = false;
			}
			
			if(validRequesttype)
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
	
	public void onInvalidRequest(InvalidRequestEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getSubmitButton().setEnabled(true);
		submitClickInProgress = false;
		
		InvalidRequestAction ira = evt.getAction();
		view.showErrorMessages(ira.toString());
	}
	
	private void sendRequest(String Requesttype)
	{
		SendRequestAction sra = new SendRequestAction(Requesttype);
		SendRequestEvent sre = new SendRequestEvent(sra);
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
	

}
