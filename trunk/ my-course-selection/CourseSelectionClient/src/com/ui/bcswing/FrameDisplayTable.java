package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

public class FrameDisplayTable extends MScrollTable {
	private static final String[] c = { "课程模块","建议学分",
			"开设学期" };

	public FrameDisplayTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
