package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;
import com.data.dataImpl.method.DatabaseConnection;
import com.data.dataImpl.method.DatabaseDivide;
import com.data.dataImpl.method.DatabaseInsert;
import com.data.dataImpl.method.DatabaseNum;
import com.data.dataImpl.method.DatabaseSearch;
import com.data.dataImpl.method.DatabaseUpdate;
import com.logic.dataController.DatabaseController;

import junit.framework.TestCase;

public class DatabaseTest extends TestCase {
	public void setUp() {

	}

//	public void testSearch() {
//		System.out.println((DatabaseSearch.search("course", "ID", "0003", "Loc"))
//				.get(0));
//	}
//
//	public void testUpdate() {
//		System.out.println(DatabaseUpdate.update("course", "ID", "0003", "Loc", "仙"));
//	}

	public void testInsert() {
		List clue= new ArrayList<String>();
		List clueName = new ArrayList<String>();
		Calendar start = Calendar.getInstance();
		start.set(2014, 7, 31);
		Date s=start.getTime();
		System.out.println(s.toLocaleString());
		clue.add("period");
		clue.add("start");
		clueName.add("8");
		clueName.add(s.toLocaleString());
	
		System.out.println(DatabaseInsert.insert("time",clue, clueName));
	}

//	public void testDelete() {
//		// System.out.println(DatabaseController.getMethod().delete("course","type","A"));
//		Connection conn;
//		Statement st;
//		try {
//			conn = DatabaseConnection.getConnection();
//			st = conn.createStatement();
//			String sql;
//			// sql = "SELECT datepart(YYYY,time) FROM courseStudentWait";
//			sql = "DELETE FROM time";
//			// sql="INSERT INTO courseTeacher  (ID,Teacher) VALUES('0001','100000003')";
//			st.execute(sql);
//
//			conn.close();
//
//		} catch (Exception ex) {
//			System.out.println("删除失败:" + ex.getMessage());
//
//		}
//	}
	// public void testDivide(){
	// List list=new ArrayList<String>();
	// list.add("time");
	// DatabaseDivide.divide("courseTime","time",list,"ID");
	// }
	// public void testNum(){
	// List<String> clueName=new ArrayList<String>();
	// List<String> clue=new ArrayList<String>();
	// clueName.add("ID");
	// clue.add("0003");
	// System.out.println("Num:"+DatabaseNum.getNum("courseStudent", clueName,
	// clue));
	// }
}
