package com.client.ui.deanUI.studentPanel;

import java.awt.Dimension;
import java.awt.Point;

import com.ui.bcswing.MScrollTable;

public class StudentIOTable extends MScrollTable{
	private static final String[] c = {"学号","姓名","入学年份" };

	public StudentIOTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
