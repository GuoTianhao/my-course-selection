package com.ui.bcswing.titleBar;

import java.awt.Dimension;
import java.awt.Point;

import com.basicdata.Identity;
import com.data.po.Student;

public class StudentTitleBar extends TitleBar {
	private Student identity = (Student) Identity.getIdentity();

	public StudentTitleBar(Point loc, Dimension size) {
		super(loc, size);
		super.setMessage(identity.getName());
	}

}
