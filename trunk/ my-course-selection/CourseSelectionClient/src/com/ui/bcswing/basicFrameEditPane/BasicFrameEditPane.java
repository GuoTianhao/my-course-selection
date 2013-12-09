package com.ui.bcswing.basicFrameEditPane;

import com.basicdata.CourseTypeKind;
import com.client.rmi.DeanMethodController;
import com.data.po.BasicFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.data.po.FrameElement;
import com.logicService.DeanMethod;
import com.ui.myswing.MButton;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

public class BasicFrameEditPane extends MFrame {
	private MPanel editPanel;
	private static Dimension default_size = new Dimension(525, 550);
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
	private DeanMethod method = DeanMethodController.getMethod();
	private String[][] elementStr = new String[8][3];
	private MTextField textField;
	private MTextField textField_1;
	private MTextField textField_2;
	private MTextField textField_3;
	private MTextField textField_4;
	private MTextField textField_5;
	private MTextField textField_6;
	private MTextField textField_7;
	private MTextField textField_8;
	private MTextField textField_9;
	private MTextField textField_10;
	private MTextField textField_11;
	private MTextField textField_12;
	private MTextField textField_13;
	private MTextField textField_14;
	private MTextField textField_15;
	private MTextField textField_16;
	private MTextField textField_17;
	private MTextField textField_18;
	private MTextField textField_19;
	private MTextField textField_20;
	private MTextField textField_21;
	private MTextField textField_22;
	private MTextField textField_23;
	private MTextField textField_24;
	private MTextField textField_25;
	private MTextField textField_26;
	private MTextField textField_27;
	private MTextField textField_28;
	private MTextField textField_29;
	private MTextField textField_30;
	private MTextField textField_31;
	private MTextField textField_32;
	private MTextField textField_33;
	private MTextField textField_34;

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
		moduleField.setText(CourseTypeKind.getAllCourseName()[0]);
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
		yesBtn.setLocation(140, 410);
		yesBtn.setText("确定");
		noBtn = new MButton(null, null, null, new Point(220, 220),
				new Dimension(80, 25));
		noBtn.setLocation(265, 410);
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

		textField = new MTextField();
		textField.setText(CourseTypeKind.getAllCourseName()[1]);
		textField.setEditable(false);
		textField.setBounds(30, 90, 150, 25);
		editPanel.add(textField);

		textField_1 = new MTextField();
		textField_1.setText(CourseTypeKind.getAllCourseName()[2]);
		textField_1.setEditable(false);
		textField_1.setBounds(30, 135, 150, 25);
		editPanel.add(textField_1);

		textField_2 = new MTextField();
		textField_2.setText(CourseTypeKind.getAllCourseName()[3]);
		textField_2.setEditable(false);
		textField_2.setBounds(30, 180, 150, 25);
		editPanel.add(textField_2);

		textField_3 = new MTextField();
		textField_3.setText(CourseTypeKind.getAllCourseName()[4]);
		textField_3.setEditable(false);
		textField_3.setBounds(30, 225, 150, 25);
		editPanel.add(textField_3);

		textField_4 = new MTextField();
		textField_4.setText(CourseTypeKind.getAllCourseName()[5]);
		textField_4.setEditable(false);
		textField_4.setBounds(30, 270, 150, 25);
		editPanel.add(textField_4);

		textField_5 = new MTextField();
		textField_5.setText(CourseTypeKind.getAllCourseName()[6]);
		textField_5.setEditable(false);
		textField_5.setBounds(30, 315, 150, 25);
		editPanel.add(textField_5);

		textField_6 = new MTextField();
		textField_6.setBounds(220, 90, 25, 25);
		editPanel.add(textField_6);

		MLabel label = new MLabel("~");
		label.setBounds(245, 90, 25, 25);
		editPanel.add(label);

		textField_7 = new MTextField();
		textField_7.setBounds(270, 90, 25, 25);
		editPanel.add(textField_7);

		textField_8 = new MTextField();
		textField_8.setBounds(270, 135, 25, 25);
		editPanel.add(textField_8);

		textField_9 = new MTextField();
		textField_9.setBounds(220, 135, 25, 25);
		editPanel.add(textField_9);

		MLabel label_1 = new MLabel("~");
		label_1.setBounds(245, 135, 25, 25);
		editPanel.add(label_1);

		textField_10 = new MTextField();
		textField_10.setBounds(270, 180, 25, 25);
		editPanel.add(textField_10);

		textField_11 = new MTextField();
		textField_11.setBounds(220, 180, 25, 25);
		editPanel.add(textField_11);

		MLabel label_2 = new MLabel("~");
		label_2.setBounds(245, 180, 25, 25);
		editPanel.add(label_2);

		textField_12 = new MTextField();
		textField_12.setBounds(270, 225, 25, 25);
		editPanel.add(textField_12);

		textField_13 = new MTextField();
		textField_13.setBounds(220, 225, 25, 25);
		editPanel.add(textField_13);

		MLabel label_3 = new MLabel("~");
		label_3.setBounds(245, 225, 25, 25);
		editPanel.add(label_3);

		textField_14 = new MTextField();
		textField_14.setBounds(270, 270, 25, 25);
		editPanel.add(textField_14);

		textField_15 = new MTextField();
		textField_15.setBounds(220, 270, 25, 25);
		editPanel.add(textField_15);

		MLabel label_4 = new MLabel("~");
		label_4.setBounds(245, 270, 25, 25);
		editPanel.add(label_4);

		textField_16 = new MTextField();
		textField_16.setBounds(270, 315, 25, 25);
		editPanel.add(textField_16);

		textField_17 = new MTextField();
		textField_17.setBounds(220, 315, 25, 25);
		editPanel.add(textField_17);

		MLabel label_5 = new MLabel("~");
		label_5.setBounds(245, 315, 25, 25);
		editPanel.add(label_5);

		textField_18 = new MTextField();
		textField_18.setBounds(350, 90, 25, 25);
		editPanel.add(textField_18);

		MLabel label_6 = new MLabel("~");
		label_6.setBounds(375, 90, 25, 25);
		editPanel.add(label_6);

		textField_19 = new MTextField();
		textField_19.setBounds(400, 90, 25, 25);
		editPanel.add(textField_19);

		textField_20 = new MTextField();
		textField_20.setBounds(350, 135, 25, 25);
		editPanel.add(textField_20);

		MLabel label_7 = new MLabel("~");
		label_7.setBounds(375, 135, 25, 25);
		editPanel.add(label_7);

		textField_21 = new MTextField();
		textField_21.setBounds(400, 135, 25, 25);
		editPanel.add(textField_21);

		textField_22 = new MTextField();
		textField_22.setBounds(350, 180, 25, 25);
		editPanel.add(textField_22);

		MLabel label_8 = new MLabel("~");
		label_8.setBounds(375, 180, 25, 25);
		editPanel.add(label_8);

		textField_23 = new MTextField();
		textField_23.setBounds(400, 180, 25, 25);
		editPanel.add(textField_23);

		textField_24 = new MTextField();
		textField_24.setBounds(350, 225, 25, 25);
		editPanel.add(textField_24);

		MLabel label_9 = new MLabel("~");
		label_9.setBounds(375, 225, 25, 25);
		editPanel.add(label_9);

		textField_25 = new MTextField();
		textField_25.setBounds(400, 225, 25, 25);
		editPanel.add(textField_25);

		textField_26 = new MTextField();
		textField_26.setBounds(350, 270, 25, 25);
		editPanel.add(textField_26);

		MLabel label_10 = new MLabel("~");
		label_10.setBounds(375, 270, 25, 25);
		editPanel.add(label_10);

		textField_27 = new MTextField();
		textField_27.setBounds(400, 270, 25, 25);
		editPanel.add(textField_27);

		textField_28 = new MTextField();
		textField_28.setBounds(350, 315, 25, 25);
		editPanel.add(textField_28);

		MLabel label_11 = new MLabel("~");
		label_11.setBounds(375, 315, 25, 25);
		editPanel.add(label_11);

		textField_29 = new MTextField();
		textField_29.setBounds(400, 315, 25, 25);
		editPanel.add(textField_29);

		textField_30 = new MTextField();
		textField_30.setText(CourseTypeKind.getAllCourseName()[7]);
		textField_30.setEditable(false);
		textField_30.setBounds(30, 360, 150, 25);
		editPanel.add(textField_30);

		textField_31 = new MTextField();
		textField_31.setBounds(220, 360, 25, 25);
		editPanel.add(textField_31);

		MLabel label_12 = new MLabel("~");
		label_12.setBounds(245, 360, 25, 25);
		editPanel.add(label_12);

		textField_32 = new MTextField();
		textField_32.setBounds(270, 360, 25, 25);
		editPanel.add(textField_32);

		textField_33 = new MTextField();
		textField_33.setBounds(350, 360, 25, 25);
		editPanel.add(textField_33);

		MLabel label_13 = new MLabel("~");
		label_13.setBounds(375, 360, 25, 25);
		editPanel.add(label_13);

		textField_34 = new MTextField();
		textField_34.setBounds(400, 360, 25, 25);
		editPanel.add(textField_34);

		getContentPane().add(editPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void addListener() {
		yesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					method.modifyFrame(getBasicFrame());
					BasicFrameEditPane.this.dispose();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		noBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BasicFrameEditPane.this.dispose();
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int val = JOptionPane.showConfirmDialog(rootPane, "是否保存当前更改？",
						"提醒", JOptionPane.YES_NO_OPTION);
				switch (val) {
				case JOptionPane.YES_OPTION:
					try {
						method.modifyFrame(getBasicFrame());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case JOptionPane.NO_OPTION:
					break;
				default:
					break;
				}
			}
		});

	}

	public void setBasicFrame(BasicFrame frame) {
		Iterator<FrameElement> it = frame.iterator();
		MTextField[][] textFields = {
				{ moduleField, creditField1, creditField2, periodField1,
						periodField2 },
				{ textField, textField_6, textField_7, textField_18,
						textField_19 },
				{ textField_1, textField_9, textField_8, textField_20,
						textField_21 },
				{ textField_2, textField_11, textField_10, textField_22,
						textField_23 },
				{ textField_3, textField_13, textField_12, textField_24,
						textField_25 },
				{ textField_4, textField_15, textField_14, textField_26,
						textField_27 },
				{ textField_5, textField_17, textField_16, textField_28,
						textField_29 },
				{ textField_30, textField_31, textField_32, textField_33,
						textField_34 } };
		int i = 0;
		while (it.hasNext()) {
			FrameElement e = (FrameElement) it.next();
			String textStr[] = new String[5];
			textStr[0] = CourseTypeKind.getName(e.getType());
			textStr[1] = e.getCredit().split("_")[0];
			textStr[2] = e.getCredit().split("_")[1];
			textStr[3] = e.getPeriod().split("_")[0];
			textStr[4] = e.getPeriod().split("_")[1];
			for (int j = 0; j < textFields[i].length; j++) {
				textFields[i][j].setText(textStr[j]);
			}
			i++;
		}

	}

	public BasicFrame getBasicFrame() {
		BasicFrame frame = new BasicFrame();
		elementStr[0][0] = CourseTypeKind.getType(moduleField.getText());
		elementStr[0][1] = creditField1.getText() + "_"
				+ creditField2.getText();
		elementStr[0][2] = periodField1.getText() + "_"
				+ periodField2.getText();
		elementStr[1][0] = CourseTypeKind.getType(textField.getText());
		elementStr[1][1] = textField_6.getText() + "_" + textField_7.getText();
		elementStr[1][2] = textField_18.getText() + "_"
				+ textField_19.getText();
		elementStr[2][0] = CourseTypeKind.getType(textField_1.getText());
		elementStr[2][1] = textField_9.getText() + "_" + textField_8.getText();
		elementStr[2][2] = textField_20.getText() + "_"
				+ textField_21.getText();
		elementStr[3][0] = CourseTypeKind.getType(textField_2.getText());
		elementStr[3][1] = textField_11.getText() + "_"
				+ textField_10.getText();
		elementStr[3][2] = textField_22.getText() + "_"
				+ textField_23.getText();
		elementStr[4][0] = CourseTypeKind.getType(textField_3.getText());
		elementStr[4][1] = textField_13.getText() + "_"
				+ textField_12.getText();
		elementStr[4][2] = textField_24.getText() + "_"
				+ textField_25.getText();
		elementStr[5][0] = CourseTypeKind.getType(textField_4.getText());
		elementStr[5][1] = textField_15.getText() + "_"
				+ textField_14.getText();
		elementStr[5][2] = textField_26.getText() + "_"
				+ textField_27.getText();
		elementStr[6][0] = CourseTypeKind.getType(textField_5.getText());
		elementStr[6][1] = textField_17.getText() + "_"
				+ textField_16.getText();
		elementStr[6][2] = textField_28.getText() + "_"
				+ textField_29.getText();
		elementStr[7][0] = CourseTypeKind.getType(textField_30.getText());
		elementStr[7][1] = textField_31.getText() + "_"
				+ textField_32.getText();
		elementStr[7][2] = textField_33.getText() + "_"
				+ textField_34.getText();
		for (int i = 0; i < elementStr.length; i++) {
			frame.addFrameElement(new FrameElement(elementStr[i][0],
					elementStr[i][1], elementStr[i][2]));
		}
		return frame;
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
