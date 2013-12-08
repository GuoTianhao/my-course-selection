package com.client.ui.deanUI.teacherPanel;

import java.awt.Dimension;
import java.awt.Point;

import com.ui.bcswing.MScrollTable;

public class TeacherIOTable extends MScrollTable{
	private static final String[] c = {"工号","姓名"};

	public TeacherIOTable(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}
