package com.client.ui.teacherUI.CourseMagagement;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.UIManager;

import com.client.rmi.TeacherMethodController;
import com.client.ui.dataAdapter.StudentListToVectorAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.teacherUI.TeacherUISwitchController;
import com.data.po.Student;
import com.logicService.TeacherMethod;
import com.ui.bcswing.CourseScoreTable;
import com.ui.bcswing.titleBar.TeacherTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseScoreRecordPanel extends MPanel {
	private TitleBar title;
	private CourseScoreTable table;
	private MButton backB;
	private MButton editB;

	public CourseScoreRecordPanel(Point loc, Dimension size, String courseID) {
		super(loc, size);
		createComponent();
		addListener();
		init(courseID);
	}

	private void createComponent() {
		title = new TeacherTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		table = new CourseScoreTable(new Point(10, 130),
				new Dimension(780, 430));
		backB = new MButton(null, null, null, new Point(10, 95), new Dimension(
				100, 30));
		editB = new MButton(null, null, null, new Point(700, 95),
				new Dimension(100, 30));

		backB.setText("返回");
		editB.setText("双击以编辑成绩");

		this.add(title);
		this.add(table);
		this.add(backB);
		this.add(editB);
	}

	private void addListener() {

		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherUISwitchController controller = TeacherUISwitchController
						.getUISwitchController();
				controller.switchToCourseManagement();
			}
		});

		editB.addActionListener(new EditListener());

	}

	private void init(String courseID) {
		TeacherMethod method = TeacherMethodController.getMethod();
		try {
			List<Student> list = method.getCourseStudent(courseID);
			table.setDataVector(StudentListToVectorAdapter.adapter(list));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	class EditListener implements ActionListener {
		int time = 0;

		public void actionPerformed(ActionEvent e) {
			time++;
			if (time % 2 == 0) {
				table.setEditable(new EditScorePermission());
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
		TeacherUISwitchController controller = TeacherUISwitchController
				.getUISwitchController();
		controller.switchToRecordScore("0001");
	}

}
