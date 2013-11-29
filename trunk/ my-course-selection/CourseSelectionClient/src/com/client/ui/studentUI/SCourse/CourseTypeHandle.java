package com.client.ui.studentUI.SCourse;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToFacultyAdapter;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;

public class CourseTypeHandle {
	public static List<Course> handle(String type) {
		StudentMethod method = StudentMethodController.getMethod();

		List<Course> list = new ArrayList<Course>();

		Student student = (Student) Identity.getIdentity();

		switch (type) {
		case "选修课程":
			try {
				list = method.getTypeCourse("F");
				list = CourseListToFacultyAdapter.adapter(list,
						student.getFaculty());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			break;
		case "通识课程":
			try {
				list = method.getTypeCourse("A");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case "跨院系课程":
			try {
				list = method.getTypeCourse("E");
				list.addAll(method.getTypeCourse("F"));
				list = CourseListToFacultyAdapter.adapterRverse(list,
						student.getFaculty());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			break;
		}
		return list;
	}
}
