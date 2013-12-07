package com.logic.method.studentRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Adapter.GradeToTermAdapter;
import Adapter.YearTermToTermAdapter;

import com.data.po.Course;
import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;
import com.logic.method.courseRelative.CourseGetter;

public class StudentCourseListGetter {
	// type为选定或待定

	public static List<Course> getMCourseList(String ID) {
		StudentDatabaseMethod method = StudentDataController.getMethod();

		List<Course> courseList = new ArrayList<Course>();
		// 选修课程
		courseList = getMImcompulsoryCourseList(ID, "courseStudent");
		// 专业课程
		List<String> list = new ArrayList<String>();
		list = method.search("student", "ID", ID, "Faculty");
		String faculty = list.get(0);

		courseList.addAll(CourseGetter.getFacultyTypeCourse(faculty, "E"));

		return courseList;
	}

	public static List<Course> getMWaitedCourseList(String ID) {
		StudentDatabaseMethod method = StudentDataController.getMethod();
		int grade = Integer.parseInt(method
				.search("student", "ID", ID, "Grade").get(0));
		List<Course> courseList = new ArrayList<Course>();

		List<String> list = method.search("courseStudentWait", "Student", ID,
				"ID");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			Course c = CourseGetter.getConcreteCourse(it.next());
			c.setGrade(GradeToTermAdapter.adapter(grade));
			courseList.add(c);
		}
		return courseList;
	}
	

	public static List<Course> getMImcompulsoryCourseList(String ID,
			String tableName) {
		StudentDatabaseMethod method = StudentDataController.getMethod();
		int grade = Integer.parseInt(method
				.search("student", "ID", ID, "Grade").get(0));

		List<Course> courseList = new ArrayList<Course>();

		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		List<String> aimName = new ArrayList<String>();
		clueName.add("Student");
		clue.add(ID);
		aimName.add("ID");
		aimName.add("time");

		List<ArrayList<String>> list = method.search(tableName, clueName, clue,
				aimName);
		Iterator<ArrayList<String>> it = list.iterator();
		ArrayList<String> innerList;
		Iterator<String> innerIt;
		while (it.hasNext()) {
			innerList = it.next();
			innerIt = innerList.iterator();
			Course c = CourseGetter.getConcreteCourse(innerIt.next());
			c.setGrade(YearTermToTermAdapter.adapter(innerIt.next(), grade));
			courseList.add(c);
		}
		return courseList;
	}
}
