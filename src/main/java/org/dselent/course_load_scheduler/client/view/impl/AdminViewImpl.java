package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Button;

public class AdminViewImpl extends Composite {

	private static AdminViewImplUiBinder uiBinder = GWT.create(AdminViewImplUiBinder.class);
	@UiField Label lblRequester;
	@UiField Label lblType;
	@UiField Label lblDescript;
	@UiField RadioButton rdoApproved;
	@UiField RadioButton rdoTentative;
	@UiField RadioButton rdoRejected;
	@UiField Button btnReply;

	interface AdminViewImplUiBinder extends UiBinder<Widget, AdminViewImpl> {
	}

	public AdminViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
