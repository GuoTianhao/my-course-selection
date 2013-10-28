package com.ui.myswing;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class MTable extends JTable {
	private static final Color default_selectionBackground = new Color(0xFFB90F);
	private static final Color default_selectionForeground = new Color(0xBF3EFF);

	public MTable() {
		this(null, null, null);
	}

	public MTable(TableModel dm) {
		this(dm, null, null);
	}

	public MTable(TableModel dm, TableColumnModel cm) {
		this(dm, cm, null);
	}

	public MTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		this.setSelectionBackground(default_selectionBackground);
		this.setSelectionForeground(default_selectionForeground);
	}

	public MTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	public MTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
	}

	public MTable(final Object[][] rowData, final Object[] columnNames) {
		super(rowData, columnNames);
	}

}
