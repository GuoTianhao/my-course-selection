package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;

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

	
	public AllCourseOperateBar(Point location, Dimension size){
		super(location,size);
		creatComponent();
	}
	private void creatComponent(){
		faculty=new MComboBox(FacultyKind.getAllFaculty(),new Point(30,0),new Dimension(100,25));
		termBox=new MComboBox(TermKind.getAllTerm(),new Point(140,0),new Dimension(100,25));
		search = new MTextField(new Point(700, 0), new Dimension(120,25));
		MLabel searchLb = new MLabel(new ImageIcon("resource//search.png"));
		searchLb.setBounds(672, 0, 24, 24);		
		this.add(faculty);
		this.add(termBox);
		this.add(search);
		this.add(searchLb);
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
	
	public void addSearchKeyListener(KeyListener kl){
		search.addKeyListener(kl);
		System.out.println("yes");
	}
	
	public String getSearchContent(){
		return search.getText();
	}
	
	public void changeItemState(){
		faculty.setSelectedIndex(-1);
		faculty.setSelectedIndex(0);
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
