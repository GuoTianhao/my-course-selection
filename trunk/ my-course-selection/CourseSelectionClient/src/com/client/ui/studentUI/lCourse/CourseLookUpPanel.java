package com.client.ui.studentUI.lCourse;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.basicdata.YearKind;
import com.client.ui.main.MainFrame;
import com.ui.bcswing.FrameDisplayTable;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class CourseLookUpPanel extends MPanel{
	private TitleBar title;
	private MLabel choose1;
	private MLabel choose2;
	private MComboBox<String> year;
	private MComboBox<String> department;
	private FrameDisplayTable table;
	private String[] yearItems = YearKind.getYear();
	private String[] departmentItems = FacultyKind.getAllFaculty();
	private Object[] data;
	
	public CourseLookUpPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
	}
	
	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		choose1 = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择学期：");
		year = new MComboBox<>(yearItems, new Point(90, 95), new Dimension(150, 25));
		choose2 = new MLabel(new Point(260, 95), new Dimension(75, 22), "选择院系：");
		department = new MComboBox<>(departmentItems, new Point(350, 95), new Dimension(150, 25));
		table = new FrameDisplayTable(new Point(10, 130), new Dimension(780,430));
		this.add(title);
		this.add(choose1);
		this.add(choose2);
		this.add(department);
		this.add(year);
		this.add(table);
	}
	
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		f.add(new CourseLookUpPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
