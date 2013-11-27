package com.ui.bcswing;

import java.awt.Dimension;

import com.data.po.Course;
import com.ui.myswing.MFrame;
//教师完善课程信息框
public class CourseScriptPane extends MFrame{
	private static Dimension default_size=new Dimension(550, 500);
	public CourseScriptPane(Dimension size) {
		super(size);
		createComponent();
	}
	public CourseScriptPane(){
		this(default_size);
	}
	private void createComponent(){
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setCourse(Course c){
		
	}
	public String getScript(){
		return "";
	}
}
