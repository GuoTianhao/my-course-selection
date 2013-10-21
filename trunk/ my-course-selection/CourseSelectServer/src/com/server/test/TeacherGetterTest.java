package com.server.test;

import com.data.po.Teacher;
import com.logic.method.TeacherRelative.TeacherGetter;

import junit.framework.TestCase;

public class TeacherGetterTest extends TestCase{
	public void testTeacherGetter(){
		Teacher t=TeacherGetter.getConcreteTeacher("100000001");
		System.out.println(t.getName());
	}
}
