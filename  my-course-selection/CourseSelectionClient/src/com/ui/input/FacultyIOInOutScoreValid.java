package com.ui.input;

import com.ui.myswing.MTextField;

public class FacultyIOInOutScoreValid implements ValidInput{
	MTextField field;
	int cmd;

	public FacultyIOInOutScoreValid(MTextField field) {
		this.field = field;
	}

	public boolean isValid() {
		cmd = Integer.parseInt(field.getText());
		if ((cmd < 0) || (cmd > 5))
			return false;
		else
			return true;

	}
}
