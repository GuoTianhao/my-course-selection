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
	private static Dimension default_size = new Dimension(525,500);
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
		moduleLb.setBounds(65, 10, 80, 25);
		moduleField = new MTextField(new Point(150, 20), new Dimension(150, 30));
		moduleField.setEditable(false);
		moduleField.setSize(150, 25);
		moduleField.setLocation(30, 45);

		creditLb = new MLabel("建议学分");
		creditLb.setBounds(220, 10, 80, 25);
		creditField1 = new MTextField();
		creditField1.setBounds(220, 45, 25, 25);
		lb1 = new MLabel("~");
		lb1.setBounds(245, 45, 25, 25);
		creditField2 = new MTextField();
		creditField2.setBounds(270, 45, 25, 25);

		periodLb = new MLabel("开设学期");
		periodLb.setBounds(345, 10, 80, 25);
		periodField1 = new MTextField();
		periodField1.setBounds(350, 45, 25, 25);
		lb2 = new MLabel("~");
		lb2.setBounds(375, 45, 25, 25);
		periodField2 = new MTextField();
		periodField2.setBounds(400, 45, 25, 25);

		yesBtn = new MButton(null, null, null, new Point(100, 220),
				new Dimension(80, 25));
		yesBtn.setLocation(140, 365);
		yesBtn.setText("确定");
		noBtn = new MButton(null, null, null, new Point(220, 220),
				new Dimension(80, 25));
		noBtn.setLocation(265, 365);
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
		
		
		MTextField textField = new MTextField();
		textField.setEditable(false);
		textField.setBounds(30, 90, 150, 25);
		editPanel.add(textField);
		
		MTextField textField_1 = new MTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(30, 135, 150, 25);
		editPanel.add(textField_1);
		
		MTextField textField_2 = new MTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(30, 180, 150, 25);
		editPanel.add(textField_2);
		
		MTextField textField_3 = new MTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(30, 225, 150, 25);
		editPanel.add(textField_3);
		
		MTextField textField_4 = new MTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(30, 270, 150, 25);
		editPanel.add(textField_4);
		
		MTextField textField_5 = new MTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(30, 315, 150, 25);
		editPanel.add(textField_5);
		
		MTextField textField_6 = new MTextField();
		textField_6.setBounds(220, 90, 25, 25);
		editPanel.add(textField_6);
		
		MLabel label = new MLabel("~");
		label.setBounds(245, 90, 25, 25);
		editPanel.add(label);
		
		MTextField textField_7 = new MTextField();
		textField_7.setBounds(270, 90, 25, 25);
		editPanel.add(textField_7);
		
		MTextField textField_8 = new MTextField();
		textField_8.setBounds(270, 135, 25, 25);
		editPanel.add(textField_8);
		
		MTextField textField_9 = new MTextField();
		textField_9.setBounds(220, 135, 25, 25);
		editPanel.add(textField_9);
		
		MLabel label_1 = new MLabel("~");
		label_1.setBounds(245, 135, 25, 25);
		editPanel.add(label_1);
		
		MTextField textField_10 = new MTextField();
		textField_10.setBounds(270, 180, 25, 25);
		editPanel.add(textField_10);
		
		MTextField textField_11 = new MTextField();
		textField_11.setBounds(220, 180, 25, 25);
		editPanel.add(textField_11);
		
		MLabel label_2 = new MLabel("~");
		label_2.setBounds(245, 180, 25, 25);
		editPanel.add(label_2);
		
		MTextField textField_12 = new MTextField();
		textField_12.setBounds(270, 225, 25, 25);
		editPanel.add(textField_12);
		
		MTextField textField_13 = new MTextField();
		textField_13.setBounds(220, 225, 25, 25);
		editPanel.add(textField_13);
		
		MLabel label_3 = new MLabel("~");
		label_3.setBounds(245, 225, 25, 25);
		editPanel.add(label_3);
		
		MTextField textField_14 = new MTextField();
		textField_14.setBounds(270, 270, 25, 25);
		editPanel.add(textField_14);
		
		MTextField textField_15 = new MTextField();
		textField_15.setBounds(220, 270, 25, 25);
		editPanel.add(textField_15);
		
		MLabel label_4 = new MLabel("~");
		label_4.setBounds(245, 270, 25, 25);
		editPanel.add(label_4);
		
		MTextField textField_16 = new MTextField();
		textField_16.setBounds(270, 315, 25, 25);
		editPanel.add(textField_16);
		
		MTextField textField_17 = new MTextField();
		textField_17.setBounds(220, 315, 25, 25);
		editPanel.add(textField_17);
		
		MLabel label_5 = new MLabel("~");
		label_5.setBounds(245, 315, 25, 25);
		editPanel.add(label_5);
		
		MTextField textField_18 = new MTextField();
		textField_18.setBounds(350, 90, 25, 25);
		editPanel.add(textField_18);
		
		MLabel label_6 = new MLabel("~");
		label_6.setBounds(375, 90, 25, 25);
		editPanel.add(label_6);
		
		MTextField textField_19 = new MTextField();
		textField_19.setBounds(400, 90, 25, 25);
		editPanel.add(textField_19);
		
		MTextField textField_20 = new MTextField();
		textField_20.setBounds(350, 135, 25, 25);
		editPanel.add(textField_20);
		
		MLabel label_7 = new MLabel("~");
		label_7.setBounds(375, 135, 25, 25);
		editPanel.add(label_7);
		
		MTextField textField_21 = new MTextField();
		textField_21.setBounds(400, 135, 25, 25);
		editPanel.add(textField_21);
		
		MTextField textField_22 = new MTextField();
		textField_22.setBounds(350, 180, 25, 25);
		editPanel.add(textField_22);
		
		MLabel label_8 = new MLabel("~");
		label_8.setBounds(375, 180, 25, 25);
		editPanel.add(label_8);
		
		MTextField textField_23 = new MTextField();
		textField_23.setBounds(400, 180, 25, 25);
		editPanel.add(textField_23);
		
		MTextField textField_24 = new MTextField();
		textField_24.setBounds(350, 225, 25, 25);
		editPanel.add(textField_24);
		
		MLabel label_9 = new MLabel("~");
		label_9.setBounds(375, 225, 25, 25);
		editPanel.add(label_9);
		
		MTextField textField_25 = new MTextField();
		textField_25.setBounds(400, 225, 25, 25);
		editPanel.add(textField_25);
		
		MTextField textField_26 = new MTextField();
		textField_26.setBounds(350, 270, 25, 25);
		editPanel.add(textField_26);
		
		MLabel label_10 = new MLabel("~");
		label_10.setBounds(375, 270, 25, 25);
		editPanel.add(label_10);
		
		MTextField textField_27 = new MTextField();
		textField_27.setBounds(400, 270, 25, 25);
		editPanel.add(textField_27);
		
		MTextField textField_28 = new MTextField();
		textField_28.setBounds(350, 315, 25, 25);
		editPanel.add(textField_28);
		
		MLabel label_11 = new MLabel("~");
		label_11.setBounds(375, 315, 25, 25);
		editPanel.add(label_11);
		
		MTextField textField_29 = new MTextField();
		textField_29.setBounds(400, 315, 25, 25);
		editPanel.add(textField_29);
		
		getContentPane().add(editPanel);
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
		 try {
		 org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		 UIManager.put("RootPane.setupButtonVisible", false);
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		BasicFrameEditPane pane = new BasicFrameEditPane();
	}
}
