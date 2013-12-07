package com.logic.method.studentRelative;

import java.util.ArrayList;
import java.util.List;

import Adapter.GradeToYearTermAdapter;

import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;

public class CourseSystemSelect {
	public static boolean selectCourse(String ID, String cID) {
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
		clue.add(GradeToYearTermAdapter.adapter(grade));
		method.insert(tableName, clueName, clue);
		return true;
	}
}
