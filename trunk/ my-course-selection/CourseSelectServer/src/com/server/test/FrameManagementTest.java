package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.BasicFrame;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.logic.method.FaucltyDeanRelative.FrameManagement;
import com.logic.method.deanRelative.BasicFrameManagement;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class FrameManagementTest extends TestCase{
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
			sql = "DELETE FROM Frame WHERE faculty='3000'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}

	}

	public void insertFrame() {
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('A','14','1~8','3000')";
			st.execute(sql);
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('B','13','1~8','3000')";
			st.execute(sql);
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('C','12','1~8','3000')";
			st.execute(sql);
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('D','11','1~8','3000')";
			st.execute(sql);
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('E','10','1~8','3000')";
			st.execute(sql);
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('F','9','1~8','3000')";
			st.execute(sql);
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('G','8','1~8','3000')";
			st.execute(sql);
			sql = "INSERT INTO frame (type,credit,period,faculty) VALUES ('L','7','1~8','3000')";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}

	public void testPublishBasicFrame_1() {
		insertFrame();
		boolean admit = FrameManagement.publishFrame(getFrame());
		assertFalse(admit);
	}

	public void testPublishBasicFrame_2() {
		Frame f=getFrame();
		boolean admit = FrameManagement.publishFrame(getFrame());
		assertTrue(admit);
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT period FROM Frame WHERE type='A' AND faculty="+"'"+f.getFaculty()+"'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			String period = res.getString("period");
			assertEquals(period, "1~8");
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
	}

	public void testModifyBasicFrame_1() {

		boolean admit=FrameManagement.modifyFrame(getFrame());
		assertFalse(admit);
	}
	
	public void testModifyBasicFrame_2() {
		insertFrame();
		Frame f=getFrame();
		boolean admit = FrameManagement.publishFrame(getFrame());
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT credit FROM Frame WHERE type='L' AND faculty="+"'"+f.getFaculty()+"'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			String credit = res.getString("credit");
			assertEquals(credit, "7");
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
	}

	public void testGetFrame_1(){
		Frame bf=FrameManagement.getFrame("3000");
		assertFalse(bf.iterator().hasNext());
	}
	
	public void testGetFrame_2(){
		insertFrame();
		Frame bf=FrameManagement.getFrame("3000");
		assertTrue(bf.iterator().hasNext());
	}
	
	public Frame getFrame() {
		FrameElement fe1 = new FrameElement("A", "14", "1~8");
		FrameElement fe2 = new FrameElement("B", "14", "1~8");
		FrameElement fe3 = new FrameElement("C", "5", "1~2");
		FrameElement fe4 = new FrameElement("D", "14", "1~8");
		FrameElement fe5 = new FrameElement("E", "14", "1~8");
		FrameElement fe6 = new FrameElement("F", "14", "1~8");
		FrameElement fe7 = new FrameElement("G", "14", "1~4");
		FrameElement fe8 = new FrameElement("L", "2", "7~8");
		Frame bf = new Frame("3000");
		bf.addFrameElement(fe1);
		bf.addFrameElement(fe2);
		bf.addFrameElement(fe3);
		bf.addFrameElement(fe4);
		bf.addFrameElement(fe5);
		bf.addFrameElement(fe6);
		bf.addFrameElement(fe7);
		bf.addFrameElement(fe8);
		return bf;
	}
	
}
