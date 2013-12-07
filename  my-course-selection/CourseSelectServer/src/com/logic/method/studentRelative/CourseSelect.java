package com.logic.method.studentRelative;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;

public class CourseSelect {
	public static boolean selectCourse(String ID, String cID) {
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
