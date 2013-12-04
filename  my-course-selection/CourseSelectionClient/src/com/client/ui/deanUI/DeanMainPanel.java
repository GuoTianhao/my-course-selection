package com.client.ui.deanUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.client.ui.main.MainFrame;
import com.client.ui.main.MainUISwitchController;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class DeanMainPanel extends MPanel {
	private TitleBar title;
	private MButton btn1;
	private MButton btn2;
	private MButton btn3;
	private MButton btn4;
	private MButton btn5;
	private MButton btn6;

	DeanUISwitchController controller;

	public DeanMainPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		title = new DeanTitlebar(new Point(0, 0),
				new Dimension(this.getWidth(), 75));

		btn1 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				85, 134), new Dimension(180, 150));
		btn1.setText("整体框架策略");
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn2 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				323, 134), new Dimension(180, 150));
		btn2.setText("教学计划");
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn3 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				535, 134), new Dimension(180, 150));
		btn3.setText("课程");
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn4 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				85, 344), new Dimension(180, 150));
		btn4.setText("教师");
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn4.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn5 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				323, 344), new Dimension(180, 150));
		btn5.setText("学生");
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn5.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn6 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				535, 344), new Dimension(180, 150));
		btn6.setText("专业准入准出");
		btn6.setHorizontalTextPosition(SwingConstants.CENTER);
		btn6.setVerticalTextPosition(SwingConstants.BOTTOM);

		this.add(title);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
	}

	private void addListener() {
		controller = DeanUISwitchController.getUISwitchController();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanMainPanel.this.controller.switchToBasicFramePanel();
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanMainPanel.this.controller.switchToFacultyPlanPanel();
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanMainPanel.this.controller.switchToCoursePanel();
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanMainPanel.this.controller.switchToStudentPanel();
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanMainPanel.this.controller.switchToTeacherPanel();
			}
		});
		btn6.addActionListener(new ActionListener() {
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
		DeanUISwitchController controller = DeanUISwitchController
				.getUISwitchController();
		controller.swicthToMainFrame();
	}
}
