package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Student;
import com.dataService.DatabaseMethod;
import com.logic.dataController.DatabaseController;
import com.logic.method.studentRelative.StudentGetter;

public class CourseStudentGetter {
	
	public static List<Student> getCourseStudent(String cID) {
		DatabaseMethod method = DatabaseController.getMethod();
		List<Student> sList = new ArrayList<Student>();
		String type = method.search("course", "ID", cID, "type").get(0);
		switch (type) {
		case "B":case "C":case "D":case "E":case "L":
			String faculty=method.search("course", "ID", cID, "faculty").get(0);
			return StudentGetter.getFacultyStudent(faculty);
		default:
			return getImcompulsoryCourseStudent(cID);
		}
	}
	
	public static List<Student> getImcompulsoryCourseStudent(String cID) {
		List<Student> sList = new ArrayList<Student>();
		
		DatabaseMethod method = DatabaseController.getMethod();
		List<String> list = method
				.search("courseStudent", "ID", cID, "Student");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			Student t = StudentGetter.getConcreteStudent((String) (it.next()));
			sList.add(t);
		}
		return sList;
	}
	
	
}
