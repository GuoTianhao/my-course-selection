package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Adapter.YearTerm;

import com.data.po.Student;
import com.dataService.DatabaseMethod;
import com.logic.dataController.DatabaseController;
import com.logic.method.studentRelative.StudentGetter;

public class CourseStudentGetter {
	public static List<Student> getCourseStudent(String cID) {
		return getCourseStudent(cID, YearTerm.getNowYearTerm());
	}

	public static List<Student> getCourseStudent(String cID, String yearTerm) {
		DatabaseMethod method = DatabaseController.getMethod();
		List<Student> sList = new ArrayList<Student>();
		List<String> typeL=method.search("course", "ID", cID, "type");
		if(typeL.size()==0){
			return sList;
		}
		String type = method.search("course", "ID", cID, "type").get(0);
		switch (type) {
		case "B":
		case "C":
		case "D":
		case "E":
		case "L":
			String faculty = method.search("course", "ID", cID, "faculty").get(
					0);
			sList = StudentGetter.getFacultyStudent(faculty);
			sList.addAll(getImcompulsoryCourseStudent(cID, yearTerm));
			return sList;
		default:
			return getImcompulsoryCourseStudent(cID, yearTerm);
		}
	}

	public static List<Student> getImcompulsoryCourseStudent(String cID,
			String yearTerm) {
		List<Student> sList = new ArrayList<Student>();

		DatabaseMethod method = DatabaseController.getMethod();

		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		List<String> aimName = new ArrayList<String>();
		clueName.add("ID");
		clueName.add("time");
		clue.add(cID);
		clue.add(yearTerm);
		aimName.add("Student");
		List<ArrayList<String>> list = method.search("courseStudent", clueName, clue,
				aimName);
		Iterator<ArrayList<String>> it = list.iterator();
		while (it.hasNext()) {
			Student t = StudentGetter.getConcreteStudent((it.next()).get(0));
			sList.add(t);
		}
		return sList;
	}

}
