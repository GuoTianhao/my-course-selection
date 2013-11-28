package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

public class StudentUnselectedCourseDisplayTable extends MScrollTabel {
	private static final String[] c = { "课程编号", "名称", "学分","上课时间","上课周数" };

	public StudentUnselectedCourseDisplayTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
