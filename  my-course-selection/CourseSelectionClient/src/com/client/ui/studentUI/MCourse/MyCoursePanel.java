package com.client.ui.studentUI.MCourse;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import com.basicdata.YearKind;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.ui.bcswing.FrameDisplayTable;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class MyCoursePanel extends MPanel {

	private TitleBar title;
	private MLabel choose;
	private MComboBox<String> term;
	private FrameDisplayTable table;
	private Object[] data;

	public MyCoursePanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		choose = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择学期：");
		term = new MComboBox<>(YearKind.getAllTerm(), new Point(90, 95), new Dimension(150,
				25));
		table = new FrameDisplayTable(new Point(10, 130), new Dimension(780,
				430));
		this.add(title);
		this.add(choose);
		this.add(term);
		this.add(table);
	}
	
	private void addListener(){
		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUISwitchController controller = StudentUISwitchController
						.getUISwitchController();
				controller.switchToMainFrame();
			}
		});
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f = new MainFrame();
		f.add(new MyCoursePanel(new Point(0, 0), new Dimension(
				f.getSize().width, f.getSize().height)));
		f.refresh();
	}
}
