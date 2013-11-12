package com.client.ui.deanUI.facultyPlan;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.client.ui.deanUI.personIO.StudentIOPanel;
import com.client.ui.main.MainFrame;
import com.ui.bcswing.MScrollTabel;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class FacultyPlanPanel extends MPanel{
	private TitleBar title;
	private MLabel choose;
	private MComboBox<String> department;
	private MScrollTabel table;
	private String[] departmentItems = FacultyKind.getAllFaculty();
	private String[] columnNames = {"课程模块(学分)","课程性质","序列","课程类别(学分)","课程名称","建议学分","开设学期"};
	private Object[] data;
	
	public FacultyPlanPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
	}
	
	private void createComponent() {
		title = new TitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		choose = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择院系：");
		department = new MComboBox<>(departmentItems, new Point(90, 95), new Dimension(150, 25));
		table = new MScrollTabel(new Point(10, 130), new Dimension(780,430));
		table.setColumnIdentifiers(columnNames);
		this.add(title);
		this.add(choose);
		this.add(department);
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
		f.add(new FacultyPlanPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
