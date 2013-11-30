package com.ui.bcswing.courseEditPane;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MPanel;

public class CourseTimePanel extends MPanel {
	private static final Dimension default_size = new Dimension(400, 30);
	private MComboBox week;
	private MComboBox start;
	private MComboBox end;

	MButton timeB;
	MButton timeDB;

	public CourseTimePanel(Point loc) {
		super(new Dimension(default_size));
		this.setLocation(loc);
		creatComponent();
	}

	public void creatComponent() {
		String[] weekModel = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天" };
		week = new MComboBox(weekModel, new Point(40, 0), new Dimension(80, 20));

		String[] timeModel = { "第一节", "第二节", "第三节", "第四节", "第五节", "第六节", "第七节",
				"第八节", "第九节", "第十节" };
		start = new MComboBox(timeModel, new Point(130, 0), new Dimension(80,
				20));
		end = new MComboBox(timeModel, new Point(220, 0), new Dimension(80, 20));

		timeB = new MButton(null, null, null, new Point(310, 0), new Dimension(
				30, 20));
		timeB.setText("+");

		timeDB = new MButton(null, null, null, new Point(0, 0), new Dimension(
				30, 20));
		timeDB.setText("-");

		this.add(week);
		this.add(start);
		this.add(end);

		this.add(timeB);
		this.add(timeDB);
	}

	public void addActionListener(ActionListener al) {
		timeB.addActionListener(al);
	}

	public void addDeleteActionListener(ActionListener al) {
		timeDB.addActionListener(al);
	}
	
	public void setWeek(String week){
		this.week.setSelectedItem(week);
	}
	
	public void setStart(String start){
		this.start.setSelectedItem(start);
	}
	
	public void setEnd(String end){
		this.end.setSelectedItem(end);
	}
}
