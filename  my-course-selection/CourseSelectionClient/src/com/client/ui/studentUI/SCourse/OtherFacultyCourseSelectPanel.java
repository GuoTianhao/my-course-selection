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
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToBallotCourseTableVectorAdapter;
import com.client.ui.dataAdapter.CourseListToCourseTypeListAdapter;
import com.client.ui.dataAdapter.CourseListToFacultyAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;

public class OtherFacultyCourseSelectPanel extends BallotTableCourseSelectPanel {
	public OtherFacultyCourseSelectPanel(Point loc, Dimension size) {
		super(loc, size);
		refreshTable();
		addListener();
	}

	private void refreshTable() {
		Student student = (Student) Identity.getIdentity();
		StudentMethod method = StudentMethodController.getMethod();
		try {
			List<Course> list = method.getTypeCourse("F");
			list.addAll(method.getTypeCourse("E"));
			list = CourseListToFacultyAdapter.adapterReverse(list,
					student.getFaculty());
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

	private void addListener() {
		confirm.addActionListener(new CourseSelectListener());
	}

	private List<Course> getWaitCourse() {
		Student student = (Student) Identity.getIdentity();
		StudentMethod method = StudentMethodController.getMethod();
		List<Course> wait = new LinkedList<Course>();
		try {
			List<Course> temp = method.getWaitCourseList(student.getID());
			wait = CourseListToCourseTypeListAdapter.adapter(temp, "F");
			wait.addAll(CourseListToCourseTypeListAdapter.adapter(temp, "E"));
			wait = CourseListToFacultyAdapter.adapterReverse(wait,
					student.getFaculty());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return wait;
	}

	class CourseSelectListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			List<Course> wait = getWaitCourse();
			if (quitCourse(wait.iterator()) && selectCourse()) {
				System.out.println("选课成功");
				refreshTable();
			} else {
				System.out.println("选课失败");
				refreshTable();
			}
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
		controller.switchToOtherFacultyCourseSelect();
	}

}
