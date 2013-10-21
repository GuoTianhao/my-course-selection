package com.client.ui.main;

import com.client.ui.deanUI.DeanMainPanel;

public class MainUISwitchController {
	private static MainUISwitchController controller = null;
	private static MainFrame frame=null;
	private MainUISwitchController() {

	}
	public static MainUISwitchController getUISwitchController(){
		if(controller==null){
			controller=new MainUISwitchController();
		}
		if(frame==null){
			frame=new MainFrame();
		}
		return controller;
	}
	public void switchToDeanMainPanel(){
		frame.add(new DeanMainPanel());
	}
}
