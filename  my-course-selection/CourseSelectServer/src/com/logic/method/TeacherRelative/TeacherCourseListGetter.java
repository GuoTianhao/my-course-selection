package com.logic.method.TeacherRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.logic.dataController.TeacherDataController;
import com.logic.method.courseRelative.CourseGetter;

public class TeacherCourseListGetter {
	public static List<Course> getCourseList(String ID){
		List<String> list;
		List<Course> courseList=new ArrayList<Course>();
		list=TeacherDataController.getMethod().search("courseTeacher","Teacher",ID,"ID");
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			courseList.add(CourseGetter.getConcreteCourse(it.next()));
		}
		return courseList;
	}
}
