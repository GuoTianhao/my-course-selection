package com.client.ui.studentUI.SCourse;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.basicdata.CourseTypeKind;
import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToCourseTermListAdapter;
import com.client.ui.dataAdapter.CourseListToCourseTypeListAdapter;
import com.client.ui.dataAdapter.CourseListToFacultyAdapter;
import com.client.ui.dataAdapter.GradeToTermAdapter;
import com.client.ui.dataAdapter.StudentCourseToCourseTypeListAdapter;
import com.client.ui.dataAdapter.StudentSelectedCourseListToVectorAdapter;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;

public class WaitCourseTypeHandle {
	public static List<Course> handle(String type) {
		List<Course> selected = new ArrayList<Course>();
		Student student = (Student) Identity.getIdentity();
		StudentMethod method = StudentMethodController.getMethod();
		try {
			selected = method.getWaitCourseList(student.getID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		selected = StudentCourseToCourseTypeListAdapter.adapter(selected, type);
		return selected;
	}
}
