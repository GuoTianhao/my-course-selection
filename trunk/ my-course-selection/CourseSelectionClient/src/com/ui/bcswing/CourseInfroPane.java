package com.ui.bcswing;

import java.awt.Dimension;

import com.data.po.Course;
import com.ui.myswing.MFrame;

public class CourseInfroPane extends MFrame{
	private static Dimension default_size=new Dimension(550, 500);
	public CourseInfroPane(Dimension size) {
		super(size);
		createComponent();
	}
	public CourseInfroPane(){
		this(default_size);
	}
	private void createComponent(){
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setCourse(Course c){
		
	}
}
