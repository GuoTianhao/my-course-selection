package com.client.ui.studentUI.MCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.basicdata.TermKind;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToCourseTermListAdapter;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class MyCoursePanel extends MPanel {

	private TitleBar title;
	private MLabel choose;
	private MComboBox<String> term;
	private CourseDisplayTable table;

	public MyCoursePanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		choose = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择学期：");
		term = new MComboBox<>(TermKind.getAllTerm(), new Point(90, 95),
				new Dimension(150, 25));
		table = new CourseDisplayTable(new Point(10, 130), new Dimension(780,
				430));
		this.add(title);
		this.add(choose);
		this.add(term);
		this.add(table);
	}

	private void addListener() {

		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUISwitchController controller = StudentUISwitchController
						.getUISwitchController();
				controller.switchToMainFrame();
			}
		});

		term.addItemListener(new TermItemListener());

	}

	private void init() {
		term.setSelectedIndex(-1);
		term.setSelectedIndex(0);
	}

	class TermItemListener implements ItemListener {
		int time = 0;

		public void itemStateChanged(ItemEvent e) {
			time++;
			if (time % 2 == 0) {
				Student student = (Student) (Identity.getIdentity());
				StudentMethod method = StudentMethodController.getMethod();
				String term = (String) MyCoursePanel.this.term
						.getSelectedItem();
				try {
					List<Course> list = method.getCourseList(student.getID());
					list = CourseListToCourseTermListAdapter.adapter(list,
							TermKind.getTerm(term));
					table.setDataVector(CourseListToVectorAdapter.adapter(list));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
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
		controller.switchToMCourse();
	}
}
