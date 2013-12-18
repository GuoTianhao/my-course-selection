package com.ui.bcswing.titleBar;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.basicdata.Identity;
import com.data.po.Dean;
import com.ui.bcswing.passwordChangePane.DeanPasswordChangePane;

public class DeanTitlebar extends TitleBar{
	private Dean identity = (Dean) Identity.getIdentity();
	public DeanTitlebar(Point loc, Dimension size) {
		super(loc, size);
//		super.setMessage(identity.getName());
		addListener();
	}

	private void addListener(){
		addPasswordChangeListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeanPasswordChangePane();
			}
			
		});
	}
}
