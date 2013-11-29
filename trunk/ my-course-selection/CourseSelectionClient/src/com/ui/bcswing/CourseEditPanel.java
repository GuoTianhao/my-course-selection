package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

import javax.swing.UIManager;

import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class CourseEditPanel extends MPanel {
	private static int default_height_add = 40;
	private MObservable observe;
	private MLabel namel;
	private MLabel idl;
	private MLabel locl;
	private MLabel creditl;
	private MLabel numl;
	private MLabel typel;
	private MLabel gradel;
//	private MLabel facultyl;
	private MLabel periodl;

	private MLabel timel;

	private MTextField namet;
	private MTextField idt;
	private MTextField loct;
	private MTextField creditt;
	private MTextField numt;
	private MComboBox typeSelect;
	private MTextField gradet;
//	private MTextField facultyt;
	private MTextField periodt;

	private String[] typeModel = { "通识教育课程", "思想政治理论课程" ,"军事课程","通修课程"};

	CourseTimePanel time;
	ArrayList<CourseTimePanel> timeList;

	ActionListener tbListener;
	ActionListener tdbListener;

	public CourseEditPanel(Point loc, Dimension size) {
		super(loc,size);
		creatComponent();
		addListener();
		init();
	}

	private void creatComponent() {
		namel = new MLabel(new Point(0, 0), new Dimension(100, 20), "课程名称:");
		idl = new MLabel(new Point(0, 30), new Dimension(100, 20), "课程编号:");
		locl = new MLabel(new Point(0, 60), new Dimension(100, 20), "上课地点:");
		creditl = new MLabel(new Point(0, 90), new Dimension(100, 20), "学分:");
		numl = new MLabel(new Point(0, 120), new Dimension(100, 20), "上课人数:");
		typel = new MLabel(new Point(0, 150), new Dimension(100, 20), "课程类型:");
		gradel = new MLabel(new Point(0, 180), new Dimension(100, 20), "年级:");
//		facultyl = new MLabel(new Point(0, 210), new Dimension(100, 20),
//				"课程院系:");
		periodl = new MLabel(new Point(0, 250), new Dimension(100, 20), "上课周数:");
		timel = new MLabel(new Point(0, 280), new Dimension(100, 20), "上课时间:");

		namet = new MTextField(new Point(150, 0), new Dimension(100, 20));
		idt = new MTextField(new Point(150, 30), new Dimension(100, 20));
		loct = new MTextField(new Point(150, 60), new Dimension(100, 20));
		creditt = new MTextField(new Point(150, 90), new Dimension(100, 20));
		numt = new MTextField(new Point(150, 120), new Dimension(100, 20));
		typeSelect = new MComboBox(typeModel, new Point(150, 150),
				new Dimension(100, 20));

		gradet = new MTextField(new Point(150, 180), new Dimension(100, 20));
//		facultyt = new MTextField(new Point(150, 210), new Dimension(100, 20));
		periodt = new MTextField(new Point(150, 250), new Dimension(100, 20));

		time = new CourseTimePanel(new Point(80, 280));
		timeList = new ArrayList<CourseTimePanel>();
		timeList.add(time);

		this.add(namel);
		this.add(idl);
		this.add(locl);
		this.add(creditl);
//		this.add(numl);
		this.add(typel);
		this.add(gradel);
//		this.add(facultyl);
		this.add(periodl);
		this.add(timel);

		this.add(namet);
		this.add(idt);
		this.add(loct);
		this.add(creditt);
//		this.add(numt);
		this.add(typeSelect);
		this.add(gradet);
//		this.add(facultyt);
		this.add(periodt);

		this.add(time);

		this.validate();
		this.repaint();
	}
	
	private void addListener(){
		tbListener = new TimeButtonListener();
		tdbListener = new TimeDeleteButtonListener();
		
		time.addActionListener(tbListener);
		time.addDeleteActionListener(tdbListener);

		typeSelect.addItemListener(new TypeItemListener());
	}
	
	private void init(){
		observe = new MObservable();
		typeSelect.setSelectedIndex(-1);
		typeSelect.setSelectedIndex(0);
	}
	
	public void setTypeModel(String[] typeModel){
		this.typeModel=typeModel;
	}

	class TimeButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Point loc = time.getLocation();
			time = new CourseTimePanel(new Point(loc.x, loc.y
					+ default_height_add));
			time.addActionListener(tbListener);
			time.addDeleteActionListener(tdbListener);
			timeList.add(time);
			CourseEditPanel.this.add(time);
			CourseEditPanel.this.setHeight(CourseEditPanel.this.getHeight()
					+ default_height_add);

		}

	}

	class TimeDeleteButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (timeList.size() > 1) {
				CourseTimePanel p;
				MButton b = (MButton) e.getSource();
				Iterator<CourseTimePanel> it = timeList.iterator();
				while (it.hasNext()) {
					p = it.next();
					if (p.timeDB == b) {
						it.remove();
						CourseEditPanel.this.remove(p);
						break;
					}
				}
				while (it.hasNext()) {
					p = it.next();
					Point loc = p.getLocation();
					p.setLocation(new Point(loc.x, loc.y - default_height_add));
				}
				it = timeList.iterator();
				while (it.hasNext()) {
					time = it.next();
				}

				CourseEditPanel.this.setHeight(CourseEditPanel.this.getHeight()
						- default_height_add);

			}
		}

	}

	class TypeItemListener implements ItemListener{
		int time=0;
		public void itemStateChanged(ItemEvent e) {
			time++;
			if(time%2==0){
				String selected=(String) typeSelect.getSelectedItem();
				if(selected.equals("通识教育课程")){
					CourseEditPanel.this.add(numl);
					CourseEditPanel.this.add(numt);
				}else{
					CourseEditPanel.this.remove(numl);
					CourseEditPanel.this.remove(numt);
				}
				CourseEditPanel.this.refresh();
			}
		}
		
	}
	
	public void setHeight(int height) {
		setChanged();
		notifyObservers(height - this.getSize().height);
		this.setSize(this.getSize().width, height);
		this.refresh();
	}

	public synchronized void addObserver(Observer o) {
		observe.addObserver(o);
	}

	public synchronized void deleteObserver(Observer o) {
		observe.deleteObserver(o);
	}

	public void notifyObservers() {
		observe.notifyObservers();
	}

	public void notifyObservers(Object arg) {
		observe.notifyObservers(arg);
	}

	public synchronized void deleteObservers() {
		observe.deleteObservers();
	}

	protected synchronized void setChanged() {
		observe.setChanged();
	}

	protected synchronized void clearChanged() {
		observe.clearChanged();
	}

	public synchronized boolean hasChanged() {
		return observe.hasChanged();
	}

	public synchronized int countObservers() {
		return observe.countObservers();
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MFrame f = new MFrame(new Dimension(500, 500));
		f.add(new CourseEditPanel(new Point(0, 0), f.getSize()));
		f.validate();
		f.setVisible(true);
	}
}
