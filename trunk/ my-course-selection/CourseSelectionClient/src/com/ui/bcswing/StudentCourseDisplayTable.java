package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;


public class StudentCourseDisplayTable extends MScrollTabel {
	private static final String[] c = {"课程编号","名称","上课时间和地址" };

	public StudentCourseDisplayTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
