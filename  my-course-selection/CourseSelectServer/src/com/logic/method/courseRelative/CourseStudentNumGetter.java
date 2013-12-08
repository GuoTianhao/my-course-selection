package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.List;

import com.dataService.DatabaseMethod;
import com.logic.dataController.DatabaseController;
import com.logic.method.studentRelative.StudentGetter;

public class CourseStudentNumGetter {

	public static int getCourseStudentNum(String cID, String yearTerm) {
		DatabaseMethod method = DatabaseController.getMethod();
		String type = method.search("course", "ID", cID, "type").get(0);
		switch (type) {
		case "B":
		case "C":
		case "D":
		case "L":
			return getFacultyRelativeCourseStudentNum(cID, yearTerm);
		case "E":
			return getFacultyRelativeCourseStudentNum(cID, yearTerm)
					+ getImcompulsoryCourseStudentNum(cID, yearTerm);
		default:
			return getImcompulsoryCourseStudentNum(cID, yearTerm);
		}
	}

	public static int getCourseSelectStudentNum(String cID, String yearTerm) {
		return getCourseStudentNum(cID, yearTerm)
				+ getWaitCourseStudentNum(cID);
	}

	public static int getFacultyRelativeCourseStudentNum(String cID,
			String yearTerm) {
		int num = 0;
		DatabaseMethod method = DatabaseController.getMethod();
		String faculty = method.search("course", "ID", cID, "faculty").get(0);
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("Faculty");
		clue.add(faculty);
		num = method.getNum("student", clueName, clue);
		num += getImcompulsoryCourseStudentNum(cID, yearTerm);
		return num;
	}

	public static int getImcompulsoryCourseStudentNum(String cID,
			String yearTerm) {
		int num;
		DatabaseMethod method = DatabaseController.getMethod();
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("ID");
		clueName.add("time");
		clue.add(cID);
		clue.add(yearTerm);
		num = method.getNum("courseStudent", clueName, clue);
		return num;
	}

	public static int getWaitCourseStudentNum(String cID) {
		int num;
		DatabaseMethod method = DatabaseController.getMethod();
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("ID");
		clue.add(cID);
		num = method.getNum("courseStudentWait", clueName, clue);
		return num;

	}
}
