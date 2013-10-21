package com.logic.method.TeacherRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Teacher;
import com.logic.dataController.DatabaseController;

public class TeacherGetter {
	private static List<String> getAimName() {
		List<String> aimName = new ArrayList<String>();
		aimName.add("ID");
		aimName.add("Name");
		aimName.add("Faculty");
		return aimName;
	}

	public static List<Teacher> getTeacher(List<String> clueName,
			List<String> clue) {
		List<Teacher> list = new ArrayList<Teacher>();
		List<String> aimName = getAimName();

		List<ArrayList<String>> res = DatabaseController.getMethod()
				.search("teacher", clueName, clue, aimName);
		Iterator<ArrayList<String>> it = res.iterator();
		while (it.hasNext()) {
			List<String> innerList = it.next();
			Iterator<String> inIt = innerList.iterator();
			list.add(new Teacher(inIt.next(), inIt.next(), inIt.next()));
		}
		return list;
	}

	public static List<Teacher> getFacultyTeacher(String facultyID) {
		List<Teacher> list;
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();

		clueName.add("Faculty");
		clue.add(facultyID);

		list = TeacherGetter.getTeacher(clueName, clue);
		return list;
	}

	public static Teacher getConcreteTeacher(String teacherID) {
		List<Teacher> list;
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();

		clueName.add("ID");
		clue.add(teacherID);

		list = TeacherGetter.getTeacher(clueName, clue);

		Teacher t = null;
		if (list.size() != 0) {
			t = (Teacher) list.get(0);
		}
		return t;
	}
}
