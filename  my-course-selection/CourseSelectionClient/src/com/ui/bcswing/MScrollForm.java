package com.ui.bcswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.UIManager;

import com.ui.myswing.MButton;
import com.ui.myswing.MFrame;
import com.ui.myswing.MPanel;

public class MScrollForm extends MFrame implements Observer{
	MPanel panel;
	private JScrollPane scrollPane;
	private Dimension size;
	private CourseEditPanel courseEdit;
	public MScrollForm(Dimension size){
		super(size);
		this.size=size;
		creatComponent();
	}
	private void creatComponent(){
		panel=new MPanel(size);
		panel.setLayout(null);
		panel.setLocation(0, 0);
		courseEdit=new CourseEditPanel(new Point(0,0),size);
		courseEdit.addObserver(this);
		panel.add(courseEdit);
		panel.validate();
		panel.repaint();
		
		scrollPane=new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
		
		this.validate();
		this.repaint();
	}
	public void setHeight(int height){
		panel.setPreferredSize(new Dimension(size.width,height));
		panel.refresh();
		scrollPane.repaint();
		scrollPane.validate();
		this.refresh();
		System.out.println(panel.getSize().height);
	}
	public void update(Observable o, Object arg) {
		int heightAdd=(int) arg;
		setHeight(panel.getSize().height+heightAdd);
		
	}
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MScrollForm f=new MScrollForm(new Dimension(550,500));
		f.go(f);
	}
	public void go(MScrollForm f){
		f.setLocation(400, 200);
	//	f.panel.add(b);
	}
}
