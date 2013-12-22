package com.system.courseSelectStrategy;

import java.util.List;

import com.dataService.DatabaseMethod;
import com.logic.dataController.DatabaseController;

public class SystemCourseSelect {
	public static void startSelect(){
		new ElectiveCourseSelectStategy().startSelect();
		new LiberalCourseSelectStrategy().startSelect();
		new OtherFacultyCourseSelectStrategy().startSelect();
		new PECourseSelectStrategy().startSelect();
		DatabaseMethod method=DatabaseController.getMethod();
		List<String> clueName=null;
		List<String> clue=null;
		method.delete("courseStudentWait", clueName,clue );
	}
}
