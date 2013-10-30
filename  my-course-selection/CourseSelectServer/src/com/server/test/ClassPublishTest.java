package com.server.test;

import java.util.ArrayList;
import java.util.List;

import com.data.po.Course;
import com.data.po.Teacher;
import com.logic.method.TeacherRelative.TeacherGetter;
import com.logic.method.courseRelative.CoursePublish;

import junit.framework.TestCase;

public class ClassPublishTest extends TestCase{
	public void testPublishClass(){
		List teacher=new ArrayList<Teacher>();
		List clueName=new ArrayList<String>();
		clueName.add("ID");
		List clue=new ArrayList<String>();
		clue.add("100000001");
		teacher.add(TeacherGetter.getTeacher(clueName, clue).get(0));
		clue.clear();
		clue.add("100000000");
		teacher.add(TeacherGetter.getTeacher(clueName, clue).get(0));
	//	Course c=new Course("0003","c++ Advanced","仙2_304","F",3,"1_17","1250",null,null,teacher);
		System.out.println();
	//	System.out.println(CoursePublish.publishCourse(c));
	}
}
