package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

public class FrameDisplayTable extends MScrollTabel {
	private static final String[] c = { "课程模块", "课程性质", "序列", "课程类别",  "建议学分",
			"开设学期" };

	public FrameDisplayTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
