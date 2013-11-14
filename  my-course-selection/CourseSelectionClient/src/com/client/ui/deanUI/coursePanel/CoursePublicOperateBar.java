package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class CoursePublicOperateBar extends MPanel {
	private MButton courseP;
	private MButton courseM;
	private MButton courseInfor;

	private MTextField search;
	private MButton searchBtn;

	public CoursePublicOperateBar(Point loc, Dimension size) {
		super(loc, size);
		creatComponent();
	}

	private void creatComponent() {
		courseP = new MButton(null, null, null, new Point(0, 0), null);
		courseM = new MButton(null, null, null, new Point(110, 0), null);
		courseInfor = new MButton(null, null, null, new Point(220, 0), null);

		courseP.setText("发布新课程");
		courseM.setText("修改课程");
		courseInfor.setText("课程详细信息");

		search = new MTextField(new Point(650, 0), new Dimension(100, 30));
		searchBtn = new MButton(null, null, null, new Point(755, 0),
				new Dimension(30, 30));

		this.add(courseP);
		this.add(courseM);
		this.add(courseInfor);

		this.add(search);
		this.add(searchBtn);
	}

	public void addCoursePListener(ActionListener al) {
		courseP.addActionListener(al);
	}

	public void addcourseMListener(ActionListener al) {
		courseM.addActionListener(al);
	}

	public void addcourseInforListener(ActionListener al) {
		courseInfor.addActionListener(al);
	}
}
