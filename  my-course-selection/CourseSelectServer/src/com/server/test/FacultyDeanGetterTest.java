package com.server.test;

import java.sql.Connection;
import java.sql.Statement;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Dean;
import com.data.po.FacultyDean;
import com.logic.method.FaucltyDeanRelative.FacultyDeanGetter;
import com.logic.method.deanRelative.DeanGetter;

import junit.framework.TestCase;

public class FacultyDeanGetterTest extends TestCase{

	protected void setUp(){
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO facultyDean (ID,Name,Faculty) VALUES('40000000','测试院系教务员名字','1025')";
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
			sql = "DELETE FROM facultyDean WHERE ID='40000000'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}
	}
	
	public void testGetDean_1(){
		FacultyDean d=FacultyDeanGetter.getFacultyDean("40000000");
		
		assertEquals(d.getName(),"测试院系教务员名字");
	}
	
	public void testGetDean_2(){
		FacultyDean d=FacultyDeanGetter.getFacultyDean("40000001");
		
		assertNull(d);
	}

	
}
