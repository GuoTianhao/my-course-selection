package com.server.test;

import com.logic.method.courseRelative.CourseSelect;

import junit.framework.TestCase;

public class CourseSelectTest extends TestCase{
	public void testSelectCourse(){
		System.out.println(CourseSelect.selectCourse("121250011","0001"));
	//	System.out.println(CourseSelect.quitCourse("121250041","0001"));
	}
}
