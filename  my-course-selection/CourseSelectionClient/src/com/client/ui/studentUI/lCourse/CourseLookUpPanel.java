package com.client.ui.studentUI.lCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.FacultyKind;
import com.basicdata.TermKind;
import com.client.rmi.DeanMethodController;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.logicService.DeanMethod;
import com.logicService.StudentMethod;
import com.ui.bcswing.CourseInforPane;
import com.ui.bcswing.MScrollTable;
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
	private MScrollTable table;
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
				this.getWidth(), 95));
		choose1 = new MLabel(new Point(25, 95), new Dimension(60, 25), "选择学期");
		term = new MComboBox<>(TermKind.getAllTerm(), new Point(95, 95),
				new Dimension(150, 25));
		choose2 = new MLabel(new Point(280, 95), new Dimension(75, 25), "选择院系");
		department = new MComboBox<>(departmentItems, new Point(350, 95),
				new Dimension(150, 25));
		table = new MScrollTable(new Point(20, 130), new Dimension(810, 480));
		String[] c = { "课程编号", "课程模块", "课程名称", "学分", "开设学期" };
		table.setColumnIdentifiers(c);
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
				faculty = FacultyKind.getID(faculty);
				StudentMethod method = StudentMethodController.getMethod();
				try {
					table.setDataVector(CourseListToVectorAdapter
							.adapter(method.geFacultyTermCourse(faculty,
									TermKind.getTerm(term) + "")));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
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
