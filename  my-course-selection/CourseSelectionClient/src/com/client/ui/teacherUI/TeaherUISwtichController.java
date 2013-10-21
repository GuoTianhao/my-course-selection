package com.client.ui.teacherUI;

import com.client.ui.main.MainFrame;

public class TeaherUISwtichController {
	private static TeaherUISwtichController controller = null;
	private static MainFrame frame=null;
	private TeaherUISwtichController() {

	}
	public static TeaherUISwtichController getUISwitchController(){
		if(controller==null){
			controller=new TeaherUISwtichController();
		}
		if(frame==null){
			frame=new MainFrame();
		}
		return controller;
	}

}
