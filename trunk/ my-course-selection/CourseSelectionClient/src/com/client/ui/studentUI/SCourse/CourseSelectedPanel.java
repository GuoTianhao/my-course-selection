package com.client.ui.studentUI.SCourse;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.basicdata.YearKind;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.lCourse.CourseLookUpPanel;
import com.ui.bcswing.FrameDisplayTable;
import com.ui.bcswing.StudentCourseDisplayTable;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class CourseSelectedPanel extends MPanel{
	private TitleBar title;
	private MButton button1;
	private MButton button2;
	private MLabel label;
	private FrameDisplayTable table1;
	private StudentCourseDisplayTable table2;
	private Object[] data;
	
	public CourseSelectedPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
	}
	
	private void createComponent() {
		title = new TitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		button1=new MButton(null,null,null,new Point(360, 95),new Dimension(50, 25));
		button1.setText("选择");
		button2=new MButton(null,null,null,new Point(720, 95),new Dimension(50, 25));
		button2.setText("推选");
		label= new MLabel(new Point(430, 95), new Dimension(75, 22), "已选课程");
		table2 = new StudentCourseDisplayTable(new Point(430, 130), new Dimension(340,430));
		table1 = new FrameDisplayTable(new Point(10, 130), new Dimension(400,430));
		this.add(title);
		this.add(button1);
		this.add(button2);
		this.add(label);
		this.add(table2);
		this.add(table1);
	}
	
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		f.add(new CourseSelectedPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
