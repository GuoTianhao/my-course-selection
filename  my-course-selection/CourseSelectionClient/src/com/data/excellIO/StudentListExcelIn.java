package com.data.excellIO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jxl.Sheet;
import jxl.Workbook;

import com.client.ui.dataAdapter.StudentListToVectorAdapter;
import com.data.po.Student;

public class StudentListExcelIn {
	public static Vector read(String fileName) {
		Vector<Vector> res = new Vector<Vector>();
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = book.getSheet(0);
			int rownum = sheet.getRows();
			for (int i = 1; i < rownum; i++) {
				Vector row = new Vector<>();
				row.add(sheet.getCell(0, i).getContents());
				row.add(sheet.getCell(1, i).getContents());
				row.add(sheet.getCell(2, i).getContents());
				res.add(row);
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
	public static boolean testFile(String fileName) {
		boolean cmd=false;
		System.out.println(fileName);
		String[] getStrings=fileName.split("\\.");
		System.out.println(getStrings[0]);
		if(!(getStrings[1].equals("xls"))) {
			cmd=false;
			return cmd;
		}
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = book.getSheet(0);
			if((sheet.getCell(0, 0).getContents().equals("ID"))
					&&(sheet.getCell(1, 0).getContents().equals("Name"))
					&&(sheet.getCell(2, 0).getContents().equals("Grade")))
				cmd=true;
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cmd;
	}
	public static void main(String[] args){
		StudentListExcelIn.testFile("test.r");
	}
}
