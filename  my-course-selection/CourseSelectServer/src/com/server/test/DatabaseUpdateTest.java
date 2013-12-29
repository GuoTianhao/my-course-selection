package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.dataImpl.method.DatabaseUpdate;
import com.server.start.DatabaseInit;

public class DatabaseUpdateTest extends TestCase{
	
	protected void setUp() {
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('300000000','1025','2010','测试学生1')";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}

	protected void tearDown() {
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
	
	public void testDatabaseUpadte(){
		DatabaseUpdate.update("student","ID","300000000", "Name","测试学生已改名字");
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT Name FROM student WHERE ID='300000000'";
			ResultSet res = st.executeQuery(sql);
			while(res.next()){
				assertTrue(res.getString("Name").equals("测试学生已改名字"));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
	}
}
