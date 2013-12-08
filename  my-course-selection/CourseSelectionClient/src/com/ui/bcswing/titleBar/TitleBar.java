package com.ui.bcswing.titleBar;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.client.ui.main.MainFrame;
import com.client.ui.main.MainUISwitchController;
import com.client.ui.studentUI.StudentUISwitchController;
import com.client.ui.teacherUI.TeacherUISwitchController;
import com.ui.myswing.MButton;
import com.ui.myswing.MFont;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class TitleBar extends MPanel{
	private MLabel message;
	private MButton logout;
	private MButton passwordChange;
	
	private MButton menu;
	
	public TitleBar(Point loc,Dimension size){
		super(loc,size);
		creatComponent();
		addListener();
	}
	private void creatComponent(){
		logout=new MButton(null,null,null,new Point(680,5),new Dimension(100,25));
		logout.setText("注销");
		passwordChange=new MButton(null,null,null,new Point(680,40),new Dimension(100,25));
		passwordChange.setText("修改密码");
		message=new MLabel(new Point(20,20),new Dimension(300,50));
		message.setText("Welcome, 韩旭！");
//		message.setFont(MFont.titleFont);
		
		menu=new MButton(null,null,null,new Point(15,40),new Dimension(100,30));
		menu.setText("主菜单");
		
		this.add(logout);
		this.add(passwordChange);
		this.add(message);
	}
	
	public void setMessage(String str) {
		message.setText("Welcome, "+str+"!");
	}
	private void addListener(){
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DeanUISwitchController.getUISwitchController().dispose();
				FacultyUISwitchController.getUISwitchController().dispose();
				TeacherUISwitchController.getUISwitchController().dispose();
				StudentUISwitchController.getUISwitchController().dispose();
				MainUISwitchController.getUISwitchController().switchToLoginPanel();
			}
			
		});
	}
	
	public void addReturnMenu(ActionListener al){
		this.add(menu);
		menu.addActionListener(al);
	}
	
	public void addLogoutListener(ActionListener al){
		logout.addActionListener(al);
	}
	
	public void addPasswordChangeListener(ActionListener al){
		passwordChange.addActionListener(al);
	}
	
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		MPanel p=new MPanel(f.getSize());
		p.add(new TitleBar(new Point(0,0),new Dimension(p.getSize().width,100)));
		f.add(p);
		f.refresh();
	}
	
}
