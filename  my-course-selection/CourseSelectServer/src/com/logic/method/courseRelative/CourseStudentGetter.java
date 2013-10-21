package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Student;
import com.logic.dataController.DatabaseController;
import com.logic.method.studentRelative.StudentGetter;

public class CourseStudentGetter {
	public static List<Student> getCourseStudent(String cID) {
		List<Student> sList = new ArrayList<Student>();
		List<String> list = DatabaseController.getMethod().search(
				"courseStudent", "ID", cID, "Student");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			Student t = StudentGetter.getConcreteStudent((String) (it.next()));
			sList.add(t);
		}
		return sList;
	}
}
