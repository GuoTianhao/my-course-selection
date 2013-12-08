package com.data.excellIO;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.client.ui.dataAdapter.TeacherListToVectorAdapter;
import com.data.po.Teacher;

public class TeacherListExcelIn {
	public static Vector read(String fileName) {
		List<Teacher> teaList = new ArrayList<Teacher>();
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName+".xls"));
			Sheet sheet = book.getSheet(0);
			int rownum = sheet.getRows();
			for (int i = 1; i < rownum; i++) {
				teaList.add(new Teacher(sheet.getCell(0, i).getContents(),
						sheet.getCell(1, i).getContents(), 
						sheet.getCell(2, i).getContents()));
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return TeacherListToVectorAdapter.adapter(teaList);
	}
	public static boolean testFile(String fileName) {
		boolean cmd=false;
		String[] getStrings=fileName.split("\\.");
		if(!(getStrings[1].equals("xls"))) {
			cmd=false;
			return cmd;
		}
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = book.getSheet(0);
			if((sheet.getCell(0, 0).getContents().equals("ID"))
					&&(sheet.getCell(1, 0).getContents().equals("Nmae"))
					&&(sheet.getCell(2, 0).getContents().equals("Factuly")))
				cmd=true;
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cmd;
	}
}
