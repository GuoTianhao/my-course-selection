package com.client.ui.teacherUI.CourseMagagement;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.ui.bcswing.CourseScoreTable;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseScoreRecordPanel extends MPanel{
	private TitleBar title;
	private CourseScoreTable table;
	private MButton backB;
	private MButton editB;
	public CourseScoreRecordPanel(Point loc, Dimension size){
		super(loc, size);
		createComponent();
		addListener();
	}
	private void createComponent(){
		title = new TitleBar(new Point(0, 0),
				new Dimension(this.getWidth(), 75));
		table=new CourseScoreTable(new Point(10, 130), new Dimension(780,
				430));
		backB=new MButton(null, null, null, new Point(10, 95), new Dimension(
				100, 30));
		editB=new MButton(null,null,null,new Point(700,95),new Dimension(100,30));
		
		backB.setText("返回");
		editB.setText("双击以编辑成绩");
		
		this.add(title);
		this.add(table);
		this.add(backB);
		this.add(editB);
	}
	private void addListener(){
		
	}
	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f = new MainFrame();
		f.add(new CourseScoreRecordPanel(new Point(0, 0), new Dimension(
				f.getSize().width, f.getSize().height)));
		f.refresh();
	}
}
