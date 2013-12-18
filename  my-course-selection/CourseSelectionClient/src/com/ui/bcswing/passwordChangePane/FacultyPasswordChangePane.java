package com.ui.bcswing.passwordChangePane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.basicdata.Identity;
import com.client.rmi.FacultyDeanMethodController;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.data.po.FacultyDean;
import com.logicService.FacultyDeanMethod;
import com.ui.bcswing.TipFrame;

public class FacultyPasswordChangePane  extends PasswordChangePane {

	public FacultyPasswordChangePane() {
		super();
		addListener();
	}

	private void addListener() {
		
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isEqual()) {
					FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
					FacultyDean faculty = (FacultyDean) Identity.getIdentity();
					try {
						boolean admit = method.changePassword(faculty.getID(),
								oPassword.getText(), mPassword.getText());
						if (admit) {
							dispose();
							FacultyUISwitchController controller = FacultyUISwitchController
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
