package com.ui.bcswing.passwordChangePane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.basicdata.Identity;
import com.client.rmi.TeacherMethodController;
import com.client.ui.teacherUI.TeacherUISwitchController;
import com.data.po.Teacher;
import com.logicService.TeacherMethod;
import com.ui.bcswing.TipFrame;

public class TeacherPasswordChangePane extends PasswordChangePane {
	
	public TeacherPasswordChangePane() {
		super();
		addListener();
	}

	private void addListener() {
		
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isEqual()) {
					TeacherMethod method = TeacherMethodController.getMethod();
					Teacher teacher = (Teacher) Identity.getIdentity();
					try {
						boolean admit = method.changePassword(teacher.getID(),
								oPassword.getText(), mPassword.getText());
						if (admit) {
							dispose();
							TeacherUISwitchController controller = TeacherUISwitchController
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
