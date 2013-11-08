package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;

import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CoursePublicOperateBar extends MPanel {
	private MButton courseP;
	private MButton courseM;
	private MButton courseInfor;

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

		this.add(courseP);
		this.add(courseM);
		this.add(courseInfor);
	}
}
