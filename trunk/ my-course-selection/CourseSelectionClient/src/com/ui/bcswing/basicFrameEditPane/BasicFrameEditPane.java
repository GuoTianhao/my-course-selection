package com.ui.bcswing.basicFrameEditPane;

import com.data.po.BasicFrame;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.data.po.FrameElement;
import com.ui.myswing.MButton;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class BasicFrameEditPane extends MFrame {
	private MPanel editPanel;
	private FrameElement element;
	private static Dimension default_size = new Dimension(450, 400);
	private MLabel moduleLb;
	private MLabel creditLb;
	private MLabel periodLb;
	private MTextField moduleField;
	private MTextField creditField1;
	private MTextField creditField2;
	private MLabel lb1;
	private MTextField periodField1;
	private MTextField periodField2;
	private MLabel lb2;
	private MButton yesBtn;
	private MButton noBtn;

	public BasicFrameEditPane() {
		super(default_size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		editPanel = new MPanel(new Point(0, 0), default_size);
		moduleLb = new MLabel("课程模块");
		moduleLb.setBounds(20, 20, 80, 25);
		moduleField = new MTextField(new Point(150, 20), new Dimension(150, 30));

		creditLb = new MLabel("建议学分");
		creditLb.setBounds(20, 100, 80, 25);
		creditField1 = new MTextField();
		creditField1.setBounds(150, 100, 25, 25);
		lb1 = new MLabel("~");
		lb1.setBounds(180, 100, 25, 25);
		creditField2 = new MTextField();
		creditField2.setBounds(210, 100, 25, 25);

		periodLb = new MLabel("开设学期");
		periodLb.setBounds(20, 175, 80, 25);
		periodField1 = new MTextField();
		periodField1.setBounds(150, 175, 25, 25);
		lb2 = new MLabel("~");
		lb2.setBounds(180, 175, 25, 25);
		periodField2 = new MTextField();
		periodField2.setBounds(210, 175, 25, 25);

		yesBtn = new MButton(null, null, null, new Point(100, 220),
				new Dimension(80, 25));
		yesBtn.setText("确定");
		noBtn = new MButton(null, null, null, new Point(220, 220),
				new Dimension(80, 25));
		noBtn.setText("取消");

		editPanel.add(moduleLb);
		editPanel.add(moduleField);
		editPanel.add(creditLb);
		editPanel.add(creditField1);
		editPanel.add(lb1);
		editPanel.add(creditField2);
		editPanel.add(periodLb);
		editPanel.add(periodField1);
		editPanel.add(lb2);
		editPanel.add(periodField2);
		editPanel.add(yesBtn);
		editPanel.add(noBtn);
		this.add(editPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void addListener() {

	}

	public void setBasicFrame(BasicFrame frame) {

	}

	public BasicFrame getBasicFrame() {
		return null;
	}

	public static void main(String[] args) {
		// try {
		// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		// UIManager.put("RootPane.setupButtonVisible", false);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
//		BasicFrameEditPane pane = new BasicFrameEditPane(new FrameElement(null,
//				null, null));
	}
}
