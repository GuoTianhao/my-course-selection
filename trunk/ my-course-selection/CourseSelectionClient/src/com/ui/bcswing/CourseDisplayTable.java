package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Vector;

public class CourseDisplayTable extends MScrollTable {
	private static final String[] c = { "课程编号","课程模块",
			"课程名称", "学分", "开设学期" };

	public CourseDisplayTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
