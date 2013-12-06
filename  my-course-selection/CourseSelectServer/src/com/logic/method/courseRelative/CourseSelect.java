package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.List;

import Adapter.GradeToTermAdapter;

import com.data.dataImpl.DatabaseImpl;
import com.data.po.Course;
import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;

public class CourseSelect {
	public static boolean selectCourse(String ID, String cID) {
		StudentDatabaseMethod method = StudentDataController.getMethod();
		if (!(isSelected(ID, cID))) {
			List<String> clueName = new ArrayList<String>();
			List<String> clue = new ArrayList<String>();
			String grade = method.search("student", "ID", ID, "Grade").get(0);
			int term = GradeToTermAdapter.adapter(Integer.parseInt(grade));
			clueName.add("ID");
			clueName.add("Student");
			clueName.add("Term");
			clue.add(cID);
			clue.add(ID);
			clue.add(term + "");
			method.insert("courseStudentWait", clueName, clue);
			return true;
		} else {
			return false;
		}
	}

	public static boolean quitCourse(String ID, String cID) {
		if(!isQuitable(cID)){
			return false;
		}
		if (isSelected(ID, cID)) {
			List<String> clueName = new ArrayList<String>();
			List<String> clue = new ArrayList<String>();
			clueName.add("ID");
			clueName.add("Student");
			clue.add(cID);
			clue.add(ID);
			StudentDataController.getMethod().delete("courseStudentWait", clueName,
					clue);
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSelected(String ID, String cID) {
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		List<String> aimName = new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Student");
		clue.add(cID);
		clue.add(ID);
		aimName.add("ID");
		List res = StudentDataController.getMethod().search("courseStudentWait",
				clueName, clue, aimName);
		if (res.size() != 0) {
			return true;
		}
		{
			return false;
		}
	}

	public static boolean isQuitable(String courseID) {
		Course c = CourseGetter.getConcreteCourse(courseID);
		switch (c.getType()) {
		case "B":case "C":case "D":case "E":case "L":
			return false;
		}
		return true;
	}
}
