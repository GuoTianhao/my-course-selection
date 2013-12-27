package com.client.ui.facultyUI.teachingPlan;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.Identity;
import com.client.rmi.FacultyDeanMethodController;
import com.client.ui.dataAdapter.FrameToVectorAdapter;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.client.ui.teacherUI.TeacherUISwitchController;
import com.data.po.FacultyDean;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.logicService.FacultyDeanMethod;
import com.ui.myswing.MPanel;
import com.ui.myswing.MButton;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.TipFrame;
import com.ui.bcswing.frameEditPane.FrameEditPane;
import com.ui.bcswing.titleBar.FacultyTitleBar;
import com.ui.bcswing.titleBar.TitleBar;

public class TeachingPlanPanel extends MPanel {
	private TitleBar title;
	// private MButton add;
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
				this.getWidth(), 95));
		table = new MScrollTable(new Point(20, 130), new Dimension(800, 480));
		String[] c = { "课程模块", "建议学分", "开设学期" };
		table.setColumnIdentifiers(c);
		// add = new MButton(null, null, null, new Point(30, 95), new Dimension(
		// 80, 25));
		change = new MButton(null, null, null, new Point(120, 95),
				new Dimension(80, 25));
		publish = new MButton(null, null, null, new Point(30, 95),
				new Dimension(80, 25));

		// add.setText("添加");
		change.setText("更改");
		publish.setText("发布");

		this.add(title);
		// this.add(add);
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
			FacultyUISwitchController controller = FacultyUISwitchController
					.getUISwitchController();

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
					TipFrame t;
					if (pane.isValidInput()) {
						if (method.formulateFrame(pane.getFrame())) {
							t = new TipFrame(controller.getLoc(), controller
									.getSize(), 5, "教学计划发布成功");
							refreshTable();
							pane.dispose();
						} else {
							t = new TipFrame(pane.getLocation(),
									pane.getSize(), 5, "教学计划发布失败");
						}
					} else {
						t = new TipFrame(pane.getLocation(), pane.getSize(), 5,
								"填写错误");
					}
					t.startEndClock();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		change.addActionListener(new ActionListener() {
			FacultyUISwitchController controller = FacultyUISwitchController
					.getUISwitchController();
			FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
			FrameEditPane pane;

			public void actionPerformed(ActionEvent e) {
				pane = new FrameEditPane();
				try {
					pane.setFrame(method.lookFrame(((FacultyDean) Identity
							.getIdentity()).getFaculty()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pane.addConfirmListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modify();
					}

				});
			}

			public void modify() {
				try {
					TipFrame t;
					if (pane.isValidInput()) {
						if (method.modifyFrame(pane.getFrame())) {
							t = new TipFrame(controller.getLoc(), controller
									.getSize(), 5, "教学计划修改成功");
							refreshTable();
							pane.dispose();
						} else {
							t = new TipFrame(pane.getLocation(),
									pane.getSize(), 5, "教学计划修改失败");
						}
					} else {
						t = new TipFrame(pane.getLocation(), pane.getSize(), 5,
								"填写错误");
					}
					t.startEndClock();
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
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
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
