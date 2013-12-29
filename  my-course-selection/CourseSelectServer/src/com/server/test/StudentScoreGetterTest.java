package com.server.test;

import java.sql.Connection;
import java.sql.Statement;

import com.data.dataImpl.method.DatabaseConnection;
import com.logic.method.studentRelative.StudentScoreGetter;

import junit.framework.TestCase;

public class StudentScoreGetterTest extends TestCase{
	protected void setUp() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9999','测试课程','E','2','1025')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000000','1025','2010','测试学生')";
			st.execute(sql);
			sql = "INSERT INTO courseScore (cID,sID,score) VALUES('9999','30000000','99')";
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
			sql = "DELETE FROM student WHERE ID='30000000'";
			st.execute(sql);
			sql = "DELETE FROM course WHERE ID='9999'";
			st.execute(sql);
			sql = "DELETE FROM courseScore WHERE cID='9999'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}
	
	public void testGetScore_1(){
		assertTrue(StudentScoreGetter.getScore("30000000", "9999")==99);
	}
	
	public void testGetScore_2(){
		assertTrue(StudentScoreGetter.getScore("30000001", "9999")==0);
	}

}
