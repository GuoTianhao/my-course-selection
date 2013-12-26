package com.client.ui.teacherUI.CourseMagagement;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Map;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.Identity;
import com.client.rmi.TeacherMethodController;
import com.client.ui.dataAdapter.StudentAndScoreToVectorAdapter;
import com.client.ui.dataAdapter.VectorToScoreAdapter;
import com.client.ui.teacherUI.TeacherUISwitchController;
import com.data.po.Student;
import com.logicService.TeacherMethod;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.TipFrame;
import com.ui.bcswing.titleBar.TeacherTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseScoreRecordPanel extends MPanel {
	private TitleBar title;
	private MScrollTable table;
	private MButton backB;
	private MButton editB;
	private String courseID;
	private boolean isEdit = false;

	public CourseScoreRecordPanel(Point loc, Dimension size, String courseID) {
		super(loc, size);
		createComponent();
		addListener();
		init(courseID);
	}

	private void createComponent() {
		title = new TeacherTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 95));
		table = new MScrollTable(new Point(20, 130), new Dimension(810, 480));
		String[] c = { "学号", "姓名", "院系", "年级", "成绩" };
		table.setColumnIdentifiers(c);
		backB = new MButton(null, null, null, new Point(30, 95), new Dimension(
				60, 25));
		editB = new MButton(null, null, null, new Point(690, 95),
				new Dimension(130, 25));

		backB.setText("返回");
		editB.setText("双击以编辑成绩");

		this.add(title);
		this.add(table);
		this.add(backB);
		this.add(editB);
	}

	private void addListener() {

		backB.addActionListener(new BackButtonListener());

		editB.addActionListener(new EditListener());

	}

	private void init(String courseID) {
		this.courseID = courseID;

		Map<Student, Integer> map;
		TeacherMethod method = TeacherMethodController.getMethod();
		try {
			map = method.getScore(courseID);
			table.setDataVector(StudentAndScoreToVectorAdapter.adapter(map));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private boolean recordScore() {
		TeacherMethod method = TeacherMethodController.getMethod();
		Map map = VectorToScoreAdapter.adapter(table.getDataVector());
		try {
			return method.recordScore(courseID, map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	class EditListener implements ActionListener {
		int time = 0;

		public void actionPerformed(ActionEvent e) {
			time++;
			System.out.println(time);
			if (time % 2 == 0) {
				table.setEditable(new EditScorePermission());
				isEdit = true;
			}
		}

	}

	class BackButtonListener implements ActionListener {
		TeacherUISwitchController controller = TeacherUISwitchController
				.getUISwitchController();

		public void actionPerformed(ActionEvent e) {
			if (isEdit) {
				table.getCellEditor().stopCellEditing();
				TipFrame t;
				if (recordScore()) {
					t = new TipFrame(controller.getLoc(), controller.getSize(),
							5, "成绩录入成功");
					backAction();
				} else {
					t = new TipFrame(controller.getLoc(), controller.getSize(),
							5, "成绩录入失败");
				}
				t.startEndClock();
			}else{
				backAction();
			}
		}

		public void backAction() {
			TeacherUISwitchController controller = TeacherUISwitchController
					.getUISwitchController();
			controller.switchToCourseManagement();
		}

		public boolean recordScoreAction() {
			return recordScore();
		}
	}

	public static void main(String[] args) {
		TeacherMethod method = TeacherMethodController.getMethod();

		try {
			Identity.setIdentity(method.getSelf("100000000"));
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
		TeacherUISwitchController controller = TeacherUISwitchController
				.getUISwitchController();
		controller.switchToRecordScore("0002");
	}

}
