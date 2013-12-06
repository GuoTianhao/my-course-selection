package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.List;

import com.dataService.DatabaseMethod;
import com.logic.dataController.DatabaseController;
import com.logic.method.studentRelative.StudentGetter;

public class CourseStudentNumGetter {
	public static int getCourseStudentNum(String cID) {
		DatabaseMethod method = DatabaseController.getMethod();
		String type = method.search("course", "ID", cID, "type").get(0);
		switch (type) {
		case "B":
		case "C":
		case "D":
		case "E":
		case "L":
			return getFacultyRelativeCourseStudentNum(cID);
		default:
			return getImcompulsoryCourseStudentNum(cID);
		}
	}

	public static int getFacultyRelativeCourseStudentNum(String cID) {
		int num = 0;
		DatabaseMethod method = DatabaseController.getMethod();
		String faculty = method.search("course", "ID", cID, "faculty").get(0);
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("Faculty");
		clue.add(faculty);
		num = method.getNum("student", clueName, clue);
		num += getImcompulsoryCourseStudentNum(cID);
		return num;
	}

	public static int getImcompulsoryCourseStudentNum(String cID) {
		int num;
		DatabaseMethod method = DatabaseController.getMethod();
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("ID");
		clue.add(cID);
		num = method.getNum("courseStudent", clueName, clue);
		return num;
	}
}
