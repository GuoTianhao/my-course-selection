package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.ui.myswing.MButton;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class TitleBar extends MPanel{
	private MLabel message;
	private MButton logout;
	private MButton passwordChange;
	public TitleBar(Point loc,Dimension size){
		super(loc,size);
		creatComponent();
	}
	private void creatComponent(){
		logout=new MButton(null,null,null,new Point(680,5),new Dimension(100,30));
		logout.setText("注销");
		passwordChange=new MButton(null,null,null,new Point(680,40),new Dimension(100,30));
		passwordChange.setText("修改密码");
		message=new MLabel(new Point(0,20),new Dimension(300,50));
		message.setText("Welcome My !");
		this.add(logout);
		this.add(passwordChange);
		this.add(message);
	}
	
	public void addLogoutListener(ActionListener al){
		logout.addActionListener(al);
	}
	
	public void addPasswordChangeListener(ActionListener al){
		passwordChange.addActionListener(al);
	}
	
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		MPanel p=new MPanel(f.getSize());
		p.add(new TitleBar(new Point(0,0),new Dimension(p.getSize().width,100)));
		f.add(p);
		f.refresh();
	}
	
}
