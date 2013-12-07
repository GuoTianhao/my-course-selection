package com.logic.method.studentRelative;

import java.util.ArrayList;
import java.util.List;

import Adapter.YearTerm;

import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;

import com.logic.method.studentRelative.selectStrategy.CourseSelectStrategy;

public class CourseSelect {
	public static boolean selectCourse(String ID, String cID) {
		return CourseSelectStrategy.selectCourse(ID, cID);
	}

	public static boolean selectCourseToWait(String ID, String cID) {
		String tableName;
		tableName = "courseStudentWait";
		StudentDatabaseMethod method = StudentDataController.getMethod();
		if (!(isSelected(ID, cID))) {
			List<String> clueName = new ArrayList<String>();
			List<String> clue = new ArrayList<String>();
			clueName.add("ID");
			clueName.add("Student");
			clue.add(cID);
			clue.add(ID);
			method.insert(tableName, clueName, clue);
			return true;
		} else {
			return false;
		}
	}

	public static boolean selectCourseToReal(String ID, String cID) {
		String tableName;
		tableName = "courseStudent";
		StudentDatabaseMethod method = StudentDataController.getMethod();
		int grade = Integer.parseInt(method
				.search("student", "ID", ID, "Grade").get(0));
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Student");
		clueName.add("time");
		clue.add(cID);
		clue.add(ID);
		clue.add(YearTerm.getNowYearTerm());
		method.insert(tableName, clueName, clue);
		return true;
	}

	private static boolean isSelected(String ID, String cID) {
		String tableName;
		tableName = "courseStudentWait";
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		List<String> aimName = new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Student");
		clue.add(cID);
		clue.add(ID);
		aimName.add("ID");
		List res = StudentDataController.getMethod().search(tableName,
				clueName, clue, aimName);
		if (res.size() != 0) {
			return true;
		}
		return false;
	}

}
