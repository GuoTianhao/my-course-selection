package com.logic.method.studentRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Adapter.GradeToTermAdapter;

import com.data.po.Course;
import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;
import com.logic.method.courseRelative.CourseGetter;

public class StudentCourseListGetter {
	// type为选定或待定

	public static List<Course> getMCourseList(String ID) {
		StudentDatabaseMethod method = StudentDataController.getMethod();

		String grade = method.search("student", "ID", ID, "Grade").get(0);
		int term = GradeToTermAdapter.adapter(Integer.parseInt(grade));

		List<Course> courseList = new ArrayList<Course>();
		// 选修课程
		courseList=getMImcompulsoryCourseList(ID,"courseStudent");
		// 专业课程
		List<String> list=new ArrayList<String>();
		list = method.search("student", "ID", ID, "Faculty");
		String faculty = list.get(0);
		
		courseList.addAll(CourseGetter.getFacultyTypeCourse(faculty,"E"));
		
		return courseList;
	}

	public static List<Course> getMWaitedCourseList(String ID) {
		return getMImcompulsoryCourseList(ID,"courseStudentWait");
	}
	
	public static List<Course> getMImcompulsoryCourseList(String ID,String tableName){
		StudentDatabaseMethod method = StudentDataController.getMethod();
		List<Course> courseList = new ArrayList<Course>();
		
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		List<String> aimName=new ArrayList<String>();
		clueName.add("Student");
		clue.add(ID);
		aimName.add("ID");
		aimName.add("Term");
		
		List<ArrayList<String>> list=method.search(tableName, clueName,clue, aimName);
		Iterator<ArrayList<String>> it = list.iterator();
		ArrayList<String> innerList;
		Iterator<String> innerIt;
		while (it.hasNext()) {
			innerList=it.next();
			innerIt=innerList.iterator();
			Course c = CourseGetter.getConcreteCourse(innerIt.next());
			c.setGrade(Integer.parseInt(innerIt.next()));
			courseList.add(c);
		}
		return courseList;
	}
}
