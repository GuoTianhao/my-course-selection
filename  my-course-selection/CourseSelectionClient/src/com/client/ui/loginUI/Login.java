package com.client.ui.loginUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.client.ui.main.MainUISwitchController;
import com.ui.myswing.*;

public class Login extends JFrame {
	private static int fHeight = 300;
	private static int fLength = 270;

	private MButton bLogin;
	private MTextField tID;
	private MPasswordField tPassword;
	private JComboBox select;
	private MLabel icon;

	public Login() {
		super();
		createAndShowUI();
		addListener();
		init();
	}

	private Component createComponent() {
		// button
		bLogin = new MButton(null, null, null, new Point(120, 125),
				new Dimension(60, 30));
		bLogin.setSize(60, 25);
		bLogin.setLocation(165, 225);

		bLogin.setText("登录");

		// textfiled
		tID = new MTextField(new Point(70, 19), new Dimension(120, 25));
		tID.setLocation(80, 140);
		tPassword = new MPasswordField(new Point(70, 68),
				new Dimension(120, 25));
		tPassword.setLocation(80, 180);

		// label
		MLabel lID = new MLabel(new Point(20, 30), new Dimension(50, 25));
		lID.setSize(35, 25);
		lID.setLocation(32, 140);
		lID.setText("ID");
		MLabel lPassword = new MLabel(new Point(20, 80), new Dimension(50, 25));
		lPassword.setSize(35, 25);
		lPassword.setLocation(32, 180);
		lPassword.setText("密码");
		icon = new MLabel("南京大学教务系统", new ImageIcon("resource//icon.png"), SwingConstants.CENTER);
		icon.setBounds(5, 10, 250, 120);
		icon.setFont(new Font("微软雅黑", Font.ITALIC, 18));
		
		// ComboBox
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		select = new JComboBox(model);
		select.setSize(new Dimension(110, 25));
		select.setLocation(new Point(20, 225));
		model.addElement("教务员");
		model.addElement("院系教务员");
		model.addElement("老师");
		model.addElement("学生");

		MPanel pLogin = new MPanel(new Dimension(fLength, fHeight));
		pLogin.add(lID);
		pLogin.add(lPassword);
		pLogin.add(tID);
		pLogin.add(tPassword);
		pLogin.add(bLogin);
		pLogin.add(select);
		pLogin.add(icon);
		return pLogin;
	}

	private void createAndShowUI() {
		getContentPane().add(createComponent());
		setSize(fLength, fHeight);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addListener() {
		
		bLogin.addActionListener(new LoginListener());
		
	}
	
	private void init(){

	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = select.getSelectedIndex();
			if (tID.isValidInput() && tPassword.isValidInput()) {
				if (LoginHandle
						.login(tID.getText(), tPassword.getText(), index)) {
					MainUISwitchController controller = MainUISwitchController
							.getUISwitchController();
					switch (index) {
					case 0:
						controller.switchToDeanMainPanel();
						break;
					case 1:
						controller.switchToFacultyDeanMainPanel();
						break;
					case 2:
						controller.switchToTeacherMainPanel();
						break;
					case 3:
						controller.switchToStudentMainPanel();
						break;
					}
					Login.this.dispose();
				} else {
					System.out.println("帐号或密码错误");
				}
			} else {
				System.out.println("输入错误");
			}

		}

	}
}
