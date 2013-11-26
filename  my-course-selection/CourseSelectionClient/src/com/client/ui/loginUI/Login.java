package com.client.ui.loginUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.basicdata.Identity;
import com.client.ui.main.MainUISwitchController;
import com.ui.myswing.*;

;

public class Login extends JFrame {
	private static int fHeight = 300;
	private static int fLength = 270;

	private MButton bLogin;
	private MTextField tID;
	private MPasswordField tPassword;
	private JComboBox select;
	public Login() {
		super();
		createAndShowUI();
	}

	private Component createComponent() {
		// button
		bLogin = new MButton(null, null, null, new Point(120, 125),
				new Dimension(60, 30));

		bLogin.setText("登陆");
		bLogin.addActionListener(new LoginListener());
		// textfiled
		tID = new MTextField(new Point(70, 19), new Dimension(120,
				38));
		tPassword = new MPasswordField(new Point(70, 68),
				new Dimension(120, 38));

		// label
		MLabel lID = new MLabel(new Point(0, 30), new Dimension(70, 10));
		lID.setText("ID:");
		MLabel lPassword = new MLabel(new Point(0, 80), new Dimension(70, 10));
		lPassword.setText("Password:");
		// ComboBox
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		select = new JComboBox(model);
		select.setSize(new Dimension(102, 20));
		select.setLocation(new Point(10, 130));
		model.addElement("教务员");
		model.addElement("院教务员");
		model.addElement("老师");
		model.addElement("学生");

		MPanel pLogin = new MPanel(new Dimension(fLength, fHeight));
		pLogin.add(lID);
		pLogin.add(lPassword);
		pLogin.add(tID);
		pLogin.add(tPassword);
		pLogin.add(bLogin);
		pLogin.add(select);
		return pLogin;
	}

	private void createAndShowUI() {
		add(createComponent());
		setSize(fLength, fHeight);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int index=select.getSelectedIndex();
		//	if(tID.isValidInput()&&tPassword.isValidInput()){
				if(LoginHandle.login(tID.getText(),tPassword.getText(),index)){
					MainUISwitchController controller=MainUISwitchController.getUISwitchController();
					switch(index){
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
				}else{
					System.out.println("帐号或密码错误");
				}
//			}else{
//				System.out.println("输入错误");
//			}
			
		}
		
	}
}
