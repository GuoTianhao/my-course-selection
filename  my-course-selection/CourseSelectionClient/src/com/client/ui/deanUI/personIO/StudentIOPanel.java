package com.client.ui.deanUI.personIO;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.client.ui.main.MainFrame;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.MScrollTabel;
import com.ui.bcswing.StudentDisplayTable;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.*;

public class StudentIOPanel extends MPanel{
	private TitleBar title;
	private MLabel choose;
	private MComboBox<String> department;
	private MButton importFromFile;
	private MTextField search;
	private MButton searchBtn;
	private StudentDisplayTable table;
	private String[] departmentItems = FacultyKind.getAllFaculty();
	
	public StudentIOPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
	}
	
	private void createComponent() {
		title = new TitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		choose = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择院系：");
		department = new MComboBox<>(departmentItems, new Point(90, 95), new Dimension(150, 25));
		importFromFile = new MButton(null,null,null,new Point(255, 95),new Dimension(100, 25));
		importFromFile.setText("从文件导入...");
		search = new MTextField("搜索");
		search.setBounds(635, 95, 120, 25);
		searchBtn = new MButton(new ImageIcon());
		searchBtn.setBounds(760, 95, 25, 25);
		table = new StudentDisplayTable(new Point(10, 130), new Dimension(780,430));
		this.add(title);
		this.add(choose);
		this.add(department);
		this.add(importFromFile);
		this.add(search);
		this.add(searchBtn);
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
		f.add(new StudentIOPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
