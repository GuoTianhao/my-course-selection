package com.client.ui.deanUI.timePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.client.rmi.DeanMethodController;
import com.client.ui.deanUI.DeanUISwitchController;
import com.timeControllerService.TimeController;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MFont;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class TimeControlPanel extends MPanel {
	private TitleBar title;
	private MLabel publishLb;
	private MButton publish;
	private MLabel studentSelectLb;
	private MButton studentSelect;
	private MLabel gradeOneSelectLb;
	private MButton gradeOneSelect;
	private MLabel quitCourseLb;
	private MButton quitCourse;
	private MLabel bySelectLb;
	private MButton bySelect;
	private MLabel systemSelectLb;
	private MButton systemSelect;
	private ImageIcon on = new ImageIcon("resource//on.png");
	private ImageIcon off = new ImageIcon("resource//off.png");

	private TimeController time = DeanMethodController.getMethod();

	public TimeControlPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		refreshButton();
	}

	private void createComponent() {

		title = new DeanTitlebar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));

		publishLb = new MLabel(new Point(40, 95), new Dimension(80, 40), "发布课程");
		publish = new MButton(off, null, null, new Point(140, 100),
				new Dimension(80, 40));

		studentSelectLb = new MLabel(new Point(40, 145), new Dimension(80, 40),
				"学生选课");
		studentSelect = new MButton(off, null, null, new Point(140, 150),
				new Dimension(80, 40));

		gradeOneSelectLb = new MLabel(new Point(40, 195),
				new Dimension(100, 40), "大一新生选课");
		gradeOneSelect = new MButton(off, null, null, new Point(140, 200),
				new Dimension(80, 40));

		quitCourseLb = new MLabel(new Point(40, 245), new Dimension(80, 40),
				"退选");
		quitCourse = new MButton(off, null, null, new Point(140, 250),
				new Dimension(80, 40));

		bySelectLb = new MLabel(new Point(40, 295), new Dimension(80, 40), "补选");
		bySelect = new MButton(off, null, null, new Point(140, 300),
				new Dimension(80, 40));

		systemSelectLb = new MLabel(new Point(40, 345), new Dimension(80, 40),
				"补选");
		systemSelect = new MButton(off, null, null, new Point(140, 350),
				new Dimension(80, 40));

		this.add(publishLb);
		this.add(publish);
		this.add(studentSelectLb);
		this.add(studentSelect);
		this.add(gradeOneSelectLb);
		this.add(gradeOneSelect);
		this.add(quitCourseLb);
		this.add(quitCourse);
		this.add(bySelectLb);
		this.add(bySelect);
		this.add(systemSelectLb);
		this.add(systemSelect);
		this.add(title);

	}

	private void addListener() {
		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanUISwitchController controller = DeanUISwitchController
						.getUISwitchController();
				controller.swicthToMainFrame();
			}
		});

		publish.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForPublishCourse(!time
							.isTimeForPublishCourse());
					refreshButton();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});

		studentSelect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForSelectCourse(!time.isTimeForSelectCourse());
					refreshButton();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		gradeOneSelect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForGradeOneSelectCourse(!time
							.isTimeForGradeOneSelectCourse());
					refreshButton();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		quitCourse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForQuitCourse(!time.isTimeForQuitCourse());
					refreshButton();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		bySelect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForByElection(!time.isTimeForByElection());
					refreshButton();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		systemSelect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForSystemSelect(!time.isTimeForSystemSelect());
					refreshButton();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

	}

	private void refreshButton() {
		try {
			if (!time.isTimeForPublishCourse()) {
				// publish.setText("开始发布课程");
				publish.setIcon(off);
			} else {
				// publish.setText("结束发布课程");
				publish.setIcon(on);
			}

			if (!time.isTimeForSelectCourse()) {
				// studentSelect.setText("开始选课");
				studentSelect.setIcon(off);
			} else {
				// studentSelect.setText("结束选课");
				studentSelect.setIcon(on);
			}

			if (!time.isTimeForGradeOneSelectCourse()) {
				// gradeOneSelect.setText("大一新生开始选课");
				gradeOneSelect.setIcon(off);
			} else {
				// gradeOneSelect.setText("大一新生结束选课");
				gradeOneSelect.setIcon(on);
			}

			if (!time.isTimeForQuitCourse()) {
				// quitCourse.setText("开始退课");
				quitCourse.setIcon(off);
			} else {
				// quitCourse.setText("结束退课");
				quitCourse.setIcon(on);
			}
			if (!time.isTimeForByElection()) {
				// bySelect.setText("开始补选");
				bySelect.setIcon(off);
			} else {
				// bySelect.setText("结束补选");
				bySelect.setIcon(on);
			}

			if (!time.isTimeForSystemSelect()) {
				// systemSelect.setText("系统选课开始");
				systemSelect.setIcon(off);
			} else {
				// systemSelect.setText("系统选课结束");
				systemSelect.setIcon(on);
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}

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
		controller.switchToTimePanel();
	}

}
