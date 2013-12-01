package com.ui.bcswing.courseEditPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.client.rmi.DeanMethodController;
import com.data.po.Course;
import com.logicService.DeanMethod;

public class DeanCoursePane extends CourseEditPane{
	public DeanCoursePane(){
		String[] typeModel = { "通识教育课程", "思想政治理论课程" ,"军事课程","通修课程"};
		courseEdit.setTypeModel(typeModel);
		courseEdit.initType();
		courseEdit.addConfirmListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Course c;
				c=courseEdit.getCourse();
			}
			
		});
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
			DeanCoursePane pane=new DeanCoursePane();
			pane.setCourse(method.getCourse(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
