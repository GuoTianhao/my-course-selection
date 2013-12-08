package com.logic.method.studentRelative;

import com.logic.method.studentRelative.bySelectStrategy.CourseBySelectStrategy;


public class CourseBySelect {
	public static boolean bySelectCourse(String ID, String cID) {
		return CourseBySelectStrategy.selectCourse(ID, cID);
	}
}
