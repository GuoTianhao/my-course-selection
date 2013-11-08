package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;

import com.basicdata.FacultyKind;
import com.basicdata.YearKind;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class AllCourseOperateBar extends MPanel{
	private MComboBox faculty;
	private MComboBox year;
	private MButton courseInfor;
	private MLabel facultyl;
	private MLabel yearl;
	
	public AllCourseOperateBar(Point location, Dimension size){
		super(location,size);
		creatComponent();
	}
	private void creatComponent(){
		faculty=new MComboBox(FacultyKind.getAllFaculty(),new Point(50,0),new Dimension(100,30));
		year=new MComboBox(YearKind.getYear(),new Point(200,0),new Dimension(100,30));
		this.add(faculty);
		this.add(year);
	}
}
