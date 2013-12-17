package com.client.ui.facultyUI.teachingPlan;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.rmi.FacultyDeanMethodController;
import com.client.ui.dataAdapter.FrameToVectorAdapter;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.data.po.FacultyDean;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.logicService.FacultyDeanMethod;
import com.ui.myswing.MPanel;
import com.ui.myswing.MButton;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.frameEditPane.FrameEditPane;
import com.ui.bcswing.titleBar.FacultyTitleBar;
import com.ui.bcswing.titleBar.TitleBar;

public class TeachingPlanPanel extends MPanel {
	private TitleBar title;
	private MButton add;
	private MButton change;
	private MButton publish;
	private MScrollTable table;

	public TeachingPlanPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new FacultyTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		table = new MScrollTable(new Point(10, 130), new Dimension(780, 430));
		String[] c = { "课程模块", "建议学分", "开设学期" };
		table.setColumnIdentifiers(c);
		add = new MButton(null, null, null, new Point(15, 95), new Dimension(
				100, 30));
		change = new MButton(null, null, null, new Point(100, 95),
				new Dimension(80, 30));
		publish = new MButton(null, null, null, new Point(185, 95),
				new Dimension(80, 30));

		add.setText("添加");
		change.setText("更改");
		publish.setText("发布");

		this.add(title);
		this.add(add);
		this.add(change);
		this.add(publish);
		this.add(table);
	}

	private void addListener() {

		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyUISwitchController controller = FacultyUISwitchController
						.getUISwitchController();
				controller.swicthToMainFrame();
			}
		});

		publish.addActionListener(new ActionListener() {
			FrameEditPane pane;
			FacultyDeanMethod method = FacultyDeanMethodController.getMethod();

			public void actionPerformed(ActionEvent e) {
				pane = new FrameEditPane();
				pane.addConfirmListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						publish();
					}

				});
			}

			public void publish() {
				try {
					if (method.modifyFrame(pane.getFrame())) {
						change.setEnabled(true);
						publish.setEnabled(false);
					}
					pane.dispose();
					refreshTable();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		change.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FacultyDean self = (FacultyDean) Identity.getIdentity();
				String id = self.getFaculty();
				FacultyDeanMethod method = FacultyDeanMethodController
						.getMethod();
				FrameEditPane pane = new FrameEditPane();
				try {
					pane.setFrame(method.lookFrame(id));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});

	}

	private void init() {
		FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
		FacultyDean facultyDean = (FacultyDean) Identity.getIdentity();
		try {
			Frame frame = method.lookFrame(facultyDean.getFaculty());
			Iterator<FrameElement> it = frame.iterator();
			if (!it.hasNext()) {
				change.setEnabled(false);
			} else {
				publish.setEnabled(false);
			}
			table.setDataVector(FrameToVectorAdapter.adapter(frame));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void refreshTable() {
		FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
		FacultyDean facultyDean = (FacultyDean) Identity.getIdentity();
		Frame frame;
		try {
			frame = method.lookFrame(facultyDean.getFaculty());
			table.setDataVector(FrameToVectorAdapter.adapter(frame));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
		try {
			Identity.setIdentity(method.getSelf("100000002"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		FacultyUISwitchController controller = FacultyUISwitchController
				.getUISwitchController();
		controller.switchToTeachingPlanPanel();
	}
}
