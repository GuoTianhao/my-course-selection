package com.ui.input;

import com.ui.myswing.MTextField;

public class FrameNameValid implements ValidInput{
	MTextField field;

	public FrameNameValid(MTextField field) {
		this.field = field;
	}

	public boolean isValid() {
		if (field.getText().length() > 20)
			return false;
		else
			return true;
	}

}
