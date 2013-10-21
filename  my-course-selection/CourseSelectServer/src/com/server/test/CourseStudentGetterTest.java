package com.server.test;

import java.util.List;

import com.data.po.Student;
import com.logic.method.courseRelative.CourseStudentGetter;

import junit.framework.TestCase;

public class CourseStudentGetterTest extends TestCase{
	public void testStudentGetter(){
		List<Student> list=CourseStudentGetter.getCourseStudent("0001");
		Student s=list.get(1);
		if(s==null){
			System.out.println("null");
		}else{
			System.out.println("学生名字:"+s.getName());

		}
	}
}
