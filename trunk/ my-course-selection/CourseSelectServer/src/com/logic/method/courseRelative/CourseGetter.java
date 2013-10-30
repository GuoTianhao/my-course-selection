package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.data.po.Teacher;
import com.logic.dataController.DatabaseController;
import com.logic.method.TeacherRelative.TeacherGetter;

public class CourseGetter {
	private static List<String> getAimName() {
		List<String> aimName = new ArrayList<String>();
		aimName.add("ID");
		aimName.add("Name");
		aimName.add("Loc");
		aimName.add("Type");
		aimName.add("Grade");
		aimName.add("Period");
		aimName.add("faculty");
		aimName.add("script");
		aimName.add("Num");
		return aimName;
	}

	// 为课程加入老师和时间
	private static Course courseFactory(Course c) {
		ArrayList<String> aimName = new ArrayList<String>();
		ArrayList<String> clueName = new ArrayList<String>();
		ArrayList<String> clue = new ArrayList<String>();
		// 获取课程老师
		aimName.add("Teacher");
		clueName.add("ID");
		clue.add(c.getID());

		List<ArrayList<String>> res = DatabaseController.getMethod()
				.search("courseTeacher", clueName, clue, aimName);
		clueName.clear();
		clue.clear();

		List<Teacher> teacher = new ArrayList<Teacher>();
		clueName.add("ID");
		Iterator<ArrayList<String>> it = res.iterator();
		while (it.hasNext()) {
			ArrayList<String> innerList = it.next();
			Iterator<String> inIt = innerList.iterator();
			clue.add((String) inIt.next());
			teacher.add((TeacherGetter.getTeacher(clueName, clue)).get(0));
			clue.clear();
		}
		c.setTeacher(teacher);
		// 获取课程时间
		c.setTime(DatabaseController.getMethod().search("courseTime", "ID",
				c.getID(), "Time"));
		return c;
	}

	// 得到符合条件
	public static List<Course> getCourse(List<String> clueName,
			List<String> clue) {
		List<Course> list = new ArrayList<Course>();
		List<String> aimName = getAimName();
		List<ArrayList<String>> res = DatabaseController.getMethod()
				.search("course", clueName, clue, aimName);
		Iterator<ArrayList<String>> it = res.iterator();
		while (it.hasNext()) {
			ArrayList<String> innerList = it.next();
			Iterator<String> inIt = innerList.iterator();
			Course course = courseFactory(new Course(inIt.next(), inIt.next(),
					inIt.next(), inIt.next(), Integer.parseInt(inIt.next()),
					inIt.next(), inIt.next(), inIt.next(),Integer.parseInt(inIt.next()), null, null));
			list.add(course);

		}
		return list;
	}

	// 以院系编号为参数，得到该院系的课程
	public static List<Course> getFacultyCourse(String facultyID) {
		List<Course> list;
		List<String> clueName = new ArrayList<String>();
		clueName.add("faculty");
		List<String> clue = new ArrayList<String>();
		clue.add(facultyID);
		list = CourseGetter.getCourse(clueName, clue);
		return list;
	}

	// 以课程编号为参数，得到与编号对应课程
	public static Course getConcreteCourse(String courseID) {
		List<Course> list;
		List<String> clueName = new ArrayList<String>();
		clueName.add("ID");
		List<String> clue = new ArrayList<String>();
		clue.add(courseID);
		list = CourseGetter.getCourse(clueName, clue);
		Course c = null;
		if (list.size() != 0) {
			c = (Course) list.get(0);
		}
		return c;
	}
}
