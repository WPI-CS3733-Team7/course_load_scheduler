package org.dselent.course_load_scheduler.client.view;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.RadioButton;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.Request;
import org.dselent.course_load_scheduler.client.presenter.AdminRequestPresenter;

import com.google.gwt.user.client.ui.Button;

public interface AdminRequestView extends BaseView<AdminRequestPresenter>{
		Request getRequest(int index);
		ListBox getRequestList();
		void setRequestList(ListBox requestList);
		void setRequestList(List<Request> requests);
		Label getUserRequestLabel();
		void setUserRequestLabel(String requester);
		Label getTypeLabel();
		void setTypeLabel(String requestType);
		Label getRequesterDescriptLabel();
		void setRequesterDescriptLabel(String requestDetail);
		TextArea getReplyTextArea();
		void setReplyTextArea(String text);
		RadioButton getApproved();
		void setApproved(RadioButton approvedRdo);
		RadioButton getTentative();
		void setTentative(RadioButton tentativeRdo);
		RadioButton getRejected();
		void setRejected(RadioButton rejectedRdo);
		Button getReplyButton();
		public void showErrorMessages(String errorMessages);
}
