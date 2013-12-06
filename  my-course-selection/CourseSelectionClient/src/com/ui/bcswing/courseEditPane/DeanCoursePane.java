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
		super();
		init();
		addListener();
		
	}
	private void addListener(){
		
		courseEdit.addConfirmListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				DeanMethod method=DeanMethodController.getMethod();
				Course nCourse=courseEdit.getCourse();
				try {
					Course oCourse=method.getCourse(nCourse.getID());
					if(oCourse==null){
						if(method.publishCourse(nCourse)){
							System.out.println("发布课程成功");
						}
					}else{
						nCourse.setScript(oCourse.getScript());
						nCourse.setTeacher(oCourse.getTeacher());
						nCourse.setFaculty(oCourse.getFaculty());
						if(method.modifyCourse(nCourse)){
							System.out.println("修改课程成功");
						}
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
	}
	private void init(){
		String[] typeModel = { "通识教育课程","体育课", "思想政治理论课程" ,"军事课程","通修课程"};
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
			DeanCoursePane pane=new DeanCoursePane();
			pane.setCourse(method.getCourse("0001"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
