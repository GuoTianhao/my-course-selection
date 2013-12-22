package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import com.ui.myswing.MButton;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class CoursePublicOperateBar extends MPanel {
	private MButton courseP;
	private MButton courseM;
	private MButton courseInfor;

	private MTextField search;

	public CoursePublicOperateBar(Point loc, Dimension size) {
		super(loc, size);
		creatComponent();
	}

	private void creatComponent() {
		courseP = new MButton(null, null, null, new Point(30, 0),
				new Dimension(80, 25));
		courseM = new MButton(null, null, null, new Point(120, 0),
				new Dimension(80, 25));
//		courseInfor = new MButton(null, null, null, new Point(210, 0),
//				new Dimension(100, 25));

		courseP.setText("发布新课程");
		courseM.setText("修改课程");
//		courseInfor.setText("课程详细信息");

		search = new MTextField(new Point(700, 0), new Dimension(120, 25));
		MLabel searchLb = new MLabel(new ImageIcon("resource//search.png"));
		searchLb.setBounds(672, 0, 24, 24);
		this.add(courseP);
		this.add(courseM);
//		this.add(courseInfor);

		this.add(search);
		this.add(searchLb);
	}

	public void addCoursePListener(ActionListener al) {
		courseP.addActionListener(al);
	}

	public void addcourseMListener(ActionListener al) {
		courseM.addActionListener(al);
	}

//	public void addcourseInforListener(ActionListener al) {
//		courseInfor.addActionListener(al);
//	}

	public void addSearchKeyListener(KeyListener kl) {
		search.addKeyListener(kl);
	}

	public String getSearchContent() {
		return search.getText();
	}
}
