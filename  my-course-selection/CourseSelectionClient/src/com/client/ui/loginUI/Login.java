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

import com.ui.myswing.*;

;

public class Login extends JFrame {
	private static int fHeight = 300;
	private static int fLength = 270;

	public Login() {
		super();
		createAndShowUI();
	}

	private Component createComponent() {
		// button
		MButton bLogin = new MButton(null, null, null, new Point(120, 125),
				new Dimension(60, 30));

		bLogin.setText("登陆");
		// textfiled
		MTextField tID = new MTextField(new Point(70, 19), new Dimension(120,
				38));
		MPasswordField tPassword = new MPasswordField(new Point(70, 68),
				new Dimension(120, 38));

		// label
		MLabel lID = new MLabel(new Point(0, 30), new Dimension(70, 10));
		lID.setText("ID:");
		MLabel lPassword = new MLabel(new Point(0, 80), new Dimension(70, 10));
		lPassword.setText("Password:");
		// ComboBox
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		JComboBox select = new JComboBox(model);
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
