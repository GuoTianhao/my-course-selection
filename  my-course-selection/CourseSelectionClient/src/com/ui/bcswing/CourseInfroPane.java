package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

import com.data.po.Course;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MTextField;

//显示具体的课程信息
public class CourseInfroPane extends MFrame {
	private static Dimension default_size = new Dimension(550, 500);
	private Course course;

	private MLabel namel;
	private MLabel idl;
	private MLabel locl;
	private MLabel creditl;
	private MLabel numl;
	private MLabel typel;
	private MLabel gradel;
	private MLabel facultyl;
	private MLabel periodl;

	private MLabel timel;

	private MLabel namet;
	private MLabel idt;
	private MLabel loct;
	private MLabel creditt;
	private MLabel numt;
	private MLabel typet;
	private MLabel gradet;
	private MLabel facultyt;
	private MLabel periodt;
	private MLabel timet1;
	private MLabel timet2;
	private MLabel timet3;

	public CourseInfroPane(Dimension size) {
		super(size);
		createComponent();
		init();
	}

	public CourseInfroPane(Course c) {
		this(default_size);
		setCourse(c);
	}

	private void createComponent() {
		namel = new MLabel(new Point(0, 0), new Dimension(100, 20), "课程名称:");
		idl = new MLabel(new Point(0, 30), new Dimension(100, 20), "课程编号:");
		locl = new MLabel(new Point(0, 60), new Dimension(100, 20), "上课地点:");
		creditl = new MLabel(new Point(0, 90), new Dimension(100, 20), "学分:");
		numl = new MLabel(new Point(0, 120), new Dimension(100, 20), "上课人数:");
		typel = new MLabel(new Point(0, 150), new Dimension(100, 20), "课程类型:");
		gradel = new MLabel(new Point(0, 180), new Dimension(100, 20), "年级:");
		facultyl = new MLabel(new Point(0, 210), new Dimension(100, 20),
				"课程院系:");
		periodl = new MLabel(new Point(0, 250), new Dimension(100, 20), "上课周数:");
		timel = new MLabel(new Point(0, 280), new Dimension(100, 20), "上课时间:");

		namet = new MLabel(new Point(150, 0), new Dimension(100, 20),
				course.getName());
		idt = new MLabel(new Point(150, 30), new Dimension(100, 20),
				course.getID());
		loct = new MLabel(new Point(150, 60), new Dimension(100, 20),
				course.getLoc());
		creditt = new MLabel(new Point(150, 90), new Dimension(100, 20),
				course.getCredit() + "");
		numt = new MLabel(new Point(150, 120), new Dimension(100, 20),
				course.getNum() + "");
		typet = new MLabel(new Point(150, 150), new Dimension(100, 20),
				course.getType());
		gradet = new MLabel(new Point(150, 180), new Dimension(100, 20),
				course.getGrade() + "");
		facultyt = new MLabel(new Point(150, 210), new Dimension(100, 20),
				course.getFaculty());
		periodt = new MLabel(new Point(150, 250), new Dimension(100, 20),
				course.getPeriod());
		timet1=new MLabel(new Point(150,290),new Dimension(60,20),course.getTime().get(0).toString());
		timet2=new MLabel(new Point(220,290),new Dimension(60,20),course.getTime().get(0).toString());
		timet3=new MLabel(new Point(300,290),new Dimension(60,20),course.getTime().get(0).toString());
           
		this.add(namel);
		this.add(idl);
		this.add(locl);
		this.add(creditl);
		this.add(numl);
		this.add(typel);
		this.add(gradel);
		this.add(facultyl);
		this.add(periodl);
		this.add(timel);

		this.add(namet);
		this.add(idt);
		this.add(loct);
		this.add(creditt);
		this.add(numt);
		this.add(typet);
		this.add(gradet);
		this.add(facultyt);
		this.add(periodt);
		this.add(timet1);
		this.add(timet2);
		this.add(timet3);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.validate();
		this.repaint();
	}

	private void init() {

	}

	public void setCourse(Course c) {
		course = c;
	}

}
