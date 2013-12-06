package com.logic.timeControllerImpl;

import java.util.Calendar;

//要有存入数据库的io
public class SystemPeriod {
	public SystemPeriod() {

	}

	private Calendar termOneStartDay;
	private Calendar termOneEndDay;
	private Calendar winterStartDay;
	private Calendar winterEndDay;
	private Calendar termTwoStartDay;
	private Calendar termTwoEndDay;
	private Calendar summerStartDay;
	private Calendar summerEndDay;

	public Calendar getTermOneStartDay() {
		return termOneStartDay;
	}

	public Calendar getTermOneEndDay() {
		return termOneEndDay;
	}

	public Calendar getWinterStartDay() {
		return winterStartDay;
	}

	public Calendar getWinterEndDay() {
		return winterEndDay;
	}

	public Calendar getTermTwoStartDay() {
		return termTwoStartDay;
	}

	public Calendar getTermTwoEndDay() {
		return termTwoEndDay;
	}

	public Calendar getSummerStartDay() {
		return summerStartDay;
	}

	public Calendar getSummerEndDay() {
		return summerEndDay;
	}

	public void setTermOneStartDay(Calendar termOneStartDay) {
		this.termOneStartDay = termOneStartDay;
	}

	public void setTermOneEndDay(Calendar termOneEndDay) {
		this.termOneEndDay = termOneEndDay;
	}

	public void setWinterStartDay(Calendar winterStartDay) {
		this.winterStartDay = winterStartDay;
	}

	public void setWinterEndDay(Calendar winterEndDay) {
		this.winterEndDay = winterEndDay;
	}

	public void setTermTwoStartDay(Calendar termTwoStartDay) {
		this.termTwoStartDay = termTwoStartDay;
	}

	public void setTermTwoEndDay(Calendar termTwoEndDay) {
		this.termTwoEndDay = termTwoEndDay;
	}

	public void setSummerStartDay(Calendar summerStartDay) {
		this.summerStartDay = summerStartDay;
	}

	public void setSummerEndDay(Calendar summerEndDay) {
		this.summerEndDay = summerEndDay;
	}

}
