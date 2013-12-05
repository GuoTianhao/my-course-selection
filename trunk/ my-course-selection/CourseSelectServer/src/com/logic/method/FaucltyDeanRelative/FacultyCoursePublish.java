package com.logic.method.FaucltyDeanRelative;

import Adapter.IntegerToStringAdapter;

import com.data.po.Course;
import com.dataService.FacultyDeanDatabaseMethod;
import com.logic.dataController.FacultyDeanDataController;
import com.logic.method.courseRelative.CoursePublish;

public class FacultyCoursePublish {
	public static boolean publishCourse(String faculty,Course c) {
		FacultyDeanDatabaseMethod method=FacultyDeanDataController.getMethod();
		String ID= method.getMax("course","ID");
		int max=Integer.parseInt(ID);
		ID=IntegerToStringAdapter.convert((++max));
		c.setID(ID);
		c.setFaculty(faculty);
		return CoursePublish.publishCourse(c);
	}
}
