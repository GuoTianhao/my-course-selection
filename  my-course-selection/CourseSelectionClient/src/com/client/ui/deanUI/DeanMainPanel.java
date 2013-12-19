package com.client.ui.deanUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.Identity;
import com.client.rmi.DeanMethodController;
import com.client.ui.main.MainFrame;
import com.client.ui.main.MainUISwitchController;
import com.logicService.DeanMethod;
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
//	private MButton btn6;
	private MButton btn7;

	DeanUISwitchController controller;

	public DeanMainPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		title = new DeanTitlebar(new Point(0, 0),
				new Dimension(this.getWidth(), 90));

		btn1 = new MButton(new ImageIcon("resource//frame.png"), null, new ImageIcon("resource//frame3.png"), new Point(
				65, 134), new Dimension(128, 150));
		btn1.setText("整体框架策略");
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn2 = new MButton(new ImageIcon("resource//plan.png"), null, new ImageIcon("resource//plan3.png"), new Point(
				253, 134), new Dimension(128, 150));
		btn2.setText("教学计划");
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn3 = new MButton(new ImageIcon("resource//course.png"), null, new ImageIcon("resource//course3.png"), new Point(
				441, 134), new Dimension(128, 150));
		btn3.setText("课程");
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn4 = new MButton(new ImageIcon("resource//teacher.png"), null, new ImageIcon("resource//teacher3.png"), new Point(
				629, 134), new Dimension(128, 150));
		btn4.setText("教师");
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn4.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn5 = new MButton(new ImageIcon("resource//student.png"), null, new ImageIcon("resource//student3.png"), new Point(
				65, 344), new Dimension(128, 150));
		btn5.setText("学生");
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn5.setVerticalTextPosition(SwingConstants.BOTTOM);

//		btn6 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
//				248, 344), new Dimension(128, 145));
//		btn6.setText("专业准入准出");
//		btn6.setHorizontalTextPosition(SwingConstants.CENTER);
//		btn6.setVerticalTextPosition(SwingConstants.BOTTOM);

		btn7 = new MButton(new ImageIcon("resource//settings.png"), null, new ImageIcon("resource//settings3.png"), new Point(
				253, 344), new Dimension(128, 150));
		btn7.setText("系统设置");
		btn7.setHorizontalTextPosition(SwingConstants.CENTER);
		btn7.setVerticalTextPosition(SwingConstants.BOTTOM);

		this.add(title);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
//		this.add(btn6);
		this.add(btn7);
	}

	private void addListener() {
		controller = DeanUISwitchController.getUISwitchController();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToBasicFramePanel();
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToFacultyPlanPanel();
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToCoursePanel();
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToTeacherPanel();
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchToStudentPanel();
			}
		});
//		btn6.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//			}
//		});
		btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.switchToTimePanel();
			}
		});
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
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
