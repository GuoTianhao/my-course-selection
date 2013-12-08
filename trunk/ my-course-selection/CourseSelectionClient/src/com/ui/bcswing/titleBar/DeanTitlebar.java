package com.ui.bcswing.titleBar;

import java.awt.Dimension;
import java.awt.Point;

import com.basicdata.Identity;
import com.data.po.Dean;

public class DeanTitlebar extends TitleBar{
	private Dean identity = (Dean) Identity.getIdentity();
	public DeanTitlebar(Point loc, Dimension size) {
		super(loc, size);
//		super.setMessage(identity.getName());
	}
}
