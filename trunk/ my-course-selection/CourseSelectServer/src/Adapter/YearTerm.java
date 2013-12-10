package Adapter;

import java.util.Calendar;

import com.logic.timeControllerImpl.SystemPeriod;
import com.logic.timeControllerImpl.TimeControllerMethodImpl;

public class YearTerm {
	public static String getNowYearTerm() {
		return getYearTerm(TimeControllerMethodImpl.getSystemTime());
	}

	public static String getNextYearTerm() {
		StringBuilder now = new StringBuilder(getNowYearTerm());
		if (now.charAt(4) == '0') {
			return SystemPeriod.getTermTwoStartDay().get(Calendar.YEAR) + "1";
		} else
			return SystemPeriod.getTermTwoStartDay().get(Calendar.YEAR) + "0";
	}

	public static String getYearTerm(Calendar c) {
		if (SystemPeriod.isInPeriod(c, TimeControllerMethodImpl.addDay(
				SystemPeriod.getTermOneStartDay(), -1),
				TimeControllerMethodImpl.addDay(SystemPeriod.getWinterEndDay(),
						1))) {
			return SystemPeriod.getTermOneStartDay().get(Calendar.YEAR) + "0";
		} else
			return SystemPeriod.getTermTwoStartDay().get(Calendar.YEAR) + "1";
	}
}
