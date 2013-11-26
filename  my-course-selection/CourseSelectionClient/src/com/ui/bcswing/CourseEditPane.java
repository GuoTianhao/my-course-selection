package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import com.data.po.Course;

public class CourseEditPane extends MScrollForm{
	Dimension default_size=new Dimension(550, 500);
	public CourseEditPane(){
		super();
		this.setSize(default_size);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addComponent();
	}
	public CourseEditPane(Dimension size) {
		super(size);
		addComponent();
	}
	private void addComponent(){
		CourseEditPanel courseEdit;
		courseEdit = new CourseEditPanel(new Point(0, 0),this.getSize());
		courseEdit.addObserver(this);
		
		this.addContent(courseEdit);
		this.refresh();
		this.setVisible(true);

	}
	public void setCourse(Course c){
		
	}
	public Course getCourse(){
		return null;
	}

}
