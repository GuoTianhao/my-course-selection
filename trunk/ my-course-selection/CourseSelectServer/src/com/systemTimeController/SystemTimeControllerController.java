package com.systemTimeController;


public class SystemTimeControllerController {
	private static SystemTimeController time = null;
	public static SystemTimeController getMethod() {
		return time;
	}
	public static void setMethod(SystemTimeController t){
		time=t;
	}

}
