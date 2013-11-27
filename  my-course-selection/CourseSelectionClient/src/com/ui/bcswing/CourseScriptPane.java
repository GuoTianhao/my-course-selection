package com.ui.bcswing;

import java.awt.Dimension;

import com.data.po.Course;
import com.ui.myswing.MFrame;
//教师完善课程信息框
public class CourseScriptPane extends MFrame{
	private static Dimension default_size=new Dimension(550, 500);
	private Course course;
	public CourseScriptPane(Dimension size) {
		super(size);
		createComponent();
	}
	
	public CourseScriptPane(Course c){
		this(default_size);
		setCourse(c);
	}
	
	private void createComponent(){
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void setCourse(Course c){
		course=c;
	}
	
	public String getScript(){
		return "";
	}
}
