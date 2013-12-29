package com.server.test;

import java.sql.Connection;
import java.sql.Statement;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Dean;
import com.logic.method.deanRelative.DeanGetter;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class DeanGetterTest extends TestCase{

	public void setUp(){
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO dean (ID,Name) VALUES('40000000','测试教务员名字')";
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
			sql = "DELETE FROM dean WHERE ID='40000000'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}
	}
	
	public void testGetDean_1(){
		Dean d=DeanGetter.getDean("40000000");
		
		assertEquals(d.getName(),"测试教务员名字");
	}
	
	public void testGetDean_2(){
		Dean d=DeanGetter.getDean("40000001");
		
		assertNull(d);
	}

}
