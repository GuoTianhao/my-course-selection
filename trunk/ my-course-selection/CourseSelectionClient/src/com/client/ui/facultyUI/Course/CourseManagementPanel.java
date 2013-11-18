package com.client.ui.facultyUI.Course;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import com.client.ui.facultyUI.FacultyUISwitchController;
import com.client.ui.main.MainFrame;
import com.ui.bcswing.FrameDisplayTable;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseManagementPanel extends MPanel{

	private TitleBar title;
	private MButton button1;
	private MButton button2;
	private MButton button3;
	private FrameDisplayTable table;
	private Object[] data;
	
	public CourseManagementPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
		addListener();
	}
	
	private void createComponent() {
		title = new TitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		button1=new MButton(null,null,null,new Point(15, 95),new Dimension(100, 25));
		button1.setText("添加课程");
		button2=new MButton(null,null,null,new Point(130, 95),new Dimension(50, 25));
		button2.setText("编辑");
		button3=new MButton(null,null,null,new Point(195, 95),new Dimension(50, 25));
		button3.setText("删除");
		table = new FrameDisplayTable(new Point(10, 130), new Dimension(780,430));
		this.add(title);
		this.add(button1);
		this.add(button2);
		this.add(button3);

		this.add(table);
	}
	
	private void addListener(){
		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyUISwitchController controller = FacultyUISwitchController
						.getUISwitchController();
				controller.swicthToMainFrame();
			}
		});
	}
	
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		f.add(new CourseManagementPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
