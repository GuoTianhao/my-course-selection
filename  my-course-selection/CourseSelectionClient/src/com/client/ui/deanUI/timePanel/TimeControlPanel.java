package com.client.ui.deanUI.timePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.client.rmi.DeanMethodController;
import com.client.ui.deanUI.DeanUISwitchController;
import com.timeControllerService.TimeController;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class TimeControlPanel extends MPanel {
	private TitleBar title;
	private MButton publish;
	private MButton studentSelect;
	private MButton gradeOneSelect;
	private MButton quitCourse;
	private MButton bySelect;
	private MButton systemSelect;

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

		publish = new MButton(null, null, null, new Point(15, 100),
				new Dimension(200, 30));
		studentSelect = new MButton(null, null, null, new Point(15, 150),
				new Dimension(200, 30));
		gradeOneSelect = new MButton(null, null, null, new Point(15, 200),
				new Dimension(200, 30));
		quitCourse = new MButton(null, null, null, new Point(15, 250),
				new Dimension(200, 30));
		bySelect = new MButton(null, null, null, new Point(15, 300),
				new Dimension(200, 30));
		systemSelect = new MButton(null, null, null, new Point(15, 350),
				new Dimension(200, 30));

		this.add(publish);
		this.add(studentSelect);
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
				publish.setText("开始发布课程");
			} else {
				publish.setText("结束发布课程");
			}

			if (!time.isTimeForSelectCourse()) {
				studentSelect.setText("开始选课");
			} else {
				studentSelect.setText("结束选课");
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
		DeanUISwitchController controller = DeanUISwitchController
				.getUISwitchController();
		controller.switchTpTimePanel();
	}

}
