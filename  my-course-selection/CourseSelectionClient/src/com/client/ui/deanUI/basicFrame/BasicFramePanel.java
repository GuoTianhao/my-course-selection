package com.client.ui.deanUI.basicFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Iterator;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.client.rmi.DeanMethodController;
import com.client.ui.dataAdapter.BasicFrameToVectorAdapter;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.deanUI.coursePanel.CoursePanel;
import com.data.po.BasicFrame;
import com.data.po.FrameElement;
import com.logicService.DeanMethod;
import com.ui.myswing.MPanel;
import com.ui.bcswing.MScrollTable;
import com.ui.bcswing.TipFrame;
import com.ui.bcswing.basicFrameEditPane.BasicFrameEditPane;
import com.ui.bcswing.titleBar.DeanTitlebar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;

public class BasicFramePanel extends MPanel {
	private TitleBar title;
	private MScrollTable table;
	private MButton make;
	private MButton change;

	public BasicFramePanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new DeanTitlebar(new Point(0, 0), new Dimension(
				this.getWidth(), 95));
		table = new MScrollTable(new Point(20, 130), new Dimension(810,
				450));
		String[] c = { "课程模块", "建议学分", "开设学期" };
		table.setColumnIdentifiers(c);
		
		make = new MButton(null, null, null, new Point(30, 95), new Dimension(
				120, 25));
		change = new MButton(null, null, null, new Point(160, 95),
				new Dimension(120, 25));

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
			
			BasicFrameEditPane pane;
			DeanMethod method;
			
			public void actionPerformed(ActionEvent e) {
				
				pane = new BasicFrameEditPane();
				
				pane.addYesListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						method = DeanMethodController.getMethod();
						try {
							DeanUISwitchController controller = DeanUISwitchController
									.getUISwitchController();
							TipFrame t;
							if(method.formulateFrame(pane.getBasicFrame())){
								t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
										"整体框架策略发布成功");
								pane.dispose();
								refreshTable();
							}else{
								t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
										"整体框架策略发布失败");
							}
							t.startEndClock();
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
					
				});
			
			}
			
		});

		change.addActionListener(new ActionListener() {
			
			BasicFrameEditPane pane;
			DeanMethod method;
			
			public void actionPerformed(ActionEvent e) {
				method = DeanMethodController.getMethod();
				try {
					
					BasicFrame frame = method.lookUpBasicFrame();
					pane = new BasicFrameEditPane();
					pane.setBasicFrame(frame);
					
					pane.addYesListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							try {
								DeanUISwitchController controller = DeanUISwitchController
										.getUISwitchController();
								TipFrame t;
								if(method.modifyFrame(pane.getBasicFrame())){
									t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
											"整体框架策略修改成功");
									refreshTable();
									pane.dispose();
								}else{
									t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
											"整体框架策略修改失败");
								}
								t.startEndClock();
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					});
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

	}
	
	private void refreshTable(){
		DeanMethod method = DeanMethodController.getMethod();
		try {
			BasicFrame frame = method.lookUpBasicFrame();
			Iterator<FrameElement> it = frame.iterator();
			if (!it.hasNext()) {
				change.setEnabled(false);
				make.setEnabled(true);
			} else {
				make.setEnabled(false);
				change.setEnabled(true);
			}
			table.setDataVector(BasicFrameToVectorAdapter.adapter(frame));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		refreshTable();
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
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
