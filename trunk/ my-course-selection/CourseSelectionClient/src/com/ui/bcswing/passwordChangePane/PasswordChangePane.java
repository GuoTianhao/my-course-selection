package com.ui.bcswing.passwordChangePane;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.ui.bcswing.TipFrame;
import com.ui.myswing.MButton;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MPasswordField;
import com.ui.myswing.MTextField;

public class PasswordChangePane extends MFrame {
	private static Dimension default_size = new Dimension(280, 280);

	protected MPanel panel;
	protected MLabel oPasswordLb;
	protected MLabel mPasswordLb;
	protected MLabel mPasswordALb;
	protected MPasswordField oPassword;
	protected MPasswordField mPassword;
	protected MPasswordField mPasswordA;

	protected MButton confirm;
	
	public PasswordChangePane() {
		super(default_size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		panel = new MPanel(new Point(0, 0), default_size);

		oPasswordLb = new MLabel(new Point(30, 50), new Dimension(100, 25),
				"原密码");
		mPasswordLb = new MLabel(new Point(30, 100), new Dimension(100, 25),
				"新密码");
		mPasswordALb = new MLabel(new Point(30, 150), new Dimension(100, 25),
				"确认新密码");

		oPassword = new MPasswordField(new Point(120, 50), new Dimension(100, 25));
		mPassword = new MPasswordField(new Point(120, 100), new Dimension(100, 25));
		mPasswordA = new MPasswordField(new Point(120, 150), new Dimension(100, 25));

		
		confirm=new MButton(null,null,null,new Point(90,200),new Dimension(80,25));
		confirm.setText("确定");
		
		panel.add(oPasswordLb);
		panel.add(mPasswordLb);
		panel.add(mPasswordALb);
		panel.add(oPassword);
		panel.add(mPassword);
		panel.add(mPasswordA);
		panel.add(confirm);
		this.setLocationRelativeTo(null);
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
	
	public boolean isEqual(){
		String str1=mPassword.getText();
		String str2=mPasswordA.getText();
		return str1.equals(str2);
	}
	
	private void addListener(){
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!isEqual()) {
					TipFrame t = new TipFrame(getLocation(),getSize(), 5, "两次输入不一致");
					t.startEndClock();
				} 
			}

		});
		
	}
	
	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PasswordChangePane pane = new PasswordChangePane();
	}

}
