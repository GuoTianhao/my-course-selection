package com.client.ui.facultyUI.teachingPlan;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.ui.myswing.MPanel;
import com.ui.myswing.MButton;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.TitleBar;

public class TeachingPlanPanel extends MPanel{
	private TitleBar title;
	private MButton add;
	private MButton change;
	private MButton delete;
	private CourseDisplayTable table;
	
	public TeachingPlanPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
	}
	
	private void createComponent() {
		title = new TitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		table = new CourseDisplayTable(new Point(10, 130), new Dimension(780,430));
		add = new MButton(new ImageIcon(),new ImageIcon(),new ImageIcon(),new Point(15,95),new Dimension(100,30));
		change = new MButton(null,null,null,new Point(130,95),new Dimension(40,30));
		delete = new MButton(null,null,null,new Point(185,95),new Dimension(40,30));
		
		this.add(title);
		this.add(add);
		this.add(change);
		this.add(delete);
		this.add(table);
	}
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		f.add(new TeachingPlanPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
