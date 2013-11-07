package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Vector;

public class CourseDisplayPanel extends MScrollTabel {
	public CourseDisplayPanel(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		String[] c = { "课程编号", "课程名称", "性质", "学分", "学时", "教师", "上课时间和地点" };
		return c;
	}
}
