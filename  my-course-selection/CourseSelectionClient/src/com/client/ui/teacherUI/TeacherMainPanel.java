package com.client.ui.teacherUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.ui.bcswing.titleBar.TeacherTitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class TeacherMainPanel extends MPanel {
	private TeacherTitleBar title;
	private MButton btn1;

	TeacherUISwitchController controller;

	public TeacherMainPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		title = new TeacherTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		btn1 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				85, 134), new Dimension(180, 150));
		btn1.setText("我的课程");
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);

		this.add(title);
		this.add(btn1);
	}

	private void addListener() {
		controller = TeacherUISwitchController.getUISwitchController();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherMainPanel.this.controller.switchToCourseManagement();
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
		TeacherUISwitchController controller = TeacherUISwitchController.getUISwitchController();
		controller.switchToMainFrame();
	}

}
