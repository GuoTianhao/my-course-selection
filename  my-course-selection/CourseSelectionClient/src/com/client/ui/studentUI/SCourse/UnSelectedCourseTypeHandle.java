package com.client.ui.studentUI.SCourse;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToCourseTermListAdapter;
import com.client.ui.dataAdapter.CourseListToFacultyAdapter;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.client.ui.dataAdapter.GradeToTermAdapter;
import com.client.ui.dataAdapter.StudentCourseToCourseTypeListAdapter;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;

public class UnSelectedCourseTypeHandle {
	public static List<Course> handle(String type) {
		StudentMethod method = StudentMethodController.getMethod();
		List<Course> list = new ArrayList<Course>();
		try {
			list = method.getTypeCourse("A");
			list.addAll(method.getTypeCourse("B"));
			list.addAll(method.getTypeCourse("C"));
			list.addAll(method.getTypeCourse("D"));
			list.addAll(method.getTypeCourse("E"));
			list.addAll(method.getTypeCourse("F"));
			list.addAll(method.getTypeCourse("G"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		list=StudentCourseToCourseTypeListAdapter.adapter(list, type);
		return list;
	}
}
