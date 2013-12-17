package com.ui.bcswing.titleBar;

import java.awt.Dimension;
import java.awt.Point;

import com.basicdata.Identity;
import com.data.po.Teacher;

public class TeacherTitleBar extends TitleBar {
	Teacher identity = (Teacher) Identity.getIdentity();

	public TeacherTitleBar(Point loc, Dimension size) {
		super(loc, size);
		super.setMessage(identity.getName());
	}

}
