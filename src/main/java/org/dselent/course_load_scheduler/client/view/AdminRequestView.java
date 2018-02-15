package org.dselent.course_load_scheduler.client.view;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

import org.dselent.course_load_scheduler.client.presenter.AdminRequestPresenter;

import com.google.gwt.user.client.ui.Button;

public interface AdminRequestView extends BaseView<AdminRequestPresenter>{
		ListBox getRequestList();
		void setRequestList(ListBox requestList);
		Label getUserRequestLabel();
		void setUserRequestLabel(Label setUserLabel);
		Label getTypeLabel();
		void setTypeLabel(Label setTypeLabel);
		Label getRequesterDescriptLabel();
		void setRequesterDescriptLabel(Label setDescriptLabel);
		TextArea getReplyTextArea();
		void setReplyTextArea(TextArea replyTextArea);
		Button getReplyButton();
		public void showErrorMessages(String errorMessages);
}
