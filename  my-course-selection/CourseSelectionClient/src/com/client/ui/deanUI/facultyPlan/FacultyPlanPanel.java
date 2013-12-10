package com.client.ui.deanUI.facultyPlan;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.basicdata.FacultyKind;
import com.client.rmi.DeanMethodController;
import com.client.ui.dataAdapter.FrameToVectorAdapter;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.main.MainFrame;
import com.data.po.Frame;
import com.logicService.DeanMethod;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class FacultyPlanPanel extends MPanel {
	private TitleBar title;
	private MLabel choose;
	private MComboBox<String> department;
	private MScrollTable table;
	private String[] departmentItems = FacultyKind.getAllFaculty();
	private Object[] data;

	public FacultyPlanPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new DeanTitlebar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		choose = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择院系：");
		department = new MComboBox<>(departmentItems, new Point(90, 95),
				new Dimension(150, 25));
		table = new MScrollTable(new Point(10, 130), new Dimension(780,
				430));
		String[] c = { "课程模块", "建议学分", "开设学期" };
		table.setColumnIdentifiers(c);
		this.add(title);
		this.add(choose);
		this.add(department);
		this.add(table);
	}

	private void addListener() {

		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanUISwitchController controller = DeanUISwitchController
						.getUISwitchController();
				controller.swicthToMainFrame();
			}
		});

		department.addItemListener(new FacultyListener());

	}

	private void init() {
		department.setSelectedIndex(-1);
		department.setSelectedIndex(0);
	}

	class FacultyListener implements ItemListener {
		int time = 0;

		public void itemStateChanged(ItemEvent e) {
			time++;
			if (time % 2 == 0) {
				String faculty = (String) department.getSelectedItem();
				faculty = FacultyKind.getID(faculty);
				DeanMethod method = DeanMethodController.getMethod();
				try {
					Frame f = method.lookUpFrame(faculty);
					table.setDataVector(FrameToVectorAdapter.adapter(f));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
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
		DeanUISwitchController controller = DeanUISwitchController
				.getUISwitchController();
		controller.switchToFacultyPlanPanel();
	}
}
