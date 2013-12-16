package com.data.dataImpl.method.dean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.data.dataImpl.method.DatabaseInsert;
import com.dataService.DeanDatabaseMethod;
import com.logic.dataController.DeanDataController;

public class TimeSetter {
	public static boolean setTime(String period, Date start){
		DeanDatabaseMethod method=DeanDataController.getMethod();
		method.delete("time", "period", period);
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		clueName.add("period");
		clueName.add("start");
		clue.add(period);
		clue.add(start.toLocaleString());
		method.insert("time", clueName, clue);
		return true;
	}
}
