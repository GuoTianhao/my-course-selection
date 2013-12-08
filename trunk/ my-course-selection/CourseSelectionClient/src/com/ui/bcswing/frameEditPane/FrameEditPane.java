package com.ui.bcswing.frameEditPane;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.basicdata.CourseTypeKind;
import com.basicdata.Identity;
import com.client.rmi.FacultyDeanMethodController;
import com.data.po.FacultyDean;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.logicService.FacultyDeanMethod;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;
import com.ui.myswing.MButton;

import javax.swing.ImageIcon;

public class FrameEditPane extends MFrame {
	private MPanel panel;
	private static Dimension default_size = new Dimension(525, 550);
	private String[][] elementsStr = new String[8][3];
	FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
	private MButton button;
	private MButton button_1;
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

	public FrameEditPane() {
		super(default_size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		panel = new MPanel(new Point(0, 0), default_size);

		MLabel label = new MLabel("课程模块");
		label.setBounds(73, 12, 80, 25);
		panel.add(label);

		MLabel label_1 = new MLabel("建议学分");
		label_1.setBounds(228, 12, 80, 25);
		panel.add(label_1);

		MLabel label_2 = new MLabel("开设学期");
		label_2.setBounds(350, 12, 80, 25);
		panel.add(label_2);

		textField = new MTextField(new Point(150, 20), new Dimension(150, 30));
		textField.setText(CourseTypeKind.getAllCourseName()[0]);
		textField.setEditable(false);
		textField.setBounds(38, 47, 150, 25);
		panel.add(textField);

		textField_1 = new MTextField();
		textField_1.setText(CourseTypeKind.getAllCourseName()[1]);
		textField_1.setEditable(false);
		textField_1.setBounds(38, 92, 150, 25);
		panel.add(textField_1);

		textField_2 = new MTextField();
		textField_2.setText(CourseTypeKind.getAllCourseName()[2]);
		textField_2.setEditable(false);
		textField_2.setBounds(38, 137, 150, 25);
		panel.add(textField_2);

		textField_3 = new MTextField();
		textField_3.setText(CourseTypeKind.getAllCourseName()[3]);
		textField_3.setEditable(false);
		textField_3.setBounds(38, 182, 150, 25);
		panel.add(textField_3);

		textField_4 = new MTextField();
		textField_4.setText(CourseTypeKind.getAllCourseName()[4]);
		textField_4.setEditable(false);
		textField_4.setBounds(38, 227, 150, 25);
		panel.add(textField_4);

		textField_5 = new MTextField();
		textField_5.setText(CourseTypeKind.getAllCourseName()[5]);
		textField_5.setEditable(false);
		textField_5.setBounds(38, 272, 150, 25);
		panel.add(textField_5);

		textField_6 = new MTextField();
		textField_6.setText(CourseTypeKind.getAllCourseName()[6]);
		textField_6.setEditable(false);
		textField_6.setBounds(38, 317, 150, 25);
		panel.add(textField_6);

		textField_7 = new MTextField();
		textField_7.setBounds(250, 47, 25, 25);
		panel.add(textField_7);

		textField_8 = new MTextField();
		textField_8.setBounds(250, 92, 25, 25);
		panel.add(textField_8);

		textField_9 = new MTextField();
		textField_9.setBounds(250, 137, 25, 25);
		panel.add(textField_9);

		textField_10 = new MTextField();
		textField_10.setBounds(250, 182, 25, 25);
		panel.add(textField_10);

		textField_11 = new MTextField();
		textField_11.setBounds(250, 227, 25, 25);
		panel.add(textField_11);

		textField_12 = new MTextField();
		textField_12.setBounds(250, 272, 25, 25);
		panel.add(textField_12);

		textField_13 = new MTextField();
		textField_13.setBounds(250, 317, 25, 25);
		panel.add(textField_13);

		textField_14 = new MTextField();
		textField_14.setBounds(350, 317, 25, 25);
		panel.add(textField_14);

		textField_15 = new MTextField();
		textField_15.setBounds(350, 272, 25, 25);
		panel.add(textField_15);

		textField_16 = new MTextField();
		textField_16.setBounds(350, 227, 25, 25);
		panel.add(textField_16);

		textField_17 = new MTextField();
		textField_17.setBounds(350, 137, 25, 25);
		panel.add(textField_17);

		textField_18 = new MTextField();
		textField_18.setBounds(350, 182, 25, 25);
		panel.add(textField_18);

		textField_19 = new MTextField();
		textField_19.setBounds(350, 92, 25, 25);
		panel.add(textField_19);

		textField_20 = new MTextField();
		textField_20.setBounds(350, 47, 25, 25);
		panel.add(textField_20);

		button = new MButton((ImageIcon) null, (ImageIcon) null,
				(ImageIcon) null, new Point(100, 220), new Dimension(80, 25));
		button.setText("确定");
		button.setBounds(148, 412, 80, 25);
		panel.add(button);

		button_1 = new MButton((ImageIcon) null, (ImageIcon) null,
				(ImageIcon) null, new Point(220, 220), new Dimension(80, 25));
		button_1.setText("取消");
		button_1.setBounds(273, 412, 80, 25);
		panel.add(button_1);
		
		MLabel label_3 = new MLabel("~");
		label_3.setBounds(375, 47, 25, 25);
		panel.add(label_3);
		
		MLabel label_4 = new MLabel("~");
		label_4.setBounds(375, 92, 25, 25);
		panel.add(label_4);
		
		MLabel label_5 = new MLabel("~");
		label_5.setBounds(375, 137, 25, 25);
		panel.add(label_5);
		
		MLabel label_6 = new MLabel("~");
		label_6.setBounds(375, 182, 25, 25);
		panel.add(label_6);
		
		MLabel label_7 = new MLabel("~");
		label_7.setBounds(375, 227, 25, 25);
		panel.add(label_7);
		
		MLabel label_8 = new MLabel("~");
		label_8.setBounds(375, 272, 25, 25);
		panel.add(label_8);
		
		MLabel label_9 = new MLabel("~");
		label_9.setBounds(375, 317, 25, 25);
		panel.add(label_9);
		
		textField_21 = new MTextField();
		textField_21.setBounds(400, 47, 25, 25);
		panel.add(textField_21);
		
		textField_22 = new MTextField();
		textField_22.setBounds(400, 92, 25, 25);
		panel.add(textField_22);
		
		textField_23 = new MTextField();
		textField_23.setBounds(400, 137, 25, 25);
		panel.add(textField_23);
		
		textField_24 = new MTextField();
		textField_24.setBounds(400, 182, 25, 25);
		panel.add(textField_24);
		
		textField_25 = new MTextField();
		textField_25.setBounds(400, 227, 25, 25);
		panel.add(textField_25);
		
		textField_26 = new MTextField();
		textField_26.setBounds(400, 272, 25, 25);
		panel.add(textField_26);
		
		textField_27 = new MTextField();
		textField_27.setBounds(400, 317, 25, 25);
		panel.add(textField_27);
		
		textField_28 = new MTextField();
		textField_28.setText(CourseTypeKind.getAllCourseName()[7]);
		textField_28.setEditable(false);
		textField_28.setBounds(38, 362, 150, 25);
		panel.add(textField_28);
		
		textField_29 = new MTextField();
		textField_29.setBounds(250, 362, 25, 25);
		panel.add(textField_29);
		
		textField_30 = new MTextField();
		textField_30.setBounds(350, 362, 25, 25);
		panel.add(textField_30);
		
		MLabel label_10 = new MLabel("~");
		label_10.setBounds(375, 362, 25, 25);
		panel.add(label_10);
		
		textField_31 = new MTextField();
		textField_31.setBounds(400, 362, 25, 25);
		panel.add(textField_31);

		getContentPane().add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void addListener() {
		
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FrameEditPane.this.dispose();
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
						method.modifyFrame(getFrame());
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

	public Frame getFrame() {
		FacultyDean fDean = (FacultyDean) Identity.getIdentity();
		Frame frame = new Frame(fDean.getFaculty());
		elementsStr[0][0] = CourseTypeKind.getType(textField.getText());
		elementsStr[0][1] = textField_7.getText();
		elementsStr[0][2] = textField_20.getText()+"_"+textField_21.getText();
		elementsStr[1][0] = CourseTypeKind.getType(textField_1.getText());
		elementsStr[1][1] = textField_8.getText();
		elementsStr[1][2] = textField_19.getText()+"_"+textField_22.getText();
		elementsStr[2][0] = CourseTypeKind.getType(textField_2.getText());
		elementsStr[2][1] = textField_9.getText();
		elementsStr[2][2] = textField_18.getText()+"_"+textField_23.getText();
		elementsStr[3][0] = CourseTypeKind.getType(textField_3.getText());
		elementsStr[3][1] = textField_10.getText();
		elementsStr[3][2] = textField_17.getText()+"_"+textField_24.getText();
		elementsStr[4][0] = CourseTypeKind.getType(textField_4.getText());
		elementsStr[4][1] = textField_11.getText();
		elementsStr[4][2] = textField_16.getText()+"_"+textField_25.getText();
		elementsStr[5][0] = CourseTypeKind.getType(textField_5.getText());
		elementsStr[5][1] = textField_12.getText();
		elementsStr[5][2] = textField_15.getText()+"_"+textField_26.getText();
		elementsStr[6][0] = CourseTypeKind.getType(textField_6.getText());
		elementsStr[6][1] = textField_13.getText();
		elementsStr[6][2] = textField_14.getText()+"_"+textField_27.getText();
		elementsStr[7][0] = CourseTypeKind.getType(textField_28.getText());
		elementsStr[7][1] = textField_29.getText();
		elementsStr[7][2] = textField_30.getText()+"_"+textField_31.getText();
		for (int i = 0; i < elementsStr.length; i++) {
			frame.addFrameElement(new FrameElement(elementsStr[i][0],
					elementsStr[i][1], elementsStr[i][2]));
		}
		return frame;
	}

	public void setFrame(Frame f) {

	}
	
	public void addConfirmListener(ActionListener al){
		button.addActionListener(al);
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
