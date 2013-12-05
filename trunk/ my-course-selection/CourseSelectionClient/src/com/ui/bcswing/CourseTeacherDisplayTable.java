package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

public class CourseTeacherDisplayTable extends TeacherDisplayTable{

	public CourseTeacherDisplayTable(Point loc, Dimension size) {
		super(loc, size);
	}

	public void setSelectIntervalRowByContent(List<String> list,int column){
		table.selectAll();
		int count=table.getRowCount();
		for(int i=0;i<count;i++){
			if(!list.contains(table.getValueAt(i,column))){
				table.removeRowSelectionInterval(i,i);
			}
		}
	}
}
