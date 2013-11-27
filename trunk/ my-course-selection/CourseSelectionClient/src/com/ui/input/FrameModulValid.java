package com.ui.input;

import com.ui.myswing.MTextField;

public class FrameModulValid implements ValidInput {
	MTextField field;
	int cmd1, cmd2;

	public FrameModulValid(MTextField field) {
		this.field = field;
	}

	public boolean isValid() {
		String[] getString = field.getText().split("_");
		if (getString.length == 2) {
			cmd1 = Integer.parseInt(getString[0]);
			cmd2 = Integer.parseInt(getString[1]);
			if (cmd1 >= cmd2)
				return false;
			else
				return true;
		}

		else
			return false;
	}
}
