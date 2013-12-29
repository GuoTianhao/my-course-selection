package com.ui.bcswing.courseEditPane;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.data.po.Course;
import com.ui.bcswing.MScrollForm;

public class CourseEditPane extends MScrollForm {
	Dimension default_size = new Dimension(530, 500);
	protected CourseEditPanel courseEdit;
	protected List<MObserver> list;
	public CourseEditPane() {
		super();
		this.setLocationRelativeTo(null);
		this.setSize(default_size);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		list=new ArrayList<MObserver>();
		addComponent();
	}

	public CourseEditPane(Dimension size) {
		super(size);
		addComponent();
	}

	public void addObserver(MObserver o){
		list.add(o);
	}
	
	public void notifyMObserver(){
		Iterator<MObserver> it=list.iterator();
		while(it.hasNext()){
			it.next().update();
		}
	}

	
	private void addComponent() {
		courseEdit = new CourseEditPanel(new Point(0, 0), this.getSize());
		courseEdit.addObserver(this);
		this.addContent(courseEdit);
		this.refresh();
		this.setVisible(true);

	}

	public void setCourse(Course c) {
		courseEdit.setCourse(c);
	}

	public Course getCourse() {
		return courseEdit.getCourse();
	}
	
	protected boolean isCourseValid(Course c){
		if(c.getCredit()>10||c.getCredit()<0){
			return false;
		}
		if(c.getGrade()<0||c.getGrade()>8){
			return false;
		}
		if(c.getNum()<0){
			return false;
		}
		return true;
	}

	public void addConfirmListener(ActionListener al) {
		courseEdit.addConfirmListener(al);
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new CourseEditPane();
	}
}
