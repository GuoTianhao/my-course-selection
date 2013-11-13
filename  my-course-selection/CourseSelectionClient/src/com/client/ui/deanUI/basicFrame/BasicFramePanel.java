package com.client.ui.deanUI.basicFrame;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.ui.myswing.MPanel;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;

public class BasicFramePanel extends MPanel{
	private TitleBar title;	
	private CourseDisplayTable table;
    private MButton make;
    private MButton change;
	private Object[] data;
	
	public BasicFramePanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
	}
	
	private void createComponent() {
		title = new TitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		table = new CourseDisplayTable(new Point(10, 130), new Dimension(780,430));
		make = new MButton(null,null,null,new Point(15,95),new Dimension(100,30));
		change = new MButton(null,null,null,new Point(130,95),new Dimension(100,30));

		this.add(title);
		this.add(bmake);
		this.add(bchange);
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
		f.add(new BasicFramePanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
