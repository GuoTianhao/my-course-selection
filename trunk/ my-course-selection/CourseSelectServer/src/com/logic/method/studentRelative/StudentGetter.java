package com.logic.method.studentRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Student;
import com.logic.dataController.DatabaseController;

public class StudentGetter {
	private static List<String> getAimName() {
		List<String> aimName = new ArrayList<String>();
		aimName.add("ID");
		aimName.add("Name");
		aimName.add("Faculty");
		aimName.add("Grade");
		return aimName;
	}

	public static List<Student> getStudent(List<String> clueName,
			List<String> clue) {
		List<Student> list = new ArrayList<Student>();
		List<String> aimName = getAimName();
		List<ArrayList<String>> res = DatabaseController.getMethod()
				.search("student", clueName, clue, aimName);
		Iterator<ArrayList<String>> it = res.iterator();
		while (it.hasNext()) {
			List<String> innerList = it.next();
			Iterator<String> inIt = innerList.iterator();
			Student st = new Student(inIt.next(), inIt.next(), inIt.next(),
					Integer.parseInt(inIt.next()));
			list.add(st);

		}
		return list;
	}

	public static List<Student> getFacultyStudent(String facultyID) {
		List<Student> list;
		List<String> clueName = new ArrayList<String>();
		clueName.add("Faculty");
		List<String> clue = new ArrayList<String>();
		clue.add(facultyID);
		list = StudentGetter.getStudent(clueName, clue);
		return list;
	}

	public static Student getConcreteStudent(String studentID) {
		List<Student> list;
		List<String> clueName = new ArrayList<String>();
		clueName.add("ID");
		List<String> clue = new ArrayList<String>();
		clue.add(studentID);
		list = StudentGetter.getStudent(clueName, clue);
		Student s = null;
		if (list.size() != 0) {
			s = (Student) list.get(0);
		}
		return s;
	}
}
