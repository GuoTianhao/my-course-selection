package com.client.ui.teacherUI;

import java.awt.Point;

import com.client.ui.main.MainFrame;
import com.client.ui.teacherUI.CourseMagagement.CourseManagementPanel;
import com.client.ui.teacherUI.CourseMagagement.CourseScoreRecordPanel;

public class TeatherUISwtichController {
	private static TeatherUISwtichController controller = null;
	private static MainFrame frame=null;
	private TeatherUISwtichController() {

	}
	public static TeatherUISwtichController getUISwitchController(){
		if(controller==null){
			controller=new TeatherUISwtichController();
		}
		if(frame==null){
			frame=new MainFrame();
		}
		return controller;
	}
	
	public void switchToMainFrame() {
		frame.getContentPane().removeAll();
		frame.add(new TeacherMainPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToCourseManagement(){
		frame.getContentPane().removeAll();
		frame.add(new CourseManagementPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public CourseScoreRecordPanel switchToRecordScore(){
		frame.getContentPane().removeAll();
		CourseScoreRecordPanel panel=new CourseScoreRecordPanel(new Point(0,0),frame.getSize());
		frame.add(panel);
		frame.refresh();
		return panel;
	}

	public void dispose(){
		if (frame != null) {
			frame.dispose();
			frame=null;
		}
	}
}
