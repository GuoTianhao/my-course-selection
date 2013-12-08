package com.logic.method.studentRelative.selectStrategy;

import java.util.ArrayList;
import java.util.List;

import Adapter.YearTerm;

import com.data.po.Course;
import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseStudentNumGetter;
import com.logic.method.studentRelative.CourseSelect;

public class PESelectStrategy {
	public static boolean selectCourse(String ID, String cID) {
		Course c = CourseGetter.getConcreteCourse(cID);
		if (isSelectable(ID, cID)) {
			return CourseSelect.selectCourseToReal(ID, cID,
					YearTerm.getNextYearTerm());
		}
		return false;
	}

	private static boolean isSelectable(String ID, String cID) {
		Course c = CourseGetter.getConcreteCourse(cID);
		if (CourseStudentNumGetter.getCourseStudentNum(cID,
				YearTerm.getNextYearTerm()) >= c.getNum()) {
			return false;
		}

		StudentDatabaseMethod method=StudentDataController.getMethod();
		if(method.isSelectPE(ID, YearTerm.getNextYearTerm())){
			return false;
		}
		return true;
	}
}
