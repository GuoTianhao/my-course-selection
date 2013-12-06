package com.client.ui.deanUI.coursePanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.basicdata.Identity;
import com.basicdata.TermKind;
import com.client.rmi.DeanMethodController;
import com.client.ui.dataAdapter.CourseListToVectorAdapter;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.facultyUI.Course.FacultyDeanCourseTeacherAssignmentDislayPane;
import com.data.po.Course;
import com.data.po.FacultyDean;
import com.logicService.DeanMethod;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.CourseInforPane;
import com.ui.bcswing.MPopupMenu;
import com.ui.bcswing.courseEditPane.DeanCoursePane;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class CoursePanel extends MPanel {
	private TitleBar title;
	private MButton courseP;
	private MButton courseA;
	private CoursePublicOperateBar publishOperateBar;
	private AllCourseOperateBar allCourseOperateBar;

	private CourseDisplayTable table;

	private int state;

	private MPopupMenu popupMenu;

	public CoursePanel(Point loc, Dimension size) {
		super(loc, size);
		creatComponent();
		addListener();
		init();
	}

	private void creatComponent() {
		Dimension size = this.getSize();
		title = new DeanTitlebar(new Point(0, 0),
				new Dimension(size.width, 100));
		courseP = new MButton(null, null, null, new Point(0, 100),
				new Dimension(100, 30));
		courseA = new MButton(null, null, null, new Point(110, 100),
				new Dimension(100, 30));

		courseP.setText("公共课程");
		courseA.setText("全校课程");

		table = new CourseDisplayTable(new Point(10, 180), new Dimension(
				size.width - 70, 380));
		popupMenu = new MPopupMenu();
		table.add(popupMenu);

		this.add(title);
		this.add(courseP);
		this.add(courseA);
		this.add(table);

		publishOperateBar = new CoursePublicOperateBar(new Point(0, 140),
				new Dimension(size.width, 50));

		allCourseOperateBar = new AllCourseOperateBar(new Point(0, 140),
				new Dimension(size.width, 50));

		addCoursePublishOperateBar();
	}

	private void addListener() {

		courseP.addActionListener(new PublicCourseSwitchListener());

		courseA.addActionListener(new AllCourseSwitchListener());

		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanUISwitchController controller = DeanUISwitchController
						.getUISwitchController();
				controller.swicthToMainFrame();
			}

		});

		publishOperateBar.addCoursePListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeanCoursePane();
			}

		});

		publishOperateBar.addcourseMListener(new CourseModifyListener());

		publishOperateBar.addcourseInforListener(new CourseInfroListener());

		publishOperateBar.addSearchKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				publishOperateBarSearch();
			}
		});

		allCourseOperateBar.addSearchKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				allCourseOperateBarSearch();
			}
		});

		allCourseOperateBar.addYearItemListener(new Term_FacultyListener());

		allCourseOperateBar.addFacultyItemListenr(new Term_FacultyListener());

		table.addMouseListener(new TableClickListener());

		popupMenu.addTeacherAssignmentListener(new TeacherAssignmentListener());

	}

	private void init() {
		courseP.doClick();
		
		
	}

	private void addCoursePublishOperateBar() {
		this.remove(allCourseOperateBar);
		this.add(publishOperateBar);
		this.refresh();
		state = 0;
	}

	private void addAllCourseOperateBar() {
		this.remove(publishOperateBar);
		this.add(allCourseOperateBar);
		this.refresh();
		state = 1;
	}

	private void publishOperateBarSearch() {
		String content = publishOperateBar.getSearchContent();
		table.regrexFilter(content);
	}

	private void allCourseOperateBarSearch() {
		String content = allCourseOperateBar.getSearchContent();
		table.regrexFilter(content);
	}

	class PublicCourseSwitchListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (state == 1) {
				addCoursePublishOperateBar();
			}
			DeanMethod method = DeanMethodController.getMethod();
			try {
				table.setDataVector(CourseListToVectorAdapter.adapter(method
						.getMCourse()));
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			publishOperateBarSearch();
		}

	}

	class AllCourseSwitchListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (state == 0) {
				addAllCourseOperateBar();
				allCourseOperateBar.changeItemState();
			}
			allCourseOperateBarSearch();
		}

	}

	class CourseModifyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			DeanMethod method = DeanMethodController.getMethod();
			int index = table.getSelectedRow();
			if (index >= 0) {
				String id = (String) table.getValueAt(index, 0);
				try {
					Course c = method.getCourse(id);
					DeanCoursePane pane = new DeanCoursePane();
					pane.setCourse(c);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

			}
		}

	}

	class CourseInfroListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			DeanMethod method = DeanMethodController.getMethod();
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

	class Term_FacultyListener implements ItemListener {
		int time = 0;

		public void itemStateChanged(ItemEvent e) {
			time++;
			if (time % 2 == 0) {
				String term = allCourseOperateBar.getTerm();
				String faculty = FacultyKind.getID(allCourseOperateBar
						.getFaculty());
				faculty = FacultyKind.getID(faculty);
				DeanMethod method = DeanMethodController.getMethod();
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

	class TableClickListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			int mods = e.getModifiers();
			if (mods == InputEvent.BUTTON3_MASK
					|| e.getModifiers() == InputEvent.BUTTON2_MASK) {
				popupMenu.show(table, e.getX(), e.getY());
			}
		}
	}

	class TeacherAssignmentListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String courseID;

			int index = table.rowAtPoint(popupMenu.getLocation());
			courseID = (String) table.getValueAt(index, 0);

			new DeanCourseTeacherAssignmentDisplayPane(courseID);
		}

	}

	public static void main(String[] args) {
		try {
			Identity.setIdentity(DeanMethodController.getMethod().getSelf(
					"121250041"));
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DeanUISwitchController controller = DeanUISwitchController
				.getUISwitchController();
		controller.switchToCoursePanel();
	}

}
