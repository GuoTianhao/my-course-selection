package com.ui.bcswing.courseEditPane;

public class DeanCoursePane extends CourseEditPane{
	public DeanCoursePane(){
		String[] typeModel = { "通识教育课程", "思想政治理论课程" ,"军事课程","通修课程"};
		courseEdit.setTypeModel(typeModel);
	}
}
