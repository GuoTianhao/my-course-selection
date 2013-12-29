package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.data.dataImpl.method.DatabaseConnection;
import com.logic.method.TeacherRelative.ScoreRecord;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class ScoreRecordTest extends TestCase {
	String ID;
	protected void setUp() {
		DatabaseInit.init();
	}

	protected void tearDown() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "DELETE FROM courseScore WHERE cID="+"'"+ID+"'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}

	}
	
	public void testRecordScore(){
		ID="9999";
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("300000000", 99);
		map.put("300000001", 98);
		map.put("300000002", 97);
		map.put("300000003", 96);
		ScoreRecord.recordScore(ID, map);
		int score=0;
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT score FROM courseScore WHERE cID='"+ID+"'"+ " AND sID='300000001'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			score=res.getInt("score");
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
		assertTrue(score==map.get("300000001"));
	}
}
