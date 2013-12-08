package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

public class BySelectCourseTable extends MScrollTable {
	private static final String[] c = { "课程编号","课程名称","上课地点","上课时间", "学分","剩余人数" };

	public BySelectCourseTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}

}
