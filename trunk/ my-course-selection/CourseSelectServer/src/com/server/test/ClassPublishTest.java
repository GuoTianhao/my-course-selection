package com.server.test;

import java.util.ArrayList;
import java.util.List;

import com.data.po.Course;
import com.data.po.Teacher;
import com.dataService.DeanDatabaseMethod;
import com.logic.dataController.DeanDataController;
import com.logic.method.FaucltyDeanRelative.FacultyCoursePublish;
import com.logic.method.TeacherRelative.TeacherGetter;
import com.logic.method.courseRelative.CoursePublish;
import com.logic.method.deanRelative.DeanPublishCourse;

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
		Course c=new Course(null,"软件工程与计算","仙2_303","B",3,"1_17","1250","打造全院最好软件教育",0,3, null, null);
		System.out.println(DeanPublishCourse.publishCourse(c));
//		DeanDatabaseMethod method=DeanDataController.getMethod();
//		List<String> list;
//		list=method.search("faculty",null,null,"ID");
		
	}
}
