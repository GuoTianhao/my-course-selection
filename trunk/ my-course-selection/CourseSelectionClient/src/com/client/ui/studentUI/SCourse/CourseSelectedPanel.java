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
import com.basicdata.StudentSelectCourseType;
import com.basicdata.TermKind;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToFacultyAdapter;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.StudentCourseDisplayTable;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class CourseSelectedPanel extends MPanel {
	private TitleBar title;
	private MButton button1;
	private MButton button2;
	private MLabel label;
	private CourseDisplayTable table1;
	private StudentCourseDisplayTable table2;
	private MComboBox<String> courseType;

	public CourseSelectedPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		button1 = new MButton(null, null, null, new Point(360, 95),
				new Dimension(50, 25));
		button1.setText("选择");
		button2 = new MButton(null, null, null, new Point(720, 95),
				new Dimension(50, 25));
		button2.setText("推选");
		label = new MLabel(new Point(430, 95), new Dimension(75, 22), "已选课程");
		table2 = new StudentCourseDisplayTable(new Point(430, 130),
				new Dimension(350, 430));
		table1 = new CourseDisplayTable(new Point(10, 130), new Dimension(400,
				430));

		courseType = new MComboBox<>(
				StudentSelectCourseType.getAllSelectCourseType(), new Point(90,
						95), new Dimension(150, 25));

		this.add(title);
		this.add(button1);
		this.add(button2);
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
	}

	private void init() {
		courseType.setSelectedIndex(-1);
		courseType.setSelectedIndex(0);
		// Student student = (Student) (Identity.getIdentity());
		// StudentMethod method=StudentMethodController.getMethod();
		// List<Course> selected=new ArrayList<Course>();
		// try {
		// selected=method.getCourseList(student.getID());
		// } catch (RemoteException e) {
		// e.printStackTrace();
		// }
	}

	class CourseTypeListener implements ItemListener {
		int time = 0;
		StudentMethod method = StudentMethodController.getMethod();
		List<Course> list;
		Student student;

		public CourseTypeListener() {
			student = (Student) Identity.getIdentity();
		}

		public void itemStateChanged(ItemEvent e) {
			time++;
			if (time % 2 == 0) {
				String type = (String) courseType.getSelectedItem();
				type = StudentSelectCourseType.getType(type);
				if (!type.equals("G")) {
					try {
						list = method.getTypeCourse(type);
						if (type.equals("F")) {
							list = CourseListToFacultyAdapter.adapter(list,
									student.getFaculty());
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						list = method.getTypeCourse("E");
						list.addAll(method.getTypeCourse("F"));
						list = CourseListToFacultyAdapter.adapterRverse(list,
								student.getFaculty());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
				table1.setDataVector(CourseListToVectorAdapter.adapter(list));
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
