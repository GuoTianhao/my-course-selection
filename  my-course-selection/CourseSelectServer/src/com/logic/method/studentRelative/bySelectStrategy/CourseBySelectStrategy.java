package com.logic.method.studentRelative.bySelectStrategy;

import Adapter.YearTerm;

import com.data.po.Course;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseStudentNumGetter;
import com.logic.method.studentRelative.CourseSelect;

public class CourseBySelectStrategy {
	public static boolean selectCourse(String ID, String cID) {
		Course c = CourseGetter.getConcreteCourse(cID);
		if(c!=null){
			if (CourseStudentNumGetter.getCourseStudentNum(cID,
					YearTerm.getNowYearTerm()) < c.getNum()) {
				return CourseSelect.selectCourseToReal(ID, cID,
						YearTerm.getNowYearTerm());
			}	
		}
		return false;
	}
}
