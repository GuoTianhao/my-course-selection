package com.client.ui.studentUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.GradeToTermAdapter;
import com.data.po.Student;
import com.timeControllerService.TimeController;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class StudentMainPanel extends MPanel {
	private TitleBar title;
	private MButton btn1;
	private MButton btn2;
	private MButton btn3;
	private MButton btn4;
	private MButton btn5;

	StudentUISwitchController controller;
	TimeController time;

	public StudentMainPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));

		btn1 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				85, 134), new Dimension(180, 150));
		btn1.setText("我的课程");
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn2 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				323, 134), new Dimension(180, 150));
		btn2.setText("选课");
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn3 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				535, 134), new Dimension(180, 150));
		btn3.setText("全校课程");
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn4 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				85, 344), new Dimension(180, 150));
		btn4.setText("我的成绩");
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn4.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn5 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				323, 344), new Dimension(180, 150));
		btn5.setText("专业准入准出");
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn5.setVerticalTextPosition(SwingConstants.BOTTOM);

		this.add(title);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
	}

	private void addListener() {
		time = StudentMethodController.getMethod();
		controller = StudentUISwitchController.getUISwitchController();

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToMCourse();
			}
		});

		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Student s = (Student) Identity.getIdentity();

					if (time.isTimeForSelectCourse()
							|| (time.isTimeForGradeOneSelectCourse() && GradeToTermAdapter
									.adapter(s.getGrade()) == 1)) {
					//	controller.switchToSCourse();
					} else {
						System.out.println("选课尚未开始");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToAllCourse();
			}
		});

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToScoreCheck();
			}
		});

		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public static void main(String[] args) {
		try {
			Identity.setIdentity(StudentMethodController.getMethod().getSelf(
					"121250011"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StudentUISwitchController controller = StudentUISwitchController
				.getUISwitchController();
		controller.switchToMainFrame();
	}

}
