package com.logic.method.FaucltyDeanRelative;

import Adapter.IntegerToStringAdapter;

import com.data.po.Course;
import com.dataService.FacultyDeanDatabaseMethod;
import com.logic.dataController.FacultyDeanDataController;
import com.logic.method.courseRelative.CoursePublish;

public class FacultyCoursePublish {
	public static boolean publishCourse(Course c) {
		FacultyDeanDatabaseMethod method=FacultyDeanDataController.getMethod();
		String ID= method.getMax("course","ID");
		int max=Integer.parseInt(ID);
		ID=IntegerToStringAdapter.convert((++max));
		c.setID(ID);
		return CoursePublish.publishCourse(c);
	}
}
