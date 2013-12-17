package com.client.ui.deanUI.timePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.client.rmi.DeanMethodController;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.studentUI.StudentMainPanel;
import com.client.ui.studentUI.StudentUISwitchController;
import com.logicService.DeanMethod;
import com.timeControllerService.TimeController;
import com.ui.bcswing.TipFrame;
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

		publishLb = new MLabel(new Point(120, 95), new Dimension(80, 40), "发布课程");
		publish = new MButton(off, null, null, new Point(220, 100),
				new Dimension(80, 40));

		studentSelectLb = new MLabel(new Point(120, 145), new Dimension(80, 40),
				"学生选课");
		studentSelect = new MButton(off, null, null, new Point(220, 150),
				new Dimension(80, 40));

		gradeOneSelectLb = new MLabel(new Point(120, 195),
				new Dimension(100, 40), "大一新生选课");
		gradeOneSelect = new MButton(off, null, null, new Point(220, 200),
				new Dimension(80, 40));

		quitCourseLb = new MLabel(new Point(120, 245), new Dimension(80, 40),
				"退选");
		quitCourse = new MButton(off, null, null, new Point(220, 250),
				new Dimension(80, 40));

		bySelectLb = new MLabel(new Point(120, 295), new Dimension(80, 40), "补选");
		bySelect = new MButton(off, null, null, new Point(220, 300),
				new Dimension(80, 40));

		systemSelectLb = new MLabel(new Point(120, 345), new Dimension(80, 40),
				"系统选课");
		systemSelect = new MButton(off, null, null, new Point(220, 350),
				new Dimension(80, 40));
		
		

		termOneStartDayLb=new MLabel(new Point(485, 95), new Dimension(100, 40),
				"第一学期开始");
		termOneStartDay=new MTextField(new Point(585,100),new Dimension(80,25));
		
		termOneEndDayLb=new MLabel(new Point(485, 145), new Dimension(100, 40),
				"第一学期结束");
		termOneEndDay=new MTextField(new Point(585,150),new Dimension(80,25));
		
		winterStartDayLb=new MLabel(new Point(485, 195), new Dimension(100, 40),
				"寒假开始");
		winterStartDay=new MTextField(new Point(585,200),new Dimension(80,25));
		
		winterEndDayLb=new MLabel(new Point(485, 245), new Dimension(100, 40),
				"寒假结束");
		winterEndDay=new MTextField(new Point(585,250),new Dimension(80,25));
		
		termTwoStartDayLb=new MLabel(new Point(485, 295), new Dimension(100, 40),
				"第二学期开始");
		termTwoStartDay=new MTextField(new Point(585,300),new Dimension(80,25));
		
		termTwoEndDayLb=new MLabel(new Point(485, 345), new Dimension(100, 40),
				"第二学期结束");
		termTwoEndDay=new MTextField(new Point(585,350),new Dimension(80,25));
		
		summerStartDayLb=new MLabel(new Point(485, 395), new Dimension(100, 40),
				"暑假开始");
		summerStartDay=new MTextField(new Point(585,400),new Dimension(80,25));
		
		summerEndDayLb=new MLabel(new Point(485, 445), new Dimension(100, 40),
				"暑假结束");
		summerEndDay=new MTextField(new Point(585,450),new Dimension(80,25));
		
		confirm=new MButton(null, null, null, new Point(535, 500),
				new Dimension(80, 25));
		confirm.setText("确定");
		
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
		
		this.add(confirm);
		
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

		confirm.addActionListener(new ConfirmListener());
		
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

	class ConfirmListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DeanMethod method=DeanMethodController.getMethod();
			DateFormat format=DateFormat.getDateInstance();
			try {
				method.setPeriodTime("1",format.parse(termOneStartDay.getText()) );
				method.setPeriodTime("2",format.parse(termOneEndDay.getText()) );
				method.setPeriodTime("3",format.parse(winterStartDay.getText()) );
				method.setPeriodTime("4",format.parse(winterEndDay.getText()) );
				method.setPeriodTime("5",format.parse(termTwoStartDay.getText()) );
				method.setPeriodTime("6",format.parse(termTwoEndDay.getText()) );
				method.setPeriodTime("7",format.parse(summerStartDay.getText()) );
				method.setPeriodTime("8",format.parse(summerEndDay.getText()) );
				DeanUISwitchController controller = DeanUISwitchController
						.getUISwitchController();
				TipFrame t = new TipFrame(controller.getLoc(),TimeControlPanel.this.getSize(), 5,
						"时间设置成功");
				t.startEndClock();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
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
