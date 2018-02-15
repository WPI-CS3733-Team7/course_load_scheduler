package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.model.Instructor;
import org.dselent.course_load_scheduler.client.model.Model;

import com.google.gwt.user.client.ui.Button;

public class ModelButton<T extends Model> extends Button {

	private T model;
	
	ModelButton(T data){
		super();
		model = data;
		this.setText(model.displayText());
	}

	public T getModel() {
		return model;
	}

	public void setModel(T data) {
		model = data;
	}
	
}
