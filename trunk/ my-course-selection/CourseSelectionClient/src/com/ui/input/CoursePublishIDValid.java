package com.ui.input;

import com.ui.myswing.MTextField;

public class CoursePublishIDValid implements ValidInput {
	MTextField field;

	public CoursePublishIDValid(MTextField field) {
		this.field = field;
	}

	public boolean isValid() {
		if (field.getText().length() == 9)
			return true;
		else
			return false;
	}
}
