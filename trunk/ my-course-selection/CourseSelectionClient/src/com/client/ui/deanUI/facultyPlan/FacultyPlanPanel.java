package com.client.ui.deanUI.facultyPlan;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.deanUI.studentPanel.StudentIOPanel;
import com.client.ui.main.MainFrame;
import com.ui.bcswing.FrameDisplayTable;
import com.ui.bcswing.MScrollTabel;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class FacultyPlanPanel extends MPanel{
	private TitleBar title;
	private MLabel choose;
	private MComboBox<String> department;
	private FrameDisplayTable table;
	private String[] departmentItems = FacultyKind.getAllFaculty();
	private Object[] data;
	
	public FacultyPlanPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
		addListener();
	}
	
	private void createComponent() {
		title = new DeanTitlebar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		choose = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择院系：");
		department = new MComboBox<>(departmentItems, new Point(90, 95), new Dimension(150, 25));
		table = new FrameDisplayTable(new Point(10, 130), new Dimension(780,430));
		this.add(title);
		this.add(choose);
		this.add(department);
		this.add(table);
	}
	private void addListener(){
		title.addReturnMenu(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DeanUISwitchController controller=DeanUISwitchController.getUISwitchController();
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
		f.add(new FacultyPlanPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}
