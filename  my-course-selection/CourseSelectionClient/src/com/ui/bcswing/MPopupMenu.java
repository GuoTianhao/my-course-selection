package com.ui.bcswing;

import java.awt.Component;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;

public class MPopupMenu extends PopupMenu{
	private MenuItem teacher;
	protected Point point;
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
	public void show(Component origin, int x, int y){
		super.show(origin, x, y);
		point=new Point(x,y);
	}
	
	public Point getLocation(){
		return point;
	}
}
