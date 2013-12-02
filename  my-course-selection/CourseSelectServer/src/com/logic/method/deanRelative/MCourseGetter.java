package com.logic.method.deanRelative;

import java.util.List;

import com.data.po.Course;
import com.logic.method.courseRelative.CourseGetter;

public class MCourseGetter {
	public static List<Course> getMCourse(){
		
		return CourseGetter.getFacultyCourse("0000");
	}
}
