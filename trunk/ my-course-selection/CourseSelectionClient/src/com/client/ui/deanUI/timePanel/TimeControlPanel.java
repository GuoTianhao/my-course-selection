package com.client.ui.deanUI.timePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DateFormat;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.client.rmi.DeanMethodController;
import com.client.ui.deanUI.DeanUISwitchController;
import com.logicService.DeanMethod;
import com.timeControllerService.TimeController;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

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
	
	
	
	private MLabel termOneStartDayLb;
	private MLabel termOneEndDayLb;
	private MLabel winterStartDayLb;
	private MLabel winterEndDayLb;
	private MLabel termTwoStartDayLb;
	private MLabel termTwoEndDayLb;
	private MLabel summerStartDayLb;
	private MLabel summerEndDayLb;
	
	private MTextField termOneStartDay;
	private MTextField termOneEndDay;
	private MTextField winterStartDay;
	private MTextField winterEndDay;
	private MTextField termTwoStartDay;
	private MTextField termTwoEndDay;
	private MTextField summerStartDay;
	private MTextField summerEndDay;
	
	private MButton confirm;
	
	private ImageIcon on = new ImageIcon("resource//on.png");
	private ImageIcon off = new ImageIcon("resource//off.png");

	private TimeController time = DeanMethodController.getMethod();

	public TimeControlPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		init();
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
		
		

		termOneStartDayLb=new MLabel(new Point(400, 100), new Dimension(80, 40),
				"termOneStartDay");
		termOneStartDay=new MTextField(new Point(500,100),new Dimension(100,30));
		
		termOneEndDayLb=new MLabel(new Point(400, 150), new Dimension(80, 40),
				"termOneEndDay");
		termOneEndDay=new MTextField(new Point(500,150),new Dimension(100,30));
		
		winterStartDayLb=new MLabel(new Point(400, 200), new Dimension(80, 40),
				"winterStartDay");
		winterStartDay=new MTextField(new Point(500,200),new Dimension(100,30));
		
		winterEndDayLb=new MLabel(new Point(400, 250), new Dimension(80, 40),
				"winterEndDay");
		winterEndDay=new MTextField(new Point(500,250),new Dimension(100,30));
		
		termTwoStartDayLb=new MLabel(new Point(400, 300), new Dimension(80, 40),
				"termTwoStartDay");
		termTwoStartDay=new MTextField(new Point(500,300),new Dimension(100,30));
		
		termTwoEndDayLb=new MLabel(new Point(400, 350), new Dimension(80, 40),
				"termTwoEndDay");
		termTwoEndDay=new MTextField(new Point(500,350),new Dimension(100,30));
		
		summerStartDayLb=new MLabel(new Point(400, 400), new Dimension(80, 40),
				"summerStartDay");
		summerStartDay=new MTextField(new Point(500,400),new Dimension(100,30));
		
		summerEndDayLb=new MLabel(new Point(400, 450), new Dimension(80, 40),
				"summerEndDay");
		summerEndDay=new MTextField(new Point(500,450),new Dimension(100,30));
		
		confirm=new MButton(off, null, null, new Point(400, 500),
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
		
		this.add(termOneStartDayLb);
		this.add(termOneStartDay);
		this.add(termOneEndDayLb);
		this.add(termOneEndDay);
		this.add(winterStartDayLb);
		this.add(winterStartDay);
		this.add(winterEndDayLb);
		this.add(winterEndDay);
		this.add(termTwoStartDayLb);
		this.add(termTwoStartDay);
		this.add(termTwoEndDayLb);
		this.add(termTwoEndDay);
		this.add(summerStartDayLb);
		this.add(summerStartDay);
		this.add(summerEndDayLb);
		this.add(summerEndDay);
		
		
		this.add(title);

	}

	private void init(){
		DeanMethod method=DeanMethodController.getMethod();
		DateFormat format=DateFormat.getDateInstance();
		try {
			termOneStartDay.setText(format.format(method.getPeriodTime("1")));
			termOneEndDay.setText(format.format(method.getPeriodTime("2")));
			winterStartDay.setText(format.format(method.getPeriodTime("3")));
			winterEndDay.setText(format.format(method.getPeriodTime("4")));
			termTwoStartDay.setText(format.format(method.getPeriodTime("5")));
			termTwoEndDay.setText(format.format(method.getPeriodTime("6")));
			summerStartDay.setText(format.format(method.getPeriodTime("7")));
			summerEndDay.setText(format.format(method.getPeriodTime("8")));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
				publish.setIcon(off);
			} else {
				publish.setIcon(on);
			}

			if (!time.isTimeForSelectCourse()) {
				studentSelect.setIcon(off);
			} else {
				studentSelect.setIcon(on);
			}

			if (!time.isTimeForGradeOneSelectCourse()) {
				gradeOneSelect.setIcon(off);
			} else {
				gradeOneSelect.setIcon(on);
			}

			if (!time.isTimeForQuitCourse()) {
				quitCourse.setIcon(off);
			} else {
				quitCourse.setIcon(on);
			}
			if (!time.isTimeForByElection()) {
				bySelect.setIcon(off);
			} else {
				bySelect.setIcon(on);
			}

			if (!time.isTimeForSystemSelect()) {
				systemSelect.setIcon(off);
			} else {
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
