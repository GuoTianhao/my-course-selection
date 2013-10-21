package com.logic.method.courseRelative;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;
import com.data.po.Course;
import com.data.po.Teacher;
import com.logic.dataController.DatabaseController;
import com.logic.dataController.FacultyDeanDataController;

public class CoursePublish {
	public static boolean publishCourse(Course c) {
		List<String> list = FacultyDeanDataController.getMethod().search(
				"course", "ID", c.getID(), "ID");
		Iterator<String> it = list.iterator();
		if (it.hasNext()) {
			return false;
		} else {
			addCourse(c);
			return true;
		}
	}

	private static void addCourse(Course c) {
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();

		clueName.add("ID");
		clueName.add("Name");
		clueName.add("Loc");
		clueName.add("type");
		clueName.add("Grade");
		clueName.add("Period");
		clueName.add("faculty");
		clueName.add("script");
		clue.add(c.getID());
		clue.add(c.getName());
		clue.add(c.getLoc());
		clue.add(c.getType());
		clue.add("" + c.getGrade());
		clue.add(c.getPeriod());
		clue.add(c.getFaculty());
		clue.add(c.getScript());
		FacultyDeanDataController.getMethod().insert("course", clueName, clue);

		Iterator it = (c.getTeacher()).iterator();
		List<String> teacher = new ArrayList<String>();
		while (it.hasNext()) {
			Teacher t = (Teacher) it.next();
			teacher.add(t.getID());
		}

		it = teacher.iterator();
		clueName.clear();
		clue.clear();
		clueName.add("ID");
		clueName.add("Teacher");
		String ID = c.getID();
		clue.add(ID);
		while (it.hasNext()) {
			clue.add((String) it.next());
			FacultyDeanDataController.getMethod().insert("courseTeacher",
					clueName, clue);
			clue.remove(1);
		}

		it = (c.getTime()).iterator();
		clueName.clear();
		clue.clear();
		clueName.add("ID");
		clueName.add("Time");
		clue.add(ID);
		while (it.hasNext()) {
			clue.add((String) it.next());
			FacultyDeanDataController.getMethod().insert("courseTime",
					clueName, clue);
			clue.remove(1);
		}
	}
}
