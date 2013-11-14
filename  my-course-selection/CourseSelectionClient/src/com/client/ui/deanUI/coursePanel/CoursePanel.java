package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.main.MainFrame;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.CourseEditPane;
import com.ui.bcswing.MScrollTabel;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class CoursePanel extends MPanel {
	private TitleBar title;
	private MButton courseP;
	private MButton courseA;
	private CoursePublicOperateBar publishOperateBar;
	private AllCourseOperateBar allCourseOperateBar;
	
	private CourseDisplayTable courseTable;
	
	private int state;
	public CoursePanel(Point loc,Dimension size) {
		super(loc,size);
		creatComponent();
		addListener();
	}

	private void creatComponent() {
		Dimension size = this.getSize();
		title = new TitleBar(new Point(0, 0), new Dimension(size.width, 100));
		courseP = new MButton(null, null, null, new Point(0, 100),
				new Dimension(100, 30));
		courseA = new MButton(null, null, null, new Point(110, 100),
				new Dimension(100, 30));

		courseP.setText("公共课程");
		courseA.setText("全校课程");
		
		courseTable=new CourseDisplayTable(new Point(10, 180), new Dimension(size.width-70,380));

		this.add(title);
		this.add(courseP);
		this.add(courseA);
		this.add(courseTable);

		publishOperateBar = new CoursePublicOperateBar(new Point(0, 140),
				new Dimension(size.width, 50));
		
		allCourseOperateBar=new AllCourseOperateBar(new Point(0, 140),
				new Dimension(size.width, 50));
		
		addCoursePublishOperateBar();
	}
	
	private void addListener(){
		courseP.addActionListener(new PublicCourseSwitchListener());
		courseA.addActionListener(new AllCourseSwitchListener());
		
		title.addReturnMenu(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DeanUISwitchController controller=DeanUISwitchController.getUISwitchController();
				controller.swicthToMainFrame();
			}
			
		});
		
		publishOperateBar.addCoursePListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CourseEditPane();
			}
			
		});
		
	}
	
	private void addCoursePublishOperateBar(){
		this.remove(allCourseOperateBar);
		this.add(publishOperateBar);
		this.refresh();
		state=0;
	}
	
	public void addAllCourseOperateBar(){
		this.remove(publishOperateBar);
		this.add(allCourseOperateBar);
		this.refresh();
		state=1;
	}
	
	class PublicCourseSwitchListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(state==1){
				addCoursePublishOperateBar();
			}
		}
		
	}
	
	class AllCourseSwitchListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(state==0){
				addAllCourseOperateBar();
			}
		}
		
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MainFrame f = new MainFrame();
		f.add(new CoursePanel(new Point(0,0),f.getSize()));
		f.refresh();
	}
}
