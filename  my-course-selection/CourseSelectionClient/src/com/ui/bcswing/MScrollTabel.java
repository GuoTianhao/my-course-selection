package com.ui.bcswing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.ui.myswing.EditPermission;
import com.ui.myswing.MDefaultTableModel;
import com.ui.myswing.MTable;

public class MScrollTabel extends JScrollPane {
	private static MDefaultTableModel model = new MDefaultTableModel();
	private static MTable table = new MTable(model);
	private static TableRowSorter<TableModel> sort=new TableRowSorter<TableModel>();

	public MScrollTabel(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
	}

	public MScrollTabel(Component view) {
		super(view);
		this.setHorizontalScrollBarPolicy(MScrollTabel.HORIZONTAL_SCROLLBAR_NEVER);
		this.setVerticalScrollBarPolicy(MScrollTabel.VERTICAL_SCROLLBAR_ALWAYS);
		sort.setModel(model);
		table.setRowSorter(sort);
	}

	public MScrollTabel(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
	}

	public MScrollTabel(Point loc, Dimension size) {
		this(table);
		this.setLocation(loc);
		this.setSize(size);
	}
	
	public MScrollTabel(){
		this(table);
	}
	
	public MTable getTable(){
		return table;
	}
	
	public MDefaultTableModel getModel(){
		return model;
	}

	public void setDataVector(Vector dataVector, Vector columnIdentifiers) {
		model.setDataVector(dataVector, columnIdentifiers);
	}
	
	public void setDataVecot(Vector dataVector){
		model.setDataVector(dataVector);
	}

	public int getRowCount() {
		return model.getRowCount();
	}

	public int getColumnCount() {
		return model.getColumnCount();
	}

	public String getColumnName(int columnIndex) {
		return model.getColumnName(columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return model.getValueAt(rowIndex, columnIndex);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		model.setValueAt(aValue, rowIndex, columnIndex);
	}

	public void addTableModelListener(TableModelListener l) {
		model.addTableModelListener(l);
	}

	public void removeTableModelListener(TableModelListener l) {
		model.removeTableModelListener(l);
	}

	public Vector getDataVector() {
		return model.getDataVector();
	}

	public void setNumRows(int rowCount) {
		model.setNumRows(rowCount);
	}

	public void setRowCount(int rowCount) {
		model.setNumRows(rowCount);
	}

	public void addRow(Vector rowData) {
		model.addRow(rowData);
	}

	public void addRow(Object[] rowData) {
		model.addRow(rowData);
	}

	public void insertRow(int row, Vector rowData) {
		model.insertRow(row, rowData);
	}

	public void insertRow(int row, Object[] rowData) {
		model.insertRow(row, rowData);
	}

	public void removeRow(int row) {
		model.removeRow(row);
	}

	public void setColumnIdentifiers(Vector columnIdentifiers) {
		model.setColumnIdentifiers(columnIdentifiers);
	}

	public void setColumnIdentifiers(Object[] newIdentifiers) {
		model.setColumnIdentifiers(newIdentifiers);
	}
	
	public Vector getColumnIdentifiers(){
		return model.getColumnIdentifiers();
	}

	public void setColumnCount(int columnCount) {
		model.setColumnCount(columnCount);
	}

	public void addColumn(Object columnName) {
		model.addColumn(columnName);
	}

	public void addColumn(Object columnName, Vector columnData) {
		model.addColumn(columnName, columnData);
	}

	public void addColumn(Object columnName, Object[] columnData) {
		model.addColumn(columnName);
	}
	
	public void setEditable(EditPermission edit){
		model.setEditable(edit);
	}
	
	public void addMouseListener(MouseListener l){
		table.addMouseListener(l);
	}
	public void regrexFilter(String text){
		sort.setRowFilter(RowFilter.regexFilter(text));
	}
}
