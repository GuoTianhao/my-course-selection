package com.ui.myswing;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MDefaultTableModel extends DefaultTableModel {
	private EditPermission edit;
	public MDefaultTableModel() {
		this(0, 0);
	}

	public MDefaultTableModel(int rowCount, int columnCount) {
		super(rowCount, columnCount);
	}

	public MDefaultTableModel(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	public MDefaultTableModel(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	public MDefaultTableModel(Vector data, Vector columnNames) {
		super(data, columnNames);
	}

	public MDefaultTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}
	
	public Vector getColumnIdentifiers(){
		return columnIdentifiers;
	}
	
	public void setDataVector(Vector dataVector){
		super.setDataVector(dataVector,columnIdentifiers);
	}

	public boolean isCellEditable(int row, int column) {
		if(edit!=null){
			return edit.isEditable(row, column);
		}
		return false;
	}
	
	public void setEditable(EditPermission edit){
		this.edit=edit;
	}
}
