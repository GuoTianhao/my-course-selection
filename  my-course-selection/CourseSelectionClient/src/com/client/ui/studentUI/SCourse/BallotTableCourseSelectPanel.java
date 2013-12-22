package com.client.ui.studentUI.SCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseListToCourseTypeListAdapter;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.TipFrame;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class BallotTableCourseSelectPanel extends MPanel {
	protected TitleBar title;
	protected MButton confirm;
	protected MScrollTable table;

	public BallotTableCourseSelectPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		init();
		addListener();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 95));
		confirm = new MButton(null, null, null, new Point(720, 95),
				new Dimension(100, 25));
		confirm.setText("确定");

		table = new MScrollTable(new Point(20, 130), new Dimension(810, 480));
		String[] c1 = { "课程编号", "课程名字", "学分", "上课地点", "上课时间", "限定人数", "已选人数" };
		table.setColumnIdentifiers(c1);
		this.add(title);
		this.add(confirm);
		this.add(table);
		this.refresh();
	}

	private void addListener(){
		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUISwitchController controller= StudentUISwitchController
						.getUISwitchController();
				controller.switchToCourseSelect();
			}
		});
	}
	
	private void init() {
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}

	public void setSelectIntervalRowByContent(List<String> list, int column) {
		table.selectAll();
		int count = table.getRowCount();
		for (int i = 0; i < count; i++) {
			if (!list.contains(table.getValueAt(i, column))) {
				table.removeRowSelectionInterval(i, i);
			}
		}
	}

	protected boolean selectCourse() {
		Student student = (Student) Identity.getIdentity();
		StudentMethod method = StudentMethodController.getMethod();
		try {
			int[] rows = table.getSelectedRows();
			for (int i = 0; i < rows.length; i++) {
				String courseID = (String) table.getValueAt(rows[i], 0);
				if(!method.selectCourse(student.getID(), courseID)){
					return false;
				}
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return true;

	}
	
	protected boolean quitCourse(Iterator<Course> it){
		Student student = (Student) Identity.getIdentity();
		StudentMethod method = StudentMethodController.getMethod();
		while (it.hasNext()) {
			try {
				if(!method.quitSelectCourse(student.getID(), it.next().getID())){
					return false;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f = new MainFrame();
		f.add(new BallotTableCourseSelectPanel(new Point(0, 0), f.getSize()));
		f.refresh();
	}

}
