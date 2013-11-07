package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MList extends JScrollPane{
	public MList(){
		
	}
	public MList(Object[] listdata,Point location,Dimension size){
		JList list=new JList(listdata);
		
		setOpaque(false);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setViewportView(list);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		setLocation(location);
		setSize(size);
	}

}
