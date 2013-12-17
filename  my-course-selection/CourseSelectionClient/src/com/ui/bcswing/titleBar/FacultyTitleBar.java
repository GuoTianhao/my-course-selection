package com.ui.bcswing.titleBar;

import java.awt.Dimension;
import java.awt.Point;

import com.basicdata.Identity;
import com.data.po.FacultyDean;

public class FacultyTitleBar extends TitleBar{
	private FacultyDean identity = (FacultyDean) Identity.getIdentity();
	public FacultyTitleBar(Point loc, Dimension size) {
		super(loc, size);
		super.setMessage(identity.getName());
	}

}
