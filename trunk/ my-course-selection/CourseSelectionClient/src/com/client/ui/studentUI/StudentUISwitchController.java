package com.client.ui.studentUI;

import java.awt.Point;

import com.client.ui.loginUI.Login;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.CScore.ScoreCheckPanel;
import com.client.ui.studentUI.MCourse.MyCoursePanel;
import com.client.ui.studentUI.SCourse.CourseSelectedPanel;
import com.client.ui.studentUI.lCourse.CourseLookUpPanel;

public class StudentUISwitchController {
	private static StudentUISwitchController controller = null;
	private static MainFrame frame=null;
	private StudentUISwitchController() {

	}
	public static StudentUISwitchController getUISwitchController(){
		if(controller==null){
			controller=new StudentUISwitchController();
		}
		if(frame==null){
			frame=new MainFrame();
		}
		return controller;
	}
	
	public void switchToMainFrame() {
		frame.getContentPane().removeAll();
		frame.add(new StudentMainPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToScoreCheck(){
		frame.getContentPane().removeAll();
		frame.add(new ScoreCheckPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToAllCourse(){
		frame.getContentPane().removeAll();
		frame.add(new CourseLookUpPanel(new Point(0,0),frame.getSize()));
		frame.refresh();

	}
	
	public void switchToMCourse(){
		frame.getContentPane().removeAll();
		frame.add(new MyCoursePanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToSCourse(){
		frame.getContentPane().removeAll();
		frame.add(new CourseSelectedPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	public void dispose(){
		if (frame != null) {
			frame.dispose();
			frame=null;
		}
	}
}
