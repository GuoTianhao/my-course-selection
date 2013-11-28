package com.client.ui.studentUI.lCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.basicdata.TermKind;
import com.client.rmi.DeanMethodController;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.logicService.DeanMethod;
import com.logicService.StudentMethod;
import com.ui.bcswing.FrameDisplayTable;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class CourseLookUpPanel extends MPanel {
	private TitleBar title;
	private MLabel choose1;
	private MLabel choose2;
	private MComboBox<String> term;
	private MComboBox<String> department;
	private FrameDisplayTable table;
	private String[] departmentItems = FacultyKind.getAllFaculty();
	private Object[] data;

	public CourseLookUpPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		choose1 = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择学期：");
		term = new MComboBox<>(TermKind.getAllTerm(), new Point(90, 95),
				new Dimension(150, 25));
		choose2 = new MLabel(new Point(260, 95), new Dimension(75, 22), "选择院系：");
		department = new MComboBox<>(departmentItems, new Point(350, 95),
				new Dimension(150, 25));
		table = new FrameDisplayTable(new Point(10, 130), new Dimension(780,
				430));
		this.add(title);
		this.add(choose1);
		this.add(choose2);
		this.add(department);
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

		term.addItemListener(new Term_FacultyListener());

		department.addItemListener(new Term_FacultyListener());

	}

	private void init() {
		term.setSelectedIndex(-1);
		term.setSelectedIndex(0);
	}

	class Term_FacultyListener implements ItemListener {
		int time = 0;

		public void itemStateChanged(ItemEvent e) {
			time++;
			if (time % 2 == 0) {
				String term = (String) CourseLookUpPanel.this.term
						.getSelectedItem();
				String faculty = (String) CourseLookUpPanel.this.department
						.getSelectedItem();
				faculty = FacultyKind.getType(faculty);
				System.out.println("term:" + term + " faculty:" + faculty);
				StudentMethod method = StudentMethodController.getMethod();
				try {
					table.setDataVector(CourseListToVectorAdapter
							.adapter(method.geFacultyTypeCourse(faculty,
									TermKind.getTerm(term) + "")));
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
		StudentUISwitchController controller = StudentUISwitchController
				.getUISwitchController();
		controller.switchToAllCourse();
	}

}
