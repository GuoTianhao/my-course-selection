package com.logic.method.studentRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.logic.dataController.StudentDataController;
import com.logic.method.courseRelative.CourseGetter;

public class StudentCourseListGetter {
	public static List<Course> getCourseList(String ID){
		List<String> list;
		List<Course> courseList=new ArrayList<Course>();
		list=StudentDataController.getMethod().search("courseStudent","Student",ID,"ID");
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			courseList.add(CourseGetter.getConcreteCourse(it.next()));
		}
		return courseList;
	}
}
