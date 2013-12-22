package com.client.ui.studentUI.QCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToCourseTermListAdapter;
import com.client.ui.dataAdapter.GradeToTermAdapter;
import com.client.ui.dataAdapter.StudentCourseToCourseTypeListAdapter;
import com.client.ui.dataAdapter.StudentUnselectedCourseListToVectorAdapeter;
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
import com.ui.myswing.MComboBox;
import com.ui.myswing.MPanel;

public class QuitCoursePanel extends MPanel {

	private TitleBar title;
	private MComboBox courseType;
	private MButton quitB;
	private MScrollTable table;

	public QuitCoursePanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 95));
		String[] type = { "专业选修课", "通识教育课程", "跨院系课程", "体育课" };
		courseType = new MComboBox<>(type, new Point(30, 95), new Dimension(
				150, 25));

		quitB = new MButton(null, null, null, new Point(720, 95),
				new Dimension(100, 25));
		quitB.setText("退选");

		table = new MScrollTable(new Point(20, 130), new Dimension(810,
				480));
		String[] c = { "课程编号", "课程模块", "课程名称", "学分", "开设学期" };
		table.setColumnIdentifiers(c);

		this.add(title);
		this.add(courseType);
		this.add(quitB);
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

		courseType.addItemListener(new CourseTypeListener());
		
		quitB.addActionListener(new QuitListener());
		
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

	}

	private void refreshTable() {
		StudentMethod method = StudentMethodController.getMethod();
		Student student = (Student) Identity.getIdentity();

		String type = (String) courseType.getSelectedItem();
		List<Course> list;
		try {
			list = method.getCourseList(student.getID());
			list = StudentCourseToCourseTypeListAdapter.adapter(list, type);
			list = CourseListToCourseTermListAdapter.adapter(list,
					GradeToTermAdapter.adapter(student.getGrade()));
			table.setDataVector(StudentUnselectedCourseListToVectorAdapeter
					.adapter(list));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	class CourseTypeListener implements ItemListener {
		int time = 0;

		public void itemStateChanged(ItemEvent e) {
			time++;
			if (time % 2 == 0) {
				refreshTable();
			}
		}
	}

	class QuitListener implements ActionListener {

		Student student = (Student) (Identity.getIdentity());

		public void actionPerformed(ActionEvent e) {
			quitCourse();
		}

		public void quitCourse() {
			int index = table.getSelectedRow();
			if (index >= 0) {
				String cID = (String) table.getValueAt(index, 0);
				StudentMethod method = StudentMethodController.getMethod();
				StudentUISwitchController controller=StudentUISwitchController.getUISwitchController();
				TipFrame t;
				try {
					boolean admit = method.quitCourse(student.getID(),
							cID);
					if (admit) {
						t = new TipFrame(controller.getLoc(),
								controller.getSize(), 5, "退选成功");
					} else {
						t = new TipFrame(controller.getLoc(),
								controller.getSize(), 5, "退选失败");
					}
					t.startEndClock();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				refreshTable();

			}
		}

	}

	public static void main(String[] args) {
		StudentMethod method = StudentMethodController.getMethod();
		try {
			Identity.setIdentity(method.getSelf("121250011"));
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StudentUISwitchController controller = StudentUISwitchController
				.getUISwitchController();
		controller.switchToQCourse();
	}
}
