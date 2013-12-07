package com.logic.method.studentRelative.selectStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.dataService.DatabaseMethod;
import com.logic.dataController.DatabaseController;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseStudentNumGetter;
import com.logic.method.studentRelative.CourseSelectAndQuit;
import com.logic.method.studentRelative.strategy.Ballot;

public class ElectiveCourseSelectStategy implements SelectStrategy {

	public void startSelect() {
		DatabaseMethod method = DatabaseController.getMethod();
		List<Course> list = CourseGetter.getTypeCourse("F");
		Iterator<Course> it = list.iterator();
		while (it.hasNext()) {
			Course c = it.next();
			List<String> student = method.search("courseStudentWait", "ID",
					c.getID(), "Student");
			student = Ballot.ballot((ArrayList) student, c.getNum()
					- CourseStudentNumGetter.getCourseStudentNum(c.getID()));
			method.delete("courseStudentWait", "ID", c.getID());
			Iterator<String> studentID = student.iterator();
			while (studentID.hasNext()) {
				CourseSelectAndQuit.selectCourse(studentID.next(), c.getID(),
						false);
			}
		}
	}

	public static void main(String[] args) {
		new ElectiveCourseSelectStategy().startSelect();
	}

}
