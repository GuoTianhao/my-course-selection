package com.client.ui.facultyUI;


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
}
