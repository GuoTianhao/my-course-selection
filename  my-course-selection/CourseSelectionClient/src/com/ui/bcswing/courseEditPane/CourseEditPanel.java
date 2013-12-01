package com.ui.bcswing.courseEditPane;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

import com.basicdata.CourseTimeKind;
import com.basicdata.CourseTypeKind;
import com.data.po.Course;
import com.data.po.Teacher;
import com.ui.bcswing.MObservable;
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
	private MLabel periodl;

	private MLabel timel;

	private MTextField namet;
	private MTextField idt;
	private MTextField loct;
	private MTextField creditt;
	private MTextField numt;
	private MComboBox typeSelect;
	private MTextField gradet;
	private MTextField periodt;

	private MButton confirm;

	private String[] typeModel = { "NONE" };

	CourseTimePanel time;
	ArrayList<CourseTimePanel> timeList;

	public CourseEditPanel(Point loc, Dimension size) {
		super(loc, size);
		creatComponent();
		addListener();
		init();
	}

	private void creatComponent() {
		namel = new MLabel(new Point(0, 0), new Dimension(100, 20), "课程名称:");
		idl = new MLabel(new Point(0, 30), new Dimension(100, 20), "课程编号:");
		locl = new MLabel(new Point(0, 210), new Dimension(100, 20), "上课地点:");
		creditl = new MLabel(new Point(0, 90), new Dimension(100, 20), "学分:");
		numl = new MLabel(new Point(0, 150), new Dimension(100, 20), "上课人数:");
		typel = new MLabel(new Point(0, 60), new Dimension(100, 20), "课程类型:");
		gradel = new MLabel(new Point(0, 120), new Dimension(100, 20), "年级:");
		periodl = new MLabel(new Point(0, 180), new Dimension(100, 20), "上课周数:");
		timel = new MLabel(new Point(0, 240), new Dimension(100, 20), "上课时间:");

		namet = new MTextField(new Point(150, 0), new Dimension(100, 20));
		idt = new MTextField(new Point(150, 30), new Dimension(100, 20));
		loct = new MTextField(new Point(150, 210), new Dimension(100, 20));
		creditt = new MTextField(new Point(150, 90), new Dimension(100, 20));
		numt = new MTextField(new Point(150, 150), new Dimension(100, 20));
		typeSelect = new MComboBox(typeModel, new Point(150, 60),
				new Dimension(100, 20));

		gradet = new MTextField(new Point(150, 120), new Dimension(100, 20));
		periodt = new MTextField(new Point(150, 180), new Dimension(100, 20));

		confirm = new MButton(null, null, null, new Point(80, 240),
				new Dimension(100, 20));
		confirm.setText("确定");

		time = new CourseTimePanel(new Point(80, 210));
		timeList = new ArrayList<CourseTimePanel>();
		

		this.add(namel);
		this.add(idl);
		this.add(locl);
		this.add(creditl);
		this.add(typel);
		this.add(numl);
		this.add(periodl);
		this.add(timel);
		this.add(gradel);

		this.add(namet);
		this.add(idt);
		this.add(loct);
		this.add(creditt);
		this.add(typeSelect);
		this.add(periodt);
		this.add(numt);
		this.add(confirm);
		this.add(gradet);


		this.validate();
		this.repaint();
	}

	protected void addListener() {

		observe = new MObservable();

		typeSelect.addItemListener(new TypeItemListener());

		new TimeButtonListener().actionPerformed(null);
	}

	protected void init() {

	}

	protected void initType() {
		typeSelect.setSelectedIndex(-1);
		typeSelect.setSelectedIndex(0);
	}

	protected void setTypeModel(String[] typeModel) {
		this.typeModel = typeModel;
		typeSelect.setModel(new DefaultComboBoxModel<String>(typeModel));
	}

	public void setCourse(Course c) {
		namet.setText(c.getName());
		idt.setText(c.getID());
		loct.setText(c.getLoc());
		creditt.setText(c.getCredit() + "");
		numt.setText(c.getNum() + "");
		gradet.setText(c.getGrade() + "");
		periodt.setText(c.getPeriod());
		typeSelect.setSelectedItem(CourseTypeKind.getName(c.getType()));

		List<String> courseTime = c.getTime();
		Iterator<String> it = courseTime.iterator();
		Iterator<String> timeIt;
		while (it.hasNext()) {
			timeIt = CourseTimeKind.getSeperateTime(it.next());
			time.setWeek(timeIt.next());
			time.setStart(timeIt.next());
			time.setEnd(timeIt.next());
			if (it.hasNext()) {
				new TimeButtonListener().actionPerformed(null);
			}
		}
	}

	public Course getCourse() {
		Course c;
		String name = namet.getText();
		String id = idt.getText();
		String loc = loct.getText();
		int credit = Integer.parseInt(creditt.getText());
		int num = Integer.parseInt(numt.getText());
		int grade = Integer.parseInt(gradet.getText());
		String period = periodt.getText();
		String type = CourseTypeKind.getType((String) typeSelect
				.getSelectedItem());

		List<String> time = new LinkedList<String>();
		Iterator<CourseTimePanel> it = timeList.iterator();
		CourseTimePanel timePanel;
		while (it.hasNext()) {
			timePanel = it.next();
			List<String> seperateTime = new LinkedList<String>();
			seperateTime.add(timePanel.getWeek());
			seperateTime.add(timePanel.getStart());
			seperateTime.add(timePanel.getEnd());
			time.add(CourseTimeKind.getTime(seperateTime.iterator()));
		}
		c = new Course(id, name, loc, type, grade, period, null, null, num,
				credit, time, null);
		return c;
	}

	public void setHeight(int height) {
		setChanged();
		notifyObservers(height - this.getSize().height);
		this.setSize(this.getSize().width, height);
		this.refresh();
	}

	public void addConfirmListener(ActionListener al) {
		confirm.addActionListener(al);
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

	class TimeButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Point loc = time.getLocation();
			time = new CourseTimePanel(new Point(loc.x, loc.y
					+ default_height_add));
			time.addActionListener(new TimeButtonListener());
			time.addDeleteActionListener(new TimeDeleteButtonListener());
			timeList.add(time);
			CourseEditPanel.this.add(time);
			CourseEditPanel.this.setHeight(CourseEditPanel.this.getHeight()
					+ default_height_add);
			loc = confirm.getLocation();
			confirm.setLocation(loc.x, loc.y + default_height_add);

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

				Point loc = confirm.getLocation();
				confirm.setLocation(loc.x, loc.y - default_height_add);
			}
		}

	}

	class TypeItemListener implements ItemListener {
		int time = 0;

		public void itemStateChanged(ItemEvent e) {
			time++;
			System.out.println(time);
			if (time % 2 == 0) {
				String selected = (String) typeSelect.getSelectedItem();
				switch (selected) {
				case "通识教育课程":
					gradet.setText("");
					gradet.disable();
					numt.enable();
					loct.enable();
					CourseEditPanel.this.time.setEnabled(true);
					break;
				default:
					numt.setText("");
					loct.setText("");
					numt.disable();
					loct.disable();
					gradet.enable();
					
					Iterator<CourseTimePanel> it = timeList.iterator();
					while (it.hasNext()) {
						CourseEditPanel.this.remove(it.next());
						it.remove();
					}
					
					CourseEditPanel.this.time = new CourseTimePanel(new Point(
							80, 240));
					CourseEditPanel.this.time
							.addActionListener(new TimeButtonListener());
					CourseEditPanel.this.time
							.addDeleteActionListener(new TimeDeleteButtonListener());
					timeList.add(CourseEditPanel.this.time);
					CourseEditPanel.this.add(CourseEditPanel.this.time);
					CourseEditPanel.this.time.setEnabled(false);
					
					confirm.setLocation(new Point(80, 270));
				}
				System.out.println(selected);
				CourseEditPanel.this.refresh();
			}
		}

	}

}
