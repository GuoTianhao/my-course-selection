package com.client.ui.studentUI;

import java.awt.Point;

import com.client.ui.loginUI.Login;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.BSCourse.BySelectionCoursePanel;
import com.client.ui.studentUI.CScore.ScoreCheckPanel;
import com.client.ui.studentUI.MCourse.MyCoursePanel;
import com.client.ui.studentUI.QCourse.QuitCoursePanel;
import com.client.ui.studentUI.SCourse.CourseSelectPanel;
import com.client.ui.studentUI.SCourse.ElectiveCourseSelectPanel;
import com.client.ui.studentUI.SCourse.LiberalCourseSelectPanel;
import com.client.ui.studentUI.SCourse.OtherFacultyCourseSelectPanel;
import com.client.ui.studentUI.SCourse.PECourseSelectPanel;
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
	
	public void switchToQCourse(){
		frame.getContentPane().removeAll();
		frame.add(new QuitCoursePanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToBSCourse(){
		frame.getContentPane().removeAll();
		frame.add(new BySelectionCoursePanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToCourseSelect(){
		frame.getContentPane().removeAll();
		frame.add(new CourseSelectPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToPESelect(){
		frame.getContentPane().removeAll();
		frame.add(new PECourseSelectPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToLiberalSelect(){
		frame.getContentPane().removeAll();
		frame.add(new LiberalCourseSelectPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToElectiveCourseSelec(){
		frame.getContentPane().removeAll();
		frame.add(new ElectiveCourseSelectPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public void switchToOtherFacultyCourseSelect(){
		frame.getContentPane().removeAll();
		frame.add(new OtherFacultyCourseSelectPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}
	
	public Point getLoc(){
		return frame.getLocation();
	}
	
	public void dispose(){
		if (frame != null) {
			frame.dispose();
			frame=null;
		}
	}
}
