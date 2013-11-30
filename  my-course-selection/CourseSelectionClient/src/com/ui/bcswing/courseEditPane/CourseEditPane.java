package com.ui.bcswing.courseEditPane;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.data.po.Course;
import com.ui.bcswing.MScrollForm;

public class CourseEditPane extends MScrollForm {
	Dimension default_size = new Dimension(550, 500);
	protected CourseEditPanel courseEdit;

	public CourseEditPane() {
		super();
		this.setSize(default_size);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addComponent();
	}

	public CourseEditPane(Dimension size) {
		super(size);
		addComponent();
	}

	private void addComponent() {
		courseEdit = new CourseEditPanel(new Point(0, 0), this.getSize());
		courseEdit.addObserver(this);
		this.addContent(courseEdit);
		this.refresh();
		this.setVisible(true);

	}

	public void setCourse(Course c) {
		courseEdit.setCourse(c);
	}

	public Course getCourse() {
		return courseEdit.getCourse();
	}

	public void addConfirmListener(ActionListener al) {
		courseEdit.addConfirmListener(al);
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new CourseEditPane();
	}
}
