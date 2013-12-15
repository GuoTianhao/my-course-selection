package com.client.ui.studentUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.GradeToTermAdapter;
import com.data.po.Student;
import com.timeControllerService.TimeController;
import com.ui.bcswing.TipFrame;
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
	private MButton btn6;
	private MButton btn7;

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
				60, 134), new Dimension(128, 145));
		btn1.setText("我的课程");
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn2 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				60, 344), new Dimension(128, 145));
		btn2.setText("选课");
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn3 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				248, 134), new Dimension(128, 145));
		btn3.setText("全校课程");
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn4 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				436, 134), new Dimension(128, 145));
		btn4.setText("我的成绩");
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn4.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn5 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				624, 134), new Dimension(128, 145));
		btn5.setText("专业准入准出");
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn5.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn6 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				248, 344), new Dimension(128, 145));
		btn6.setText("退选");
		btn6.setHorizontalTextPosition(SwingConstants.CENTER);
		btn6.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn7 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				436, 344), new Dimension(128, 145));
		btn7.setText("补选");
		btn7.setHorizontalTextPosition(SwingConstants.CENTER);
		btn7.setVerticalTextPosition(SwingConstants.BOTTOM);

		this.add(title);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
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
						controller.switchToCourseSelect();
					} else {
						StudentUISwitchController controller = StudentUISwitchController
								.getUISwitchController();
						TipFrame t = new TipFrame(controller.getLoc(),StudentMainPanel.this.getSize(), 5,
								"未到选课时间");
						t.startEndClock();

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

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.switchToQCourse();
			}
		});

		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.switchToBSCourse();
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
//
//		try {
//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//			UIManager.put("RootPane.setupButtonVisible", false);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StudentUISwitchController controller = StudentUISwitchController
				.getUISwitchController();
		controller.switchToMainFrame();
	}

}
