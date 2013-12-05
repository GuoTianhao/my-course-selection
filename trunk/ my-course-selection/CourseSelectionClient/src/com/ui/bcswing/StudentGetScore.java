package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

public class StudentGetScore extends MScrollTable{
	private static final String[] c = {"课程编号","名称","类型","学分","成绩" };

	public StudentGetScore(Point loc, Dimension size) {
		super(loc, size);
		this.setColumnIdentifiers(getColumn());
	}

	private String[] getColumn() {
		return c;
	}
}