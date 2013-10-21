package com.client.ui.deanUI;

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
		}
		return controller;
	}
	
}
