package com.client.ui.main;


import java.awt.Dimension;

import javax.swing.JFrame;

import com.ui.myswing.MFrame;


public class MainFrame extends MFrame{
	private Dimension default_size=new Dimension(700,600);
	public MainFrame(){
		super();
		this.setSize(default_size);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Dimension getSize(){
		return default_size;
	}
}
