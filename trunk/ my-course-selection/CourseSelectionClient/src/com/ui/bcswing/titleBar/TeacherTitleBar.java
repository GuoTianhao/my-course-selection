package com.ui.bcswing.titleBar;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.basicdata.Identity;
import com.data.po.Teacher;
import com.ui.bcswing.passwordChangePane.TeacherPasswordChangePane;

public class TeacherTitleBar extends TitleBar {
	Teacher identity = (Teacher) Identity.getIdentity();

	public TeacherTitleBar(Point loc, Dimension size) {
		super(loc, size);
		super.setMessage(identity.getName());
		addListener();
	}

	private void addListener(){
		addPasswordChangeListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TeacherPasswordChangePane();
			}
			
		});
	}

}
