package com.ui.bcswing.courseEditPane;

public class FacultyCoursePane extends CourseEditPane{
	public FacultyCoursePane(){
		String[] typeModel = { "专业选修课","专业必修课"};
		courseEdit.setTypeModel(typeModel);
	}
}
