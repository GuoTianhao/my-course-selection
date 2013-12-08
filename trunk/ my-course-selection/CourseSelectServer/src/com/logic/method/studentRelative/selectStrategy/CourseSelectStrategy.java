package com.logic.method.studentRelative.selectStrategy;

import Adapter.YearTerm;

import com.data.po.Course;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseStudentNumGetter;
import com.logic.method.studentRelative.CourseSelect;

public class CourseSelectStrategy {

	public static boolean selectCourse(String ID, String cID) {
		Course c = CourseGetter.getConcreteCourse(cID);
		switch (c.getType()) {
		case "G":
			return PESelectStrategy.selectCourse(ID, cID);
		default:
			return CourseSelect.selectCourseToWait(ID, cID);
		}
	}

}
