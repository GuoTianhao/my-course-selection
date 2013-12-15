package com.client.ui.deanUI.timePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
	private ImageIcon on = new ImageIcon("resource\\on.png");
	private ImageIcon off = new ImageIcon("resource\\off.png");


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

		publishLb = new MLabel(new Point(20, 95), new Dimension(60, 40), "发布课程");
		publish = new MButton(off, null, null, new Point(80, 100),
				new Dimension(100, 40));
		
		studentSelectLb = new MLabel(new Point(20, 145), new Dimension(60, 40),"学生选课");
		studentSelect = new MButton(off, null, null, new Point(80, 150),
				new Dimension(100,40));
		
		gradeOneSelect = new MButton(off, null, null, new Point(15, 200),
				new Dimension(200, 30));
		quitCourse = new MButton(off, null, null, new Point(15, 250),
				new Dimension(200, 30));
		bySelect = new MButton(off, null, null, new Point(15, 300),
				new Dimension(200, 30));
		systemSelect = new MButton(off, null, null, new Point(15, 350),
				new Dimension(200, 30));

		this.add(publish);
		this.add(publishLb);
		this.add(studentSelect);
		this.add(studentSelectLb);
		this.add(gradeOneSelect);
		this.add(quitCourse);
		this.add(bySelect);
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
		
		
		publish.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForPublishCourse(!time.isTimeForPublishCourse());
					refreshButton();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		studentSelect.addActionListener(new ActionListener(){

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
		
		gradeOneSelect.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					time.setIsTimeForGradeOneSelectCourse(!time.isTimeForGradeOneSelectCourse());
					refreshButton();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		quitCourse.addActionListener(new ActionListener(){

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
		
		bySelect.addActionListener(new ActionListener(){

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
		
		systemSelect.addActionListener(new ActionListener(){

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
//				publish.setText("开始发布课程");
				publish.setIcon(off);
			} else {
//				publish.setText("结束发布课程");
				publish.setIcon(on);
			}

			if (!time.isTimeForSelectCourse()) {
//				studentSelect.setText("开始选课");
				studentSelect.setIcon(off);
			} else {
//				studentSelect.setText("结束选课");
				studentSelect.setIcon(on);
			}

			if (!time.isTimeForGradeOneSelectCourse()) {
				gradeOneSelect.setText("大一新生开始选课");
			} else {
				gradeOneSelect.setText("大一新生结束选课");
			}

			if (!time.isTimeForQuitCourse()) {
				quitCourse.setText("开始退课");
			} else {
				quitCourse.setText("结束退课");
			}
			if (!time.isTimeForByElection()) {
				bySelect.setText("开始补选");
			} else {
				bySelect.setText("结束补选");
			}
			
			if (!time.isTimeForSystemSelect()) {
				systemSelect.setText("系统选课开始");
			} else {
				systemSelect.setText("系统选课结束");
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException | InstantiationException
//				| IllegalAccessException | UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		DeanUISwitchController controller = DeanUISwitchController
				.getUISwitchController();
		controller.switchToTimePanel();
	}

}
