package com.client.ui.deanUI;

import java.awt.Point;

import com.client.ui.deanUI.basicFrame.BasicFramePanel;
import com.client.ui.deanUI.coursePanel.CoursePanel;
import com.client.ui.deanUI.facultyPlan.FacultyPlanPanel;
import com.client.ui.deanUI.studentPanel.StudentIOPanel;
import com.client.ui.deanUI.teacherPanel.TeacherIOPanel;
import com.client.ui.main.MainFrame;



public class DeanUISwitchController {
	private static DeanUISwitchController controller = null;
	private static MainFrame frame=null;
	private DeanUISwitchController() {

	}
	public static DeanUISwitchController getUISwitchController(){
		if(controller==null){
			controller=new DeanUISwitchController();
		}
		if(frame==null){
			frame=new MainFrame();
			frame.refresh();
		}
		return controller;
	}
	public void swicthToMainFrame(){
		frame.getContentPane().removeAll();
		frame.add(new DeanMainPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	public void switchToBasicFramePanel(){
		frame.getContentPane().removeAll();
		frame.add(new BasicFramePanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	public void switchToCoursePanel(){
		frame.getContentPane().removeAll();
		frame.add(new CoursePanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	public void switchToFacultyPlanPanel(){
		frame.getContentPane().removeAll();
		frame.add(new FacultyPlanPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	public void switchToStudentPanel(){
		frame.getContentPane().removeAll();
		frame.add(new StudentIOPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	public void switchToTeacherPanel(){
		frame.getContentPane().removeAll();
		frame.add(new TeacherIOPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
}
