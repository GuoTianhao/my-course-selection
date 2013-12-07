package com.timeControllerService;



public class TimeControllerController {
	private static TimeController time = null;
	public static TimeController getMethod() {
		return time;
	}
	public static void setMethod(TimeController t){
		time=t;
	}
}
