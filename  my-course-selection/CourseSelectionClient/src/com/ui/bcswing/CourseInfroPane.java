package com.ui.bcswing;

import java.awt.Dimension;

import com.data.po.Course;
import com.ui.myswing.MFrame;
//显示具体的课程信息
public class CourseInfroPane extends MFrame{
	private static Dimension default_size=new Dimension(550, 500);
	private Course course;
	public CourseInfroPane(Dimension size) {
		super(size);
		createComponent();
		init();
	}
	public CourseInfroPane(Course c){
		this(default_size);
		setCourse(c);
	}
	private void createComponent(){
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void init(){
		
	}
	
	public void setCourse(Course c){
		course=c;
	}
	
}
