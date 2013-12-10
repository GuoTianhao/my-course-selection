package com.logic.timeControllerImpl;

import java.util.Calendar;

//要有存入数据库的io
public class SystemPeriod {
	public SystemPeriod() {

	}

	private static Calendar termOneStartDay;
	private static Calendar termOneEndDay;
	private static Calendar winterStartDay;
	private static Calendar winterEndDay;
	private static Calendar termTwoStartDay;
	private static Calendar termTwoEndDay;
	private static Calendar summerStartDay;
	private static Calendar summerEndDay;

	public static Calendar getTermOneStartDay() {
		return termOneStartDay;
	}

	public static Calendar getTermOneEndDay() {
		return termOneEndDay;
	}

	public static Calendar getWinterStartDay() {
		return winterStartDay;
	}

	public static Calendar getWinterEndDay() {
		return winterEndDay;
	}

	public static Calendar getTermTwoStartDay() {
		return termTwoStartDay;
	}

	public static Calendar getTermTwoEndDay() {
		return termTwoEndDay;
	}

	public static Calendar getSummerStartDay() {
		return summerStartDay;
	}

	public static Calendar getSummerEndDay() {
		return summerEndDay;
	}

	public static void setTermOneStartDay(Calendar termOneStartDay) {
		SystemPeriod.termOneStartDay = termOneStartDay;
	}

	public static void setTermOneEndDay(Calendar termOneEndDay) {
		SystemPeriod.termOneEndDay = termOneEndDay;
	}

	public static void setWinterStartDay(Calendar winterStartDay) {
		SystemPeriod.winterStartDay = winterStartDay;
	}

	public static void setWinterEndDay(Calendar winterEndDay) {
		SystemPeriod.winterEndDay = winterEndDay;
	}

	public static void setTermTwoStartDay(Calendar termTwoStartDay) {
		SystemPeriod.termTwoStartDay = termTwoStartDay;
	}

	public static void setTermTwoEndDay(Calendar termTwoEndDay) {
		SystemPeriod.termTwoEndDay = termTwoEndDay;
	}

	public static void setSummerStartDay(Calendar summerStartDay) {
		SystemPeriod.summerStartDay = summerStartDay;
	}

	public static void setSummerEndDay(Calendar summerEndDay) {
		SystemPeriod.summerEndDay = summerEndDay;
	}

	public static boolean isInPeriod(Calendar time, Calendar start, Calendar end) {
		if (time.after(start) && time.before(end)) {
			return true;
		} else {
			return false;
		}
	}

}
