package com.server.start;

import com.logic.timeControllerImpl.TimeControllerImpl;
import com.timeControllerService.TimeControllerController;

public class TimeInit {
	public static void init(){
		TimeControllerController.setMethod(new TimeControllerImpl());
	}
}
