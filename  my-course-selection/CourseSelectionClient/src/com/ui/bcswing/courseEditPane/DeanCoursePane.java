package com.ui.bcswing.courseEditPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.UIManager;

import com.client.rmi.DeanMethodController;
import com.client.ui.deanUI.DeanUISwitchController;
import com.data.po.Course;
import com.logicService.DeanMethod;
import com.ui.bcswing.TipFrame;
import com.ui.bcswing.basicFrameEditPane.BasicFrameEditPane;

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
				DeanUISwitchController controller=DeanUISwitchController.getUISwitchController();
				Course nCourse=getCourse();
				try {
					TipFrame t;
					Course oCourse=method.getCourse(nCourse.getID());
					if(oCourse==null){
						if(method.publishCourse(nCourse)){
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"发布课程成功");
							notifyMObserver();
							dispose();
						}else{
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"课程发布失败");
						}
					}else{
						nCourse.setScript(oCourse.getScript());
						nCourse.setTeacher(oCourse.getTeacher());
						nCourse.setFaculty(oCourse.getFaculty());
						if(method.modifyCourse(nCourse)){
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"课程修改成功");
							notifyMObserver();
							dispose();
						}else{
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"课程发布修改失败");
						}
					}
					t.startEndClock();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
	}
	
	public void addConfirmListener(ActionListener al){
		courseEdit.addConfirmListener(al);
	}
	
	public Course getCourse(){
		return courseEdit.getCourse();
	}
	
	private void init(){
		String[] typeModel = { "通识教育课程","体育课", "思想政治理论课程" ,"军事课程","分层次通修课程"};
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
