package com.server.test;

import java.util.List;

import junit.framework.TestCase;

import com.data.po.Course;
import com.logic.method.studentRelative.StudentCourseListGetter;

public class StudentCourseListGetterTest extends TestCase{
	public void testGetCourseList(){
		List<Course> list=StudentCourseListGetter.getCourseList("121250041");
		Course course=list.get(0);
		System.out.println("Course Name:"+course.getName());
	}
}
