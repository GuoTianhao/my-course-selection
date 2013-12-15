package com.logic.timeControllerImpl;

import java.util.Calendar;
import java.util.Date;

import com.data.dataImpl.method.dean.TimeGetter;

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

	public static void setTermOneStartDay(Date termOneStartDay) {
		SystemPeriod.termOneStartDay.setTime(termOneStartDay);;
	}

	public static void setTermOneEndDay(Date termOneEndDay) {
		SystemPeriod.termOneEndDay.setTime(termOneEndDay);
	}

	public static void setWinterStartDay(Date winterStartDay) {
		SystemPeriod.winterStartDay.setTime(winterStartDay);
	}

	public static void setWinterEndDay(Date winterEndDay) {
		SystemPeriod.winterEndDay.setTime(winterEndDay);
	}

	public static void setTermTwoStartDay(Date termTwoStartDay) {
		SystemPeriod.termTwoStartDay.setTime(termTwoStartDay);
	}

	public static void setTermTwoEndDay(Date termTwoEndDay) {
		SystemPeriod.termTwoEndDay.setTime(termTwoEndDay);
	}

	public static void setSummerStartDay(Date summerStartDay) {
		SystemPeriod.summerStartDay.setTime(summerStartDay);
	}

	public static void setSummerEndDay(Date summerEndDay) {
		SystemPeriod.summerEndDay.setTime(summerEndDay);
	}

	public static boolean isInPeriod(Calendar time, Calendar start, Calendar end) {
		if (time.after(start) && time.before(end)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void init() {
		setTermOneStartDay(TimeGetter.getTime("1"));
		setTermOneEndDay(TimeGetter.getTime("2"));
		setWinterStartDay(TimeGetter.getTime("3"));
		setWinterEndDay(TimeGetter.getTime("4"));
		setTermTwoStartDay(TimeGetter.getTime("5"));
		setTermTwoEndDay(TimeGetter.getTime("6"));
		setSummerStartDay(TimeGetter.getTime("7"));
		setSummerEndDay(TimeGetter.getTime("8"));
	}

}
