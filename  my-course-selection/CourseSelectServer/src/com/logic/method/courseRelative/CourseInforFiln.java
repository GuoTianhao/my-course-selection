package com.logic.method.courseRelative;

import java.rmi.RemoteException;

import com.data.po.Course;

public class CourseInforFiln {
	public static boolean filnCourseInfor(String cID, String text)  {
		Course c=CourseGetter.getConcreteCourse(cID);
		c.setScript(text);
		CourseUpdate.updateCourse(c);
		return true;
	}
}
