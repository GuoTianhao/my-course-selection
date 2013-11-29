package com.client.ui.studentUI.SCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToCourseTermListAdapter;
import com.client.ui.dataAdapter.GradeToTermAdapter;
import com.client.ui.dataAdapter.StudentSelectedCourseListToVectorAdapter;
import com.client.ui.dataAdapter.StudentUnselectedCourseListToVectorAdapeter;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.StudentSelectedCourseDisplayTable;
import com.ui.bcswing.StudentUnselectedCourseDisplayTable;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class CourseSelectedPanel extends MPanel {
	private TitleBar title;
	private MButton select;
	private MButton quit;
	private MLabel label;
	private StudentUnselectedCourseDisplayTable table1;
	private StudentSelectedCourseDisplayTable table2;
	private MComboBox<String> courseType;

	private String[] type = { "选修课程", "通识课程", "跨院系课程" };

	public CourseSelectedPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		select = new MButton(null, null, null, new Point(360, 95),
				new Dimension(50, 25));
		select.setText("选择");
		quit = new MButton(null, null, null, new Point(720, 95), new Dimension(
				50, 25));
		quit.setText("推选");
		label = new MLabel(new Point(430, 95), new Dimension(75, 22), "已选课程");
		table2 = new StudentSelectedCourseDisplayTable(new Point(430, 130),
				new Dimension(350, 430));
		table1 = new StudentUnselectedCourseDisplayTable(new Point(10, 130),
				new Dimension(400, 430));

		courseType = new MComboBox<>(type, new Point(90, 95), new Dimension(
				150, 25));

		this.add(title);
		this.add(select);
		this.add(quit);
		this.add(label);
		this.add(table2);
		this.add(table1);
		this.add(courseType);
		this.refresh();
	}

	private void addListener() {

		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUISwitchController controller = StudentUISwitchController
						.getUISwitchController();
				controller.switchToMainFrame();
			}
		});

		courseType.addItemListener(new CourseTypeListener());

		select.addActionListener(new SelectListener());

		quit.addActionListener(new QuitListener());
	}

	private void init() {

		courseType.setSelectedIndex(-1);
		courseType.setSelectedIndex(0);

		refreshSelectedTable();

	}

	private void refreshSelectedTable() {
		Student student = (Student) (Identity.getIdentity());
		StudentMethod method = StudentMethodController.getMethod();
		List<Course> selected = new ArrayList<Course>();
		try {
			selected = method.getCourseList(student.getID());
			selected = CourseListToCourseTermListAdapter.adapter(selected,
					GradeToTermAdapter.adapter(student.getGrade()));
			table2.setDataVector(StudentSelectedCourseListToVectorAdapter
					.adapter(selected));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	class CourseTypeListener implements ItemListener {
		int time = 0;

		public void itemStateChanged(ItemEvent e) {
			time++;
			if (time % 2 == 0) {
				String type = (String) courseType.getSelectedItem();
				List<Course> list = CourseTypeHandle.handle(type);
				table1.setDataVector(StudentUnselectedCourseListToVectorAdapeter
						.adapter(list));
			}
		}

	}

	class SelectListener implements ActionListener {

		Student student = (Student) (Identity.getIdentity());

		public void actionPerformed(ActionEvent e) {
			int index = table1.getSelectedRow();
			if (index >= 0) {
				String cID = (String) table1.getValueAt(index, 0);
				StudentMethod method = StudentMethodController.getMethod();
				try {
					boolean admit = method.selectCourse(student.getID(), cID);
					if (admit) {
						System.out.println("选课成功");
					} else {
						System.out.println("选课失败");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				CourseSelectedPanel.this.refreshSelectedTable();
			}
		}

	}

	class QuitListener implements ActionListener {

		Student student = (Student) (Identity.getIdentity());

		public void actionPerformed(ActionEvent e) {
			int index = table2.getSelectedRow();
			if (index >= 0) {
				String cID = (String) table1.getValueAt(index, 0);
				StudentMethod method = StudentMethodController.getMethod();

				try {
					boolean admit = method.quitCourse(student.getID(), cID);
					if (admit) {
						System.out.println("退选成功");
					} else {
						System.out.println("退选失败");
					}

				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

				CourseSelectedPanel.this.refreshSelectedTable();
			}
		}

	}

	public static void main(String[] args) {
		try {
			Identity.setIdentity(StudentMethodController.getMethod().getSelf(
					"0000"));
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
		controller.switchToSCourse();
	}
}
