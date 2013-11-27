package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;

import com.basicdata.FacultyKind;
import com.basicdata.TermKind;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class AllCourseOperateBar extends MPanel{
	private MComboBox faculty;
	private MComboBox termBox;
	private MButton courseInfor;
	private MLabel facultyl;
	private MLabel yearl;
	private MTextField search;
	private MButton searchBtn;

	
	public AllCourseOperateBar(Point location, Dimension size){
		super(location,size);
		creatComponent();
	}
	private void creatComponent(){
		faculty=new MComboBox(FacultyKind.getAllFaculty(),new Point(50,0),new Dimension(100,30));
		termBox=new MComboBox(TermKind.getAllTerm(),new Point(200,0),new Dimension(100,30));
		search = new MTextField(new Point(650, 0), new Dimension(100,30));
		searchBtn = new MButton(null,null,null,new Point(755,0),new Dimension(30,30));
		
		this.add(faculty);
		this.add(termBox);
		this.add(search);
		this.add(searchBtn);
	}
	
	public void addSearchListener(ActionListener al){
		search.addActionListener(al);
	}
	
	public void addYearItemListener(ItemListener il){
		termBox.addItemListener(il);
	}
	
	public void addFacultyItemListenr(ItemListener il){
		faculty.addItemListener(il);
	}
	
	public String getTerm(){
		String selected;
		selected=(String) termBox.getSelectedItem();
		return selected;
	}
	
	public String getFaculty(){
		String selected;
		selected=(String) faculty.getSelectedItem();
		return selected;
	}
}
