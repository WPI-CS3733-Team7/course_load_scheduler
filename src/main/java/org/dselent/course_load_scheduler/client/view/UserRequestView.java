package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.UserRequestPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.ListBox;

public interface UserRequestView extends BaseView<UserRequestPresenter>{
	
		RadioButton getCourseRdo();
		void setCourseRdo(RadioButton courseRdo);
		RadioButton getOtherRdo();
		void setOtherRdo(RadioButton otherRdo);
		Button getRequestButton();
		ListBox getRequestHistoryList();
		void setRequestHistoryList(ListBox requestHistoryList);
		public void showErrorMessages(String errorMessages);
}
