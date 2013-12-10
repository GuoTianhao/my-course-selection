package Adapter;

import java.util.Calendar;

import com.logic.timeControllerImpl.SystemPeriod;

public class GradeToYearTermAdapter {
	public static String adapter(int grade) {
		if (grade % 2 != 0) {
			return SystemPeriod.getTermOneStartDay().get(Calendar.YEAR) + "0";
		} else {
			return SystemPeriod.getTermTwoStartDay().get(Calendar.YEAR) + "1";
		}
	}
}
