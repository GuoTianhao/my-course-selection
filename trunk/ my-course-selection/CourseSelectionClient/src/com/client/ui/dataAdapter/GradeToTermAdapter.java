package com.client.ui.dataAdapter;

import java.util.Calendar;

public class GradeToTermAdapter {
	public static int adapter(int grade) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int term = 0;
		if ((year == grade) || ((year - grade == 1) && (month <= 1))) {
			term = 1;
		} else if ((year - grade == 1) && (month <= 8)) {
			term = 2;
		} else if (((year - grade == 1) && (month > 8))
				|| ((year - grade == 2) && (month <= 1))) {
			term = 3;
		} else if ((year - grade == 2) && (month <= 8)) {
			term = 4;
		} else if (((year - grade == 2) && (month > 8))
				|| ((year - grade == 3) && (month <= 1))) {
			term = 5;
		} else if ((year - grade == 3) && (month <= 8)) {
			term = 6;
		} else if (((year - grade == 3) && (month > 8))
				|| ((year - grade == 4) && (month <= 1))) {
			term = 7;
		} else if ((year - grade == 4) && (month <= 8)) {
			term = 8;
		} else {
			term = -1;
		}
		return term;
	}

}
