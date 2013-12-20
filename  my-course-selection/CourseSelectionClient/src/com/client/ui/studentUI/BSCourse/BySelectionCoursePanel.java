package com.client.ui.studentUI.BSCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToBySelectCourseVectorAdapter;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MPanel;

public class BySelectionCoursePanel extends MPanel {
	private TitleBar title;
	private MComboBox courseType;
	private MButton bSelect;
	private MScrollTable table;

	public BySelectionCoursePanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 95));
		String[] type = { "专业选修课", "通识教育课程", "跨院系课程" };
		courseType = new MComboBox<>(type, new Point(30, 95), new Dimension(
				150, 25));

		bSelect = new MButton(null, null, null, new Point(720, 95),
				new Dimension(80, 25));
		bSelect.setText("补选");

		table = new MScrollTable(new Point(20, 130), new Dimension(810,
				480));
		String[] c = { "课程编号","课程名称","上课地点","上课时间", "学分","剩余人数" };
		table.setColumnIdentifiers(c);
		this.add(title);
		this.add(courseType);
		this.add(bSelect);
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

		bSelect.addActionListener(new BySelectListener());
	}

	private void init() {
		courseType.setSelectedIndex(-1);
		courseType.setSelectedIndex(0);
	}

	private void refreshTable() {
		String type = (String) courseType.getSelectedItem();
		List<Course> list;
		list = UnSelectedCourseTypeHandle.handle(type);
		table.setDataVector(CourseListToBySelectCourseVectorAdapter
				.adapter(list));

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

	class BySelectListener implements ActionListener {

		Student student = (Student) (Identity.getIdentity());

		public void actionPerformed(ActionEvent e) {
			bySelectCourse();
		}

		public void bySelectCourse() {
			int index = table.getSelectedRow();
			if (index >= 0) {
				String cID = (String) table.getValueAt(index, 0);
				StudentMethod method = StudentMethodController.getMethod();

				try {
					boolean admit = method.bySelectCourse(student.getID(), cID);
					if (admit) {
						System.out.println("补选成功");
					} else {
						System.out.println("补选失败");
					}

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
		controller.switchToBSCourse();
	}

}
