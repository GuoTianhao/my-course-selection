package com.logic.method.courseRelative;

import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.logic.dataController.DatabaseController;

public class CourseUpdate {
	public static boolean updateCourse(Course c) {
		List<String> list = DatabaseController.getMethod().search("course",
				"ID", c.getID(), "ID");
		Iterator<String> it = list.iterator();
		if (it.hasNext()) {
			update(c);
			return true;
		} else {
			return false;
		}
	}

	public static void update(Course c) {
		String ID = c.getID();
		DatabaseController.getMethod().delete("course", "ID", ID);
		DatabaseController.getMethod().delete("courseTime", "ID", ID);
		DatabaseController.getMethod().delete("courseTeacher", "ID", ID);
		CoursePublish.publishCourse(c);
	}
}
