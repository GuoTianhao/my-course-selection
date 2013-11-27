package com.client.ui.facultyUI.Course;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.client.rmi.FacultyDeanMethodController;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.client.ui.main.MainFrame;
import com.data.po.Course;
import com.logicService.FacultyDeanMethod;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.CourseEditPane;
import com.ui.bcswing.titleBar.FacultyTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseManagementPanel extends MPanel{

	private TitleBar title;
	private MButton button1;
	private MButton button2;
	private CourseDisplayTable table;
	private Object[] data;
	
	public CourseManagementPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
		addListener();
	}
	
	private void createComponent() {
		title = new FacultyTitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		button1=new MButton(null,null,null,new Point(15, 95),new Dimension(100, 25));
		button1.setText("添加课程");
		button2=new MButton(null,null,null,new Point(130, 95),new Dimension(50, 25));
		button2.setText("编辑");
		table = new CourseDisplayTable(new Point(10, 130), new Dimension(780,430));
		this.add(title);
		this.add(button1);
		this.add(button2);
		
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
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CourseEditPane();
			}

		});
		
		button2.addActionListener(new CourseModifyListener());
	}
	
	class CourseModifyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
			int index = table.getSelectedRow();
			if (index >= 0) {
				String id = (String) table.getValueAt(index, 0);
				try {
					Course c = method.getCourse(id);
					CourseEditPane pane = new CourseEditPane();
					pane.setCourse(c);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

			}
		}
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
