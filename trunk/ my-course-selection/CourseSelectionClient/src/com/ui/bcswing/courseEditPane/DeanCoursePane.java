package com.ui.bcswing.courseEditPane;

import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.client.rmi.DeanMethodController;
import com.logicService.DeanMethod;

public class DeanCoursePane extends CourseEditPane{
	public DeanCoursePane(){
		String[] typeModel = { "通识教育课程", "思想政治理论课程" ,"军事课程","通修课程"};
		courseEdit.setTypeModel(typeModel);
		courseEdit.initType();
	}
	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DeanMethod method=DeanMethodController.getMethod();
		try {
			new DeanCoursePane().setCourse(method.getCourse(""));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
