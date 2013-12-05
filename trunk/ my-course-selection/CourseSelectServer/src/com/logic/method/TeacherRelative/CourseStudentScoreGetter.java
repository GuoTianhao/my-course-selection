package com.logic.method.TeacherRelative;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.data.po.Student;
import com.logic.method.courseRelative.CourseStudentGetter;
import com.logic.method.studentRelative.StudentScoreGetter;

public class CourseStudentScoreGetter {
	public static Map<Student, String> ScoreGetter(String cID) {
		Map<Student, String> map = new HashMap<Student, String>();
		List<Student> list = CourseStudentGetter.getCourseStudent(cID);
		Iterator<Student> it = list.iterator();
		Student student;
		String score;
		while (it.hasNext()) {
			student=it.next();
			score=String.valueOf(StudentScoreGetter.getScore(student.getID(), cID));
			map.put(student, score);
		}
		return map;
	}
}
