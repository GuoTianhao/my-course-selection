package com.server.start;

import com.logic.timeControllerImpl.TimeControllerMethodImpl;
import com.timeControllerService.TimeControllerController;

public class TimeInit {
	public static void init(){
		TimeControllerController.setMethod(new TimeControllerMethodImpl());
	}
}
