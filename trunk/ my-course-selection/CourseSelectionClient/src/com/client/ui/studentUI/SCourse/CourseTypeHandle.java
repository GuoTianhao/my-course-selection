package com.client.ui.studentUI.SCourse;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.basicdata.Identity;
import com.basicdata.StudentSelectCourseType;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToFacultyAdapter;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;

public class CourseTypeHandle {
	public static List<Course> handle(String type){
		StudentMethod method = StudentMethodController.getMethod();
		
		List<Course> list=new ArrayList<Course>();
		
		Student student=(Student) Identity.getIdentity();
		type = StudentSelectCourseType.getType(type);
		
		if (!type.equals("G")) {
			try {
				list = method.getTypeCourse(type);
				if (type.equals("F")) {
					list = CourseListToFacultyAdapter.adapter(list,
							student.getFaculty());
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				list = method.getTypeCourse("E");
				list.addAll(method.getTypeCourse("F"));
				list = CourseListToFacultyAdapter.adapterRverse(list,
						student.getFaculty());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
}
