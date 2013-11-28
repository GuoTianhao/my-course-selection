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
	public static List<Course> getCourseList(String ID){
		StudentDatabaseMethod method=StudentDataController.getMethod();
		
		String grade = method.search("student", "ID", ID, "Grade").get(0);
		int term = GradeToTermAdapter.adapter(Integer.parseInt(grade));

		List<Course> courseList=new ArrayList<Course>();
		//选修课程
		List<String> list;
		list=method.search("courseStudent","Student",ID,"ID");
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			Course c=CourseGetter.getConcreteCourse(it.next());
			c.setGrade(term);
			courseList.add(c);
		}
		//专业课程
		list.clear();
		list=method.search("student", "ID",ID,"Faculty");
		String faculty=list.get(0);
		list.clear();
		list=method.search("course","faculty",faculty, "ID");
		it=list.iterator();
		while(it.hasNext()){
			courseList.add(CourseGetter.getConcreteCourse(it.next()));
		}
		
		//通识课程
		courseList.addAll(CourseGetter.getTypeCourse("A"));
		
		return courseList;
	}
}
