package com.logic.method.deanRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Adapter.IntegerToStringAdapter;

import com.data.po.Course;
import com.dataService.DeanDatabaseMethod;
import com.logic.dataController.DeanDataController;
import com.logic.method.courseRelative.CoursePublish;

public class DeanPublishCourse {
	public static boolean publishCourse(Course c) {
//		DeanDatabaseMethod method = DeanDataController.getMethod();
//		String ID = method.getMax("course", "ID");
//		int max;
//		max = Integer.parseInt(ID);
		switch(c.getType()){
		case "A":case "G":
			return publishAllShareCourse(c);
		default:
			return publishAllUniqueCourse(c);
		}
	}
	
	public static boolean publishAllShareCourse(Course c){
		DeanDatabaseMethod method = DeanDataController.getMethod();
		String ID = method.getMax("course", "ID");
		int max;
		max = Integer.parseInt(ID);
		ID = IntegerToStringAdapter.convert((++max));
		c.setID(ID);
		c.setFaculty("0000");
		return CoursePublish.publishCourse(c);
	}
	
	public static boolean publishAllUniqueCourse(Course c){
		DeanDatabaseMethod method = DeanDataController.getMethod();
		String ID = method.getMax("course", "ID");
		int max;
		max = Integer.parseInt(ID);
		ID = IntegerToStringAdapter.convert((++max));
		c.setID(ID);
		c.setFaculty("0000");
		if (!CoursePublish.publishCourse(c)) {
			return false;
		}
		List<String> list = method.search("faculty", null, null, "ID");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			ID = IntegerToStringAdapter.convert((++max));
			c.setID(ID);
			c.setFaculty(it.next());
			if (!CoursePublish.publishCourse(c)) {
				return false;
			}
		}
		return true;
	}
}
