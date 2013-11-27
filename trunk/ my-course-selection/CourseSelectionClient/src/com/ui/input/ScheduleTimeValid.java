package com.ui.input;

import com.ui.myswing.MTextField;

public class ScheduleTimeValid implements ValidInput{
	MTextField field;
	int cmd1, cmd2, cmd3;

	public ScheduleTimeValid(MTextField field) {
		this.field = field;
	}

	public boolean isValid() {
		String[] getString = field.getText().split("_");
		if (getString.length == 3) {
			cmd1 = Integer.parseInt(getString[0]);
			cmd2 = Integer.parseInt(getString[1]);
			cmd3 = Integer.parseInt(getString[2]);
			if ((cmd2 >= cmd3) || (cmd2 < 1) || (cmd3 > 11) || (cmd1 < 1)
					|| (cmd1 > 7))
				return false;
			else
				return true;
		}

		else
			return false;
	}
}
