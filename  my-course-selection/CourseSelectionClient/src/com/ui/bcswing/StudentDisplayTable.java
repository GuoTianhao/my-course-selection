package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

public class StudentDisplayTable extends MScrollTabel {
	private static final String[] c = {"学号","姓名","院系","年级" };

	public StudentDisplayTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
