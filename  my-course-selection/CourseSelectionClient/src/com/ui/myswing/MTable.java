package com.ui.myswing;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class MTable extends JTable {
	public MTable() {
		super(null, null, null);
	}

	public MTable(TableModel dm) {
		super(dm, null, null);
	}

	public MTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm, null);
	}

	public MTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
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
