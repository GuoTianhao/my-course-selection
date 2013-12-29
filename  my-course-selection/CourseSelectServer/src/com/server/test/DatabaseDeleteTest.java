package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.dataImpl.method.DatabaseDelete;
import com.data.dataImpl.method.DatabaseInsert;
import com.data.dataImpl.method.DatabaseSearch;

import junit.framework.TestCase;

public class DatabaseDeleteTest extends TestCase{
	protected void setUp(){
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('300000000','2000','2010','测试学生1')";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}
	
	protected void tearDown(){
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "DELETE FROM student WHERE ID='300000000'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败：" + ex.getMessage());
		}
	}
	
	public void testDelete(){
		assertTrue(DatabaseDelete.delete("student","ID","300000000"));
		
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT Name FROM student WHERE ID='300000000'";
			ResultSet res = st.executeQuery(sql);
			assertFalse(res.next());
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
	}
	
	public void testDelete_2(){
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Name");
		clue.add("300000000");
		clue.add("测试学生1");
		
		assertTrue(DatabaseDelete.delete("student",clueName,clue));
		
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT Name FROM student WHERE ID='300000000'";
			ResultSet res = st.executeQuery(sql);
			assertFalse(res.next());
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
	}
	
}
