package com.server.test;

import java.rmi.RemoteException;
import java.util.List;

import com.data.po.Student;
import com.logic.method.courseRelative.CourseStudentGetter;
import com.logic.studentImpl.StudentMethodImpl;
import com.logicService.StudentMethod;

import junit.framework.TestCase;

public class CourseStudentGetterTest extends TestCase{
	public void testStudentGetter(){
//		List<Student> list=CourseStudentGetter.getCourseStudent("0001");
//		Student s=list.get(1);
//		if(s==null){
//			System.out.println("null");
//		}else{
//			System.out.println("学生名字:"+s.getName());
//
//		}
		try {
			StudentMethod method=new StudentMethodImpl();
			int num;
			
			num=method.getCourseSelectNum("0006");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
