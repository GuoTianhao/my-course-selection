package com.server.test;

import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.logic.method.TeacherRelative.TeacherCourseListGetter;

import junit.framework.TestCase;

public class TeacherCourseListGetterTest extends TestCase{
	public void testGetCourseList(){
		List<Course> list=TeacherCourseListGetter.getCourseList("100000000");
		Iterator<Course> it=list.iterator();
		while(it.hasNext()){
			Course c=it.next();
			System.out.println("Name: "+c.getName()+" Faculty: "+c.getFaculty());
		}
	}
}
