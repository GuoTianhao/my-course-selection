package com.ui.input;

import com.ui.myswing.MTextField;

public class RecordScoreValid implements ValidInput {
	MTextField field;
	int cmd;

	public RecordScoreValid(MTextField field) {
		this.field = field;
	}

	public boolean isValid() {
		cmd = Integer.parseInt(field.getText());
		if ((cmd < 0) || (cmd > 100))
			return false;
		else
			return true;
	}
}
