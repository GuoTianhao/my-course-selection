package com.client.ui.facultyUI.Course;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;

public class MPopupMenu extends PopupMenu{
	MenuItem teacher;
	public MPopupMenu(){
		createComponent();
	}
	private void createComponent(){
		teacher=new MenuItem();
		teacher.setLabel("指定老师");
		this.add(teacher);
	}
	public void addTeacherAssignmentListener(ActionListener al){
		teacher.addActionListener(al);
	}
}
