package com.system.courseSelectStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Adapter.YearTerm;

import com.data.po.Course;
import com.dataService.DatabaseMethod;
import com.logic.dataController.DatabaseController;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseStudentNumGetter;
import com.logic.method.studentRelative.CourseSelect;
import com.logic.method.studentRelative.strategy.Ballot;

public class OtherFacultyCourseSelectStrategy implements SelectStrategy{

	public void startSelect() {
		// TODO Auto-generated method stub
		DatabaseMethod method = DatabaseController.getMethod();
		List<Course> list = CourseGetter.getTypeCourse("E");
		Iterator<Course> it = list.iterator();
		while (it.hasNext()) {
			Course c = it.next();
			List<String> student = method.search("courseStudentWait", "ID",
					c.getID(), "Student");
			student = Ballot.ballot((ArrayList) student, c.getNum()
					- CourseStudentNumGetter.getCourseStudentNum(c.getID(),YearTerm.getNowYearTerm()));
			method.delete("courseStudentWait", "ID", c.getID());
			Iterator<String> studentID = student.iterator();
			while (studentID.hasNext()) {
				CourseSelect.selectCourseToReal(studentID.next(), c.getID());
			}
		}
	}

}
