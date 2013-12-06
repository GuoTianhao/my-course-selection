package com.client.ui.dataAdapter;

import java.util.List;

import com.basicdata.Identity;
import com.data.po.Course;
import com.data.po.Student;

public class StudentCourseToCourseTypeListAdapter {
	public static List<Course> adapter(List<Course> list,String type){
		Student student = (Student) Identity.getIdentity();
		switch (type) {
		case "专业选修课":
			list = CourseListToCourseTypeListAdapter.adapter(list,
					"F");
			list = CourseListToCourseTermListAdapter.adapter(list,
					GradeToTermAdapter.adapter(student.getGrade()));
			list=CourseListToFacultyAdapter.adapter(list,
					student.getFaculty());
			break;
		case "通识教育课程":
			list = CourseListToCourseTypeListAdapter.adapter(list,
					"A");
			break;
		case "体育课":
			list = CourseListToCourseTypeListAdapter.adapter(list,
					"G");
			break;
		case "跨院系课程":
			List<Course> temp=CourseListToCourseTypeListAdapter.adapter(list,
					"E");
			list = CourseListToCourseTypeListAdapter.adapter(list,
					"F");
			list.addAll(temp);
			list = CourseListToFacultyAdapter.adapterRverse(list,
					student.getFaculty());
			break;
		}
		return list;

	}
}
