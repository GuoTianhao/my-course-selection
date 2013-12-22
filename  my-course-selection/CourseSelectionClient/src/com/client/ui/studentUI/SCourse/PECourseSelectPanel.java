package com.client.ui.studentUI.SCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.PECourseSelectListToVectorAdapter;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.CourseInforPane;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.TipFrame;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class PECourseSelectPanel extends MPanel {
	private TitleBar title;
	private MButton select;
	private MScrollTable table;

	public PECourseSelectPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 95));
		select = new MButton(null, null, null, new Point(720, 95),
				new Dimension(100, 25));
		select.setText("选择");
		table = new MScrollTable(new Point(20, 130), new Dimension(810, 480));
		String[] c = { "课程编号", "课程名称", "上课地点", "上课时间", "剩余人数" };
		table.setColumnIdentifiers(c);

		this.add(title);
		this.add(select);
		this.add(table);
	}

	private void addListener() {

		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUISwitchController controller = StudentUISwitchController
						.getUISwitchController();
				controller.switchToCourseSelect();
			}
		});

		select.addActionListener(new SelectListener());

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				StudentMethod method = StudentMethodController.getMethod();
				if (e.getClickCount() == 2) {
					// JOptionPane.showMessageDialog(null, "doubleClicked!");
					int index = table.getSelectedRow();
					if (index >= 0) {
						String id = (String) table.getValueAt(index, 0);
						try {
							Course c = method.getCourse(id);
							CourseInforPane pane = new CourseInforPane(c);
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}

					}
				}
			}
		});
	}
	
	private void refreshTable(){
		StudentMethod method = StudentMethodController.getMethod();
		try {
			List<Course> list=method.getTypeCourse("G");
			table.setDataVector(PECourseSelectListToVectorAdapter.adapter(list));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		refreshTable();
	}

	class SelectListener implements ActionListener {
		StudentUISwitchController controller=StudentUISwitchController.getUISwitchController();
		TipFrame t;

		public void actionPerformed(ActionEvent e) {
			Student student = (Student) (Identity.getIdentity());
			int index = table.getSelectedRow();
			if (index >= 0) {
				String cID = (String) table.getValueAt(index, 0);
				StudentMethod method = StudentMethodController.getMethod();
				try {
					boolean admit = method.selectCourse(student.getID(), cID);
					if (admit) {
						t = new TipFrame(controller.getLoc(),
								controller.getSize(), 5, "选课成功");

					} else {
						t = new TipFrame(controller.getLoc(),
								controller.getSize(), 5, "选课失败");
					}
					t.startEndClock();
					refreshTable();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			Identity.setIdentity(StudentMethodController.getMethod().getSelf(
					"121250041"));
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
		controller.switchToPESelect();
	}
}
