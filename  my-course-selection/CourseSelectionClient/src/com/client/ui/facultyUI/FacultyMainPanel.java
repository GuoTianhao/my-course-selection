package com.client.ui.facultyUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class FacultyMainPanel extends MPanel{
	private TitleBar title;
	private MButton btn1;
	private MButton btn2;
	private MButton btn3;
	
	FacultyUISwitchController controller;
	
	public FacultyMainPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
		addListener();
	}
	
	private void createComponent() {
		title = new TitleBar(new Point(0, 0),
				new Dimension(this.getWidth(), 75));

		btn1 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				85, 134), new Dimension(180, 150));
		btn1.setText("教学计划");
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn2 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				323, 134), new Dimension(180, 150));
		btn2.setText("课程");
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		btn3 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				535, 134), new Dimension(180, 150));
		btn3.setText("专业准入准出");
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		this.add(title);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
	}
	
	private void addListener(){
		controller = FacultyUISwitchController.getUISwitchController();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyMainPanel.this.controller.switchToTeachingPlanPanel();;
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyMainPanel.this.controller.switchToCourseManagementPanel();;
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacultyUISwitchController controller = FacultyUISwitchController.getUISwitchController();
		controller.swicthToMainFrame();
	}

}
