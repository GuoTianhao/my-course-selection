package com.client.ui.deanUI;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.client.ui.main.MainFrame;
import com.ui.bcswing.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class DeanMainPanel extends MPanel {
	private TitleBar title;
	private MButton btn1;
	private MButton btn2;
	private MButton btn3;
	private MButton btn4;
	private MButton btn5;
	private MButton btn6;
	private MLabel lb1;

	public DeanMainPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
	}

	private void createComponent() {
		title = new TitleBar(new Point(0, 0),
				new Dimension(this.getWidth(), 75));
//		lb1 = new MLabel("整体框架策略", new ImageIcon("blank.png"), SwingConstants.CENTER);
//		lb1.setHorizontalTextPosition(SwingConstants.CENTER);
//		lb1.setVerticalTextPosition(SwingConstants.BOTTOM);;
//		lb1.setBounds(85, 134, 180, 150);
		
		btn1 = new MButton("整体框架策略", new ImageIcon("blank.png"));
		btn1.setBounds(85, 134, 180, 150);
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		btn2 = new MButton("教学计划", new ImageIcon("blank.png"));
		btn2.setBounds(323, 134, 180, 150);
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		btn3 = new MButton("课程", new ImageIcon("blank.png"));
		btn3.setBounds(535, 134, 180, 150);
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		btn4 = new MButton("教师", new ImageIcon("blank.png"));
		btn4.setBounds(85, 344, 180, 150);
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn4.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		btn5 = new MButton("学生", new ImageIcon("blank.png"));
		btn5.setBounds(323, 344, 180, 150);
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn5.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		btn6 = new MButton("专业准入准出", new ImageIcon("blank.png"));
		btn6.setBounds(535, 344, 180, 150);
		btn6.setHorizontalTextPosition(SwingConstants.CENTER);
		btn6.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		this.add(title);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
//		this.add(lb1);
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f = new MainFrame();
		MPanel p = new MPanel(f.getSize());
		p.add(new DeanMainPanel(new Point(0, 0), new Dimension(
				p.getSize().width, p.getSize().height)));
		f.add(p);
		f.refresh();
	}
}
