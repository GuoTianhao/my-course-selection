package com.server.test;

import com.logic.method.courseRelative.CourseSelectAndQuit;

import junit.framework.TestCase;

public class CourseSelectTest extends TestCase{
	public void testSelectCourse(){
		System.out.println(CourseSelectAndQuit.quitCourse("121250041","0003"));
	}
}
