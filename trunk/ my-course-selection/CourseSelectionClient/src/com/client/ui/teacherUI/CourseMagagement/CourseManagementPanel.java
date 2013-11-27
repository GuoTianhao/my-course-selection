package com.client.ui.teacherUI.CourseMagagement;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.client.rmi.TeacherMethodController;
import com.client.ui.teacherUI.TeacherUISwtichController;
import com.logicService.TeacherMethod;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.CourseInfroPane;
import com.ui.bcswing.CourseScriptPane;
import com.ui.bcswing.titleBar.TeacherTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseManagementPanel extends MPanel {
	private TitleBar title;
	private MButton editB;
	private MButton inforB;
	private MButton recordB;
	private CourseDisplayTable table;

	public CourseManagementPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new TeacherTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		editB = new MButton(null, null, null, new Point(10, 95), new Dimension(
				100, 30));
		inforB = new MButton(null, null, null, new Point(120, 95),
				new Dimension(100, 30));
		recordB = new MButton(null, null, null, new Point(230, 95),
				new Dimension(100, 30));
		table = new CourseDisplayTable(new Point(10, 130), new Dimension(780,
				430));

		editB.setText("编辑");
		inforB.setText("详细信息");
		recordB.setText("查看学生列表／登记成绩");

		this.add(title);
		this.add(editB);
		this.add(inforB);
		this.add(recordB);
		this.add(table);
	}

	private void addListener() {

		recordB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherUISwtichController controller = TeacherUISwtichController
						.getUISwitchController();
				controller.switchToRecordScore();
			}
		});

		editB.addActionListener(new EditListener());

		inforB.addActionListener(new CourseInforListener());

	}

	private void init() {

	}

	class EditListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int index = table.getSelectedRow();
			if (index >= 0) {
				CourseScriptPane scriptPane = new CourseScriptPane();
				String id = (String) table.getValueAt(index, 0);
				TeacherMethod method = TeacherMethodController.getMethod();
				try {
					scriptPane.setCourse(method.getCourse(id));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	class CourseInforListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int index = table.getSelectedRow();
			if (index >= 0) {
				CourseInfroPane inforPane = new CourseInfroPane();
				String id = (String) table.getValueAt(index, 0);
				TeacherMethod method = TeacherMethodController.getMethod();
				try {
					inforPane.setCourse(method.getCourse(id));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
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
		TeacherUISwtichController controller = TeacherUISwtichController
				.getUISwitchController();
		controller.switchToCourseManagement();
	}

}
