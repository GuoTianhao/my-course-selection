package com.logic.method.TeacherRelative;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.data.po.Student;
import com.logic.method.courseRelative.CourseStudentGetter;
import com.logic.method.studentRelative.StudentScoreGetter;

public class CourseStudentScoreGetter {
	public static Map<Student,Integer> ScoreGetter(String cID) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		List<Student> list = CourseStudentGetter.getCourseStudent(cID);
		Iterator<Student> it = list.iterator();
		Student student;
		int score;
		while (it.hasNext()) {
			student=it.next();
			score=StudentScoreGetter.getScore(student.getID(), cID);
			map.put(student, score);
		}
		return map;
	}
}
