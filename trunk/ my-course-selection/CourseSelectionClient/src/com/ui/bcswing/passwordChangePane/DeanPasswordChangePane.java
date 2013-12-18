package com.ui.bcswing.passwordChangePane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.basicdata.Identity;
import com.client.rmi.DeanMethodController;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Dean;
import com.logicService.DeanMethod;
import com.ui.bcswing.TipFrame;

public class DeanPasswordChangePane extends PasswordChangePane {

	public DeanPasswordChangePane() {
		super();
		addListener();
	}

	private void addListener() {
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isEqual()) {
					DeanMethod method = DeanMethodController.getMethod();
					Dean dean = (Dean) Identity.getIdentity();
					try {
						boolean admit = method.changePassword(dean.getID(),
								oPassword.getText(), mPassword.getText());
						if (admit) {
							dispose();
							DeanUISwitchController controller = DeanUISwitchController
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
