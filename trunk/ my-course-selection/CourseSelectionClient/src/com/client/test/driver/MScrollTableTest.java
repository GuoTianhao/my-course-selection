package com.client.test.driver;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.ui.bcswing.MScrollTable;
import com.ui.myswing.EditPermission;
import com.ui.myswing.MFrame;
import com.ui.myswing.MPanel;

public class MScrollTableTest {
	public static void main(String[] args){
		 try {
	//		org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MFrame f=new MFrame();
		MPanel p=new MPanel();
		p.setLayout(null);
		f.setVisible(true);
		f.setSize(400, 400);
		f.setDefaultCloseOperation(MFrame.EXIT_ON_CLOSE);
		MScrollTable t=new MScrollTable();
		t.setSize(300,200);
		t.setLocation(0, 0);
		t.setEditable(new Edit());
		Vector<String> cName=new Vector<String>();
		cName.add("ID");
		cName.add("Name");
		Vector<Vector> v=new Vector<Vector>();
		Vector<String> r=new Vector<String>();
		r.add("121250000");
		r.add("刘钦");
		v.add(r);
	//	r.clear();
		r=new Vector<String>();
		r.add("121240000");
		r.add("邵栋");
		v.add(r);
		t.setColumnIdentifiers(cName);
		t.setRowCount(30);
		t.setDataVector(v, cName);
		t.addMouseListener(new TableListener(t.getTable()));
	//	t.regrexFilter("刘钦");

//		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
//        render.setOpaque(false);
//        t.getTable().setDefaultRenderer(Object.class, render);
//		t.getTable().setOpaque(false);
	
//JScrollPane 透明；		
//		t.setOpaque(false);
//		t.getViewport().setOpaque(false);
		
		p.add(t);
	//	p.setOpaque(false);
		p.setBackground(Color.GRAY);
		f.add(p);
		
	}
}
class Edit implements EditPermission{

	@Override
	public boolean isEditable(int row, int column) {
		if(column==-1){
			return true;
		}
		return false;
	}	
}
class TableListener extends MouseAdapter{
	private int count=0;
	private JTable t=null;
	private int selectNum=-1;
	public TableListener(JTable t){
		this.t=t;
	}
	public void mouseClicked(MouseEvent e){
		if(t.getSelectedRow()!=selectNum){
			count=1;
			selectNum=t.getSelectedRow();
		}else{
			count++;
			if(count%2==0){
				System.out.println("click");
				count=0;
			}
		}
	}
}
