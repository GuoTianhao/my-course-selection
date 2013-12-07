package com.logic.method.studentRelative;

import java.util.ArrayList;
import java.util.List;

import com.data.po.Course;
import com.logic.dataController.StudentDataController;
import com.logic.method.courseRelative.CourseGetter;

public class CourseQuit {
	
	public static boolean quitCourse(String ID, String cID) {
		return quitCourse(ID, cID, false);
	}

	public static boolean quitSelectCourse(String ID, String cID) {
		return quitCourse(ID, cID, true);
	}
	protected static boolean quitCourse(String ID, String cID, boolean isWaited) {
		String tableName;
		if (isWaited) {
			tableName = "courseStudentWait";
		} else {
			tableName = "courseStudent";
		}
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Student");
		clue.add(cID);
		clue.add(ID);
		StudentDataController.getMethod().delete(tableName, clueName, clue);
		return true;

	}

	private static boolean isQuitable(String courseID) {
		Course c = CourseGetter.getConcreteCourse(courseID);
		switch (c.getType()) {
		case "B":
		case "C":
		case "D":
		case "E":
		case "L":
			return false;
		}
		return true;
	}

}
