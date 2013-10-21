package com.server.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.data.po.Teacher;
import com.logic.method.courseRelative.CourseGetter;

import junit.framework.TestCase;

public class CourseGetterTest extends TestCase{
//	public void testGetConcreteCourse(){
//		Course c=CourseGetter.getConcreteCourse("0001");
//		System.out.println(c.getName());
//	}
	public void testGetFacultyCourse(){
		List<Course> list=CourseGetter.getFacultyCourse("1250");
		Iterator it=list.iterator();
		while(it.hasNext()){
			Course c=(Course) it.next();
			System.out.println("Course Name: "+c.getName());
		}

	}
}
