package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CoursePanel extends MPanel {
	private TitleBar title;
	private MButton courseP;
	private MButton courseA;

	private CoursePublicOperateBar publishOperateBar;
	private AllCourseOperateBar allCourseOperateBar;
	public CoursePanel(Dimension size) {
		super(size);
		creatComponent();
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

		this.add(title);
		this.add(courseP);
		this.add(courseA);

		publishOperateBar = new CoursePublicOperateBar(new Point(0, 140),
				new Dimension(size.width, 50));
		
		allCourseOperateBar=new AllCourseOperateBar(new Point(0, 140),
				new Dimension(size.width, 50));
		
		addCoursePublishOperateBar();
		addAllCourseOperateBar();
	}
	
	public void addCoursePublishOperateBar(){
		this.add(publishOperateBar);
		this.refresh();
	}
	
	public void addAllCourseOperateBar(){
		this.remove(publishOperateBar);
		this.add(allCourseOperateBar);
		this.refresh();
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MainFrame f = new MainFrame();
		f.add(new CoursePanel(f.getSize()));
		f.refresh();
	}
}
