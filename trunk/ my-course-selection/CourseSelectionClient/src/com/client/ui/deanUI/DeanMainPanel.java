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
	private MLabel lb2;
	private MLabel lb3;
	private MLabel lb4;
	private MLabel lb5;
	private MLabel lb6;

	public DeanMainPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
	}

	private void createComponent() {
		title = new TitleBar(new Point(0, 0),
				new Dimension(this.getWidth(), 75));
//		btn1 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
//				85, 134), new Dimension(180, 120));
		btn2 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				323, 134), new Dimension(180, 120));
		btn3 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				535, 134), new Dimension(180, 120));
		btn4 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				85, 344), new Dimension(180, 120));
		btn5 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				323, 134), new Dimension(180, 120));
		btn6 = new MButton(new ImageIcon("blank.png"), null, null, new Point(
				535, 134), new Dimension(180, 120));
//		lb1 = new MLabel("整体框架策略", new ImageIcon("blank.png"), SwingConstants.CENTER);
//		lb1.setHorizontalTextPosition(SwingConstants.CENTER);
//		lb1.setVerticalTextPosition(SwingConstants.BOTTOM);;
//		lb1.setBounds(85, 134, 180, 150);
		
		btn1 = new MButton("整体框架策略", new ImageIcon("blank.png"));
		btn1.setBounds(85, 134, 180, 150);
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		this.add(title);
		this.add(btn1);
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
