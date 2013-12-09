package com.client.ui.studentUI.SCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.rmi.DeanMethodController;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToBallotCourseTableVectorAdapter;
import com.client.ui.dataAdapter.CourseListToCourseTypeListAdapter;
import com.client.ui.dataAdapter.CourseListToFacultyAdapter;
import com.client.ui.dataAdapter.PECourseSelectListToVectorAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.data.po.Teacher;
import com.logicService.DeanMethod;
import com.logicService.StudentMethod;

public class LiberalCourseSelectPanel extends BallotTableCourseSelectPanel {
	public LiberalCourseSelectPanel(Point loc, Dimension size) {
		super(loc, size);
		refreshTable();
		addListener();
	}

	private void refreshTable() {
		Student student = (Student) Identity.getIdentity();
		StudentMethod method = StudentMethodController.getMethod();
		try {
			List<Course> list = method.getTypeCourse("A");
			List<Course> wait = getWaitCourse();

			List<String> idList = new LinkedList<String>();
			Iterator<Course> it = wait.iterator();
			while (it.hasNext()) {
				idList.add(it.next().getID());
			}

			table.setDataVector(CourseListToBallotCourseTableVectorAdapter
					.adapter(list));
			setSelectIntervalRowByContent(idList, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private List<Course> getWaitCourse() {
		Student student = (Student) Identity.getIdentity();
		StudentMethod method = StudentMethodController.getMethod();
		List<Course> wait = null;
		try {
			wait = method.getWaitCourseList(student.getID());
			wait = CourseListToCourseTypeListAdapter.adapter(wait, "A");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return wait;
	}

	private void addListener() {
		confirm.addActionListener(new CourseSelectListener());
	}

	class CourseSelectListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			List<Course> wait = getWaitCourse();
			if (quitCourse(wait.iterator()) && selectCourse()) {
				System.out.println("选课成功");
			} else {
				System.out.println("选课失败");
			}
			refreshTable();
		}

	}

	public static void main(String[] args) {
		try {
			Identity.setIdentity(StudentMethodController.getMethod().getSelf(
					"121250011"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StudentUISwitchController controller = StudentUISwitchController
				.getUISwitchController();
		controller.switchToLiberalSelect();
	}
}
