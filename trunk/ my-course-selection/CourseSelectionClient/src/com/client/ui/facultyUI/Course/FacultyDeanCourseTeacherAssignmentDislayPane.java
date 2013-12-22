package com.client.ui.facultyUI.Course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import com.client.rmi.FacultyDeanMethodController;
import com.client.ui.dataAdapter.TeacherListToVectorAdapter;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.data.po.Course;
import com.data.po.Teacher;
import com.logicService.FacultyDeanMethod;
import com.ui.bcswing.TipFrame;
import com.ui.bcswing.teacherDisplayPane.TeacherAssignmentDisplayPane;

public class FacultyDeanCourseTeacherAssignmentDislayPane extends
		TeacherAssignmentDisplayPane {
	String courseID = "";
	String facultyID = "";

	public FacultyDeanCourseTeacherAssignmentDislayPane(String courseID,
			String facultyID) {
		this.courseID = courseID;
		this.facultyID = facultyID;
		init();
	}

	protected void init() {
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
		try {
			Course c = method.getCourse(courseID);

			List<Teacher> courseTeacher = c.getTeacher();

			List<String> idList = new LinkedList<String>();
			Iterator<Teacher> it = courseTeacher.iterator();
			while (it.hasNext()) {
				idList.add(it.next().getID());
			}

			List<Teacher> teacherList = method.getFacultyTeacher(facultyID);

			table.setDataVector(TeacherListToVectorAdapter.adapter(teacherList));
			table.setSelectIntervalRowByContent(idList, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	protected void addListener() {
		confirm.addActionListener(new ConfirmListener());
	}

	class ConfirmListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
			try {

				List<Teacher> list = new LinkedList<Teacher>();
				int[] rows = table.getSelectedRows();
				for (int i = 0; i < rows.length; i++) {
					String teacherID = (String) table.getValueAt(rows[i], 0);
					list.add(method.getTeacher(teacherID));
				}

				Course c = method.getCourse(courseID);
				c.setTeacher(list);
				FacultyUISwitchController controller = FacultyUISwitchController
						.getUISwitchController();
				TipFrame t;
				if (method.modifyCourse(c)) {
					t = new TipFrame(controller.getLoc(), controller.getSize(),
							5, "指定老师成功");
					t.startEndClock();
					dispose();

				}else{
					t = new TipFrame(controller.getLoc(), controller.getSize(),
							5, "指定老师失败");
					t.startEndClock();
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
		new FacultyDeanCourseTeacherAssignmentDislayPane("0001","1025");
	}
}
