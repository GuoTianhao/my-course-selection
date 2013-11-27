package com.client.ui.deanUI.basicFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.client.rmi.DeanMethodController;
import com.client.ui.dataAdapter.BasicFrameToVectorAdapter;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.main.MainFrame;
import com.data.po.BasicFrame;
import com.logicService.DeanMethod;
import com.ui.myswing.MPanel;
import com.ui.bcswing.CourseDisplayTable;
import com.ui.bcswing.FrameDisplayTable;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;

public class BasicFramePanel extends MPanel {
	private TitleBar title;
	private FrameDisplayTable table;
	private MButton make;
	private MButton change;
	private Object[] data;

	public BasicFramePanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new DeanTitlebar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		table = new FrameDisplayTable(new Point(10, 130), new Dimension(780,
				430));
		make = new MButton(null, null, null, new Point(15, 95), new Dimension(
				100, 30));
		change = new MButton(null, null, null, new Point(130, 95),
				new Dimension(100, 30));

		make.setText("制定整体框架策略");
		change.setText("修改整体框架策略");

		this.add(title);
		this.add(make);
		this.add(change);
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
		
		make.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanMethod method = DeanMethodController.getMethod();
				try {
					BasicFrame frame = method.lookUpBasicFrame();
					table.setDataVector(BasicFrameToVectorAdapter
							.adapter(frame));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				table.setEditable(new EditBasicFramePermission());
			}
		});
		
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeanMethod method = DeanMethodController.getMethod();
				try {
					BasicFrame frame = method.lookUpBasicFrame();
					table.setDataVector(BasicFrameToVectorAdapter
							.adapter(frame));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				table.setEditable(new EditBasicFramePermission());
			}
		});
		
	}

	private void init() {

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
		controller.switchToBasicFramePanel();
	}
}
