package com.client.ui.test;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.ui.bcswing.MScrollTabel;
import com.ui.myswing.MFrame;
import com.ui.myswing.MPanel;

public class ScrollTableTest {
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		MPanel p=new MPanel(f.getSize());
		p.setSize(f.getSize());
		p.setLayout(null);
		MScrollTabel t=new MScrollTabel(new Point(0,0),new Dimension(300,300));
		Vector<String> vc=new Vector<String>();
		vc.add("ID");
		vc.add("Name");
		vc.add("Faculty");
		Vector<Vector<String>> vd=new Vector<Vector<String>>();
		vd.add(vc);
		vd.add(vc);
		t.setDataVector(vd, vc);
		p.add(t);
		f.add(p);
		System.out.println("OK");
	}
}
