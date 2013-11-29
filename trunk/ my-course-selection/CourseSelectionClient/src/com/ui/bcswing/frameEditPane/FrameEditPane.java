package com.ui.bcswing.frameEditPane;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.data.po.Frame;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;
import com.ui.myswing.MButton;
import javax.swing.ImageIcon;

public class FrameEditPane extends MFrame {
	private MPanel panel;
	private static Dimension default_size = new Dimension(525, 500);

	public FrameEditPane() {
		super(default_size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		panel = new MPanel(new Point(0, 0), default_size);

		getContentPane().add(panel);
		
		MLabel label = new MLabel("课程模块");
		label.setBounds(73, 12, 80, 25);
		panel.add(label);
		
		MLabel label_1 = new MLabel("建议学分");
		label_1.setBounds(228, 12, 80, 25);
		panel.add(label_1);
		
		MLabel label_2 = new MLabel("开设学期");
		label_2.setBounds(342, 12, 80, 25);
		panel.add(label_2);
		
		MTextField textField = new MTextField(new Point(150, 20), new Dimension(150, 30));
		textField.setEditable(false);
		textField.setBounds(38, 47, 150, 25);
		panel.add(textField);
		
		MTextField textField_1 = new MTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(38, 92, 150, 25);
		panel.add(textField_1);
		
		MTextField textField_2 = new MTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(38, 137, 150, 25);
		panel.add(textField_2);
		
		MTextField textField_3 = new MTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(38, 182, 150, 25);
		panel.add(textField_3);
		
		MTextField textField_4 = new MTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(38, 227, 150, 25);
		panel.add(textField_4);
		
		MTextField textField_5 = new MTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(38, 272, 150, 25);
		panel.add(textField_5);
		
		MTextField textField_6 = new MTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(38, 317, 150, 25);
		panel.add(textField_6);
		
		MTextField textField_7 = new MTextField();
		textField_7.setBounds(250, 47, 25, 25);
		panel.add(textField_7);
		
		MTextField textField_8 = new MTextField();
		textField_8.setBounds(250, 92, 25, 25);
		panel.add(textField_8);
		
		MTextField textField_9 = new MTextField();
		textField_9.setBounds(250, 137, 25, 25);
		panel.add(textField_9);
		
		MTextField textField_10 = new MTextField();
		textField_10.setBounds(250, 182, 25, 25);
		panel.add(textField_10);
		
		MTextField textField_11 = new MTextField();
		textField_11.setBounds(250, 227, 25, 25);
		panel.add(textField_11);
		
		MTextField textField_12 = new MTextField();
		textField_12.setBounds(250, 272, 25, 25);
		panel.add(textField_12);
		
		MTextField textField_13 = new MTextField();
		textField_13.setBounds(250, 317, 25, 25);
		panel.add(textField_13);
		
		MTextField textField_14 = new MTextField();
		textField_14.setBounds(370, 317, 25, 25);
		panel.add(textField_14);
		
		MTextField textField_15 = new MTextField();
		textField_15.setBounds(370, 272, 25, 25);
		panel.add(textField_15);
		
		MTextField textField_16 = new MTextField();
		textField_16.setBounds(370, 227, 25, 25);
		panel.add(textField_16);
		
		MTextField textField_17 = new MTextField();
		textField_17.setBounds(370, 137, 25, 25);
		panel.add(textField_17);
		
		MTextField textField_18 = new MTextField();
		textField_18.setBounds(370, 182, 25, 25);
		panel.add(textField_18);
		
		MTextField textField_19 = new MTextField();
		textField_19.setBounds(370, 92, 25, 25);
		panel.add(textField_19);
		
		MTextField textField_20 = new MTextField();
		textField_20.setBounds(370, 47, 25, 25);
		panel.add(textField_20);
		
		MButton button = new MButton((ImageIcon) null, (ImageIcon) null, (ImageIcon) null, new Point(100, 220), new Dimension(80, 25));
		button.setText("确定");
		button.setBounds(148, 367, 80, 25);
		panel.add(button);
		
		MButton button_1 = new MButton((ImageIcon) null, (ImageIcon) null, (ImageIcon) null, new Point(220, 220), new Dimension(80, 25));
		button_1.setText("取消");
		button_1.setBounds(273, 367, 80, 25);
		panel.add(button_1);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void addListener() {

	}

	public Frame getFrame() {
		return null;
	}

	public void setFrame(Frame f) {

	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FrameEditPane pane = new FrameEditPane();
	}
}
