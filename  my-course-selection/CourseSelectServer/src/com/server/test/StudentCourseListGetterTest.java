package com.server.test;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.data.po.Course;
import com.logic.method.studentRelative.StudentCourseListGetter;

public class StudentCourseListGetterTest extends TestCase{
	public void testGetCourseList(){
		List<Course> list=StudentCourseListGetter.getMCourseList("121250041");
		Iterator<Course> it=list.iterator();
		while(it.hasNext()){
			System.out.println("Course Name:"+it.next().getName());
		}
	}
}
