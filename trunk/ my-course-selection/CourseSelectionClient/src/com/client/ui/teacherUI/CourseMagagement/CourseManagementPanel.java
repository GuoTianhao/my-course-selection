package com.client.ui.teacherUI.CourseMagagement;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseManagementPanel extends MPanel {
	private TitleBar title;
	private MButton editB;
	private MButton inforB;
	private MButton recordB;
	private CourseDisplayTable table;

	public CourseManagementPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		title = new TitleBar(new Point(0, 0),
				new Dimension(this.getWidth(), 75));
		editB = new MButton(null, null, null, new Point(10, 95), new Dimension(
				100, 30));
		inforB = new MButton(null, null, null, new Point(120, 95),
				new Dimension(100, 30));
		recordB = new MButton(null, null, null, new Point(230, 95),
				new Dimension(100, 30));
		table=new CourseDisplayTable(new Point(10, 130), new Dimension(780,
				430));
		
		editB.setText("编辑");
		inforB.setText("详细信息");
		recordB.setText("查看学生列表／登记成绩");
		
		this.add(title);
		this.add(editB);
		this.add(inforB);
		this.add(recordB);
		this.add(table);
	}

	private void addListener() {

	}
	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f = new MainFrame();
		f.add(new CourseManagementPanel(new Point(0, 0), new Dimension(
				f.getSize().width, f.getSize().height)));
		f.refresh();
	}

}
