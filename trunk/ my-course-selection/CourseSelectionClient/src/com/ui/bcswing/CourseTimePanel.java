package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MPanel;

public class CourseTimePanel extends MPanel{
	private static final Dimension default_size=new Dimension(400,30);
	MComboBox week;
	MComboBox start;
	MComboBox end;

	MButton timeB;
	public CourseTimePanel(Point loc){
		super(new Dimension(default_size));
		this.setLocation(loc);
		creatComponent();
	}
	public void creatComponent(){
		String[] weekModel = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天" };
		week = new MComboBox(weekModel, new Point(90,0), new Dimension(80,
				20));

		String[] timeModel = { "第一节", "第二节", "第三节", "第四节", "第五节", "第六节", "第七节",
				"第八节", "第九节", "第十节" };
		start= new MComboBox(timeModel, new Point(180,0), new Dimension(80,
				20));
		end=new MComboBox(timeModel, new Point(270,0), new Dimension(80,
				20));
		
		timeB=new MButton(null,null,null,new Point(360,0),new Dimension(30,20));
		timeB.setText("+");
		
		this.add(week);
		this.add(start);
		this.add(end);
		
		this.add(timeB);
	}
}
