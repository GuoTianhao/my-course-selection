package com.client.ui.facultyUI;


import java.awt.Point;

import com.client.ui.deanUI.DeanMainPanel;
import com.client.ui.main.MainFrame;

public class FacultyUISwitchController {
	private static FacultyUISwitchController controller = null;
	private static MainFrame frame=null;
	private FacultyUISwitchController() {

	}
	public static FacultyUISwitchController getUISwitchController(){
		if(controller==null){
			controller=new FacultyUISwitchController();
		}
		if(frame==null){
			frame=new MainFrame();
		}
		return controller;
	}
	public void swicthToMainFrame(){
		frame.getContentPane().removeAll();
	//	frame.add(new FacultyMainPanel(new Point(0,0),frame.getSize()));
		frame.refresh();
	}

}
