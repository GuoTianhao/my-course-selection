package com.client.ui.deanUI.coursePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import com.client.rmi.DeanMethodController;
import com.client.ui.dataAdapter.TeacherListToVectorAdapter;
import com.data.po.Course;
import com.data.po.Teacher;
import com.logicService.DeanMethod;
import com.ui.bcswing.teacherDisplayPane.TeacherAssignmentDisplayPane;

public class DeanCourseTeacherAssignmentDisplayPane extends
		TeacherAssignmentDisplayPane {
	String courseID = "";

	public DeanCourseTeacherAssignmentDisplayPane(String courseID) {
		this.courseID = courseID;
		init();
	}

	protected void init() {
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		DeanMethod method = DeanMethodController.getMethod();
		try {
			Course c = method.getCourse(courseID);

			List<Teacher> courseTeacher = c.getTeacher();

			List<String> idList = new LinkedList<String>();
			Iterator<Teacher> it = courseTeacher.iterator();
			while (it.hasNext()) {
				idList.add(it.next().getID());
			}

			List<Teacher> teacherList = method.getAllTeacher();

			table.setDataVector(TeacherListToVectorAdapter.adapter(teacherList));
			table.setSelectIntervalRowByContent(idList, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	protected void addListener(){
		confirm.addActionListener(new ConfirmListener());
	}

	class ConfirmListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			DeanMethod method = DeanMethodController.getMethod();
			try {

				List<Teacher> list = new LinkedList<Teacher>();
				int[] rows = table.getSelectedRows();
				for (int i = 0; i < rows.length; i++) {
					String teacherID = (String) table.getValueAt(rows[i], 0);
					list.add(method.getTeacher(teacherID));
				}
				
				Course c = method.getCourse(courseID);
				c.setTeacher(list);

				if(method.modifyCourse(c)){
					System.out.println("成功");
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new DeanCourseTeacherAssignmentDisplayPane("0001");
	}
}
