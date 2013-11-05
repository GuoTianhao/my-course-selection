package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class CourseEditPanel extends MPanel{
	MLabel namel;
	MLabel idl;
	MLabel locl;
	MLabel creditl;
	MLabel numl;
	MLabel typel;
	MLabel gradel;
	MLabel facultyl;
	
	MTextField namet;
	MTextField idt;
	MTextField loct;
	MTextField creditt;
	MTextField numt;
	MTextField typet;
	MTextField gradet;
	MTextField facultyt;

	
	public CourseEditPanel(Dimension size) {
		super();
		creatComponent();
	}
	private void creatComponent(){
		namel=new MLabel(new Point(0,0),new Dimension(100,20),"课程名称:");
		idl=new MLabel(new Point(0,30),new Dimension(100,20),"课程编号:");
		locl=new MLabel(new Point(0,60),new Dimension(100,20),"上课地点:");
		creditl=new MLabel(new Point(0,90),new Dimension(100,20),"学分:");
		numl=new MLabel(new Point(0,120),new Dimension(100,20),"上课人数:");
		typel=new MLabel(new Point(0,150),new Dimension(100,20),"课程类型:");
		gradel=new MLabel(new Point(0,180),new Dimension(100,20),"年级:");
		facultyl=new MLabel(new Point(0,210),new Dimension(100,20),"课程院系:");

		namet=new MTextField(new Point(150,0),new Dimension(100,20));
		idt=new MTextField(new Point(150,30),new Dimension(100,20));
		loct=new MTextField(new Point(150,60),new Dimension(100,20));
		creditt=new MTextField(new Point(150,90),new Dimension(100,20));
		numt=new MTextField(new Point(150,120),new Dimension(100,20));
		typet=new MTextField(new Point(150,150),new Dimension(100,20));
		gradet=new MTextField(new Point(150,180),new Dimension(100,20));
		facultyt=new MTextField(new Point(150,210),new Dimension(100,20));
		
		this.add(namel);
		this.add(idl);
		this.add(locl);
		this.add(creditl);
		this.add(numl);
		this.add(typel);
		this.add(gradel);
		this.add(facultyl);
		
		this.add(namet);
		this.add(idt);
		this.add(loct);
		this.add(creditt);
		this.add(numt);
		this.add(typet);
		this.add(gradet);
		this.add(facultyt);
		
		this.repaint();
	}
	public static void main(String[] args){
		MFrame f=new MFrame(new Dimension(400,300));
		f.add(new CourseEditPanel(f.getSize()));
	}
}
