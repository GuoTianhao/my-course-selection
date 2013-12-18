package com.ui.bcswing.passwordChangePane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.basicdata.Identity;
import com.client.rmi.StudentMethodController;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.TipFrame;

public class StudentPasswordChangePane extends PasswordChangePane{
	
	public StudentPasswordChangePane() {
		super();
		addListener();
	}

	private void addListener() {
		
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isEqual()) {
					StudentMethod method = StudentMethodController.getMethod();
					Student student = (Student) Identity.getIdentity();
					try {
						boolean admit = method.changePassword(student.getID(),
								oPassword.getText(), mPassword.getText());
						if (admit) {
							dispose();
							StudentUISwitchController controller = StudentUISwitchController
									.getUISwitchController();
							TipFrame t = new TipFrame(controller.getLoc(),
									controller.getSize(), 5, "修改密码成功");
							t.startEndClock();
						}else{
							TipFrame t = new TipFrame(getLocation(),getSize(), 5, "修改密码失败");
							t.startEndClock();

						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}

		});
	}

}
