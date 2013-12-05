package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

public class TeacherDisplayTable extends MScrollTable{
	private static final String[] c = {"ID","姓名","院系" };

	public TeacherDisplayTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
