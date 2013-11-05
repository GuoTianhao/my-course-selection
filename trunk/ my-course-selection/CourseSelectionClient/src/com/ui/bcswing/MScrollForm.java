package com.ui.bcswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import com.ui.myswing.MButton;
import com.ui.myswing.MFrame;
import com.ui.myswing.MPanel;

public class MScrollForm extends MFrame{
	MPanel panel;
	private JScrollPane scrollPane;
	private Dimension size;
	public MScrollForm(Dimension size){
		super(size);
		this.size=size;
		creatComponent();
	}
	private void creatComponent(){
		panel=new MPanel();
		panel.setPreferredSize(size);
		panel.setLocation(0, 0);
		panel.setBackground(Color.BLACK);
		panel.setVisible(true);
		
		scrollPane=new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.add(scrollPane);
	}
	public void setHeight(int height){
		panel.setPreferredSize(new Dimension(size.width,height));
		panel.repaint();
		panel.validate();
		scrollPane.repaint();
		scrollPane.validate();
		this.repaint();
		this.setVisible(true);
		this.validate();
	}
	public static void main(String[] args){
		MScrollForm f=new MScrollForm(new Dimension(300,400));
		f.go(f);
	}
	public void go(MScrollForm f){
		f.setLocation(400, 200);
		MButton b=new MButton(null,null,null,new Point(0,300),new Dimension(100,30));
		b.addActionListener(new L());
		f.panel.add(b);
	}
	class L implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MScrollForm.this.setHeight(size.height+100);
		}
	}
}
