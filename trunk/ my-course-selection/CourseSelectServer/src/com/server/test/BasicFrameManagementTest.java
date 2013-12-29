package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.BasicFrame;
import com.data.po.FrameElement;
import com.logic.method.deanRelative.BasicFrameManagement;

import junit.framework.TestCase;

public class BasicFrameManagementTest extends TestCase {
	
	protected void setUp() {

	}

	protected void tearDown() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "DELETE FROM basicFrame";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}

	}

	public void insertBasicFrame() {
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('A','14~26','1~8')";
			st.execute(sql);
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('B','13~26','1~8')";
			st.execute(sql);
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('C','12~26','1~8')";
			st.execute(sql);
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('D','11~26','1~8')";
			st.execute(sql);
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('E','10~26','1~8')";
			st.execute(sql);
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('F','9~26','1~8')";
			st.execute(sql);
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('G','8~26','1~8')";
			st.execute(sql);
			sql = "INSERT INTO basicFrame (type,credit,period) VALUES ('L','7~26','1~8')";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}
	}

	public void testPublishBasicFrame_1() {
		insertBasicFrame();
		boolean admit = BasicFrameManagement.publishBasicFrame(getBasicFrame());
		assertFalse(admit);
	}

	public void testPublishBasicFrame_2() {
		boolean admit = BasicFrameManagement.publishBasicFrame(getBasicFrame());
		assertTrue(admit);
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT period FROM basicFrame WHERE type='A'";
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

		boolean admit=BasicFrameManagement.modifyBasicFrame(getBasicFrame());
		assertFalse(admit);
	}
	
	public void testModifyBasicFrame_2() {
		insertBasicFrame();
		boolean admit=BasicFrameManagement.modifyBasicFrame(getBasicFrame());
		assertTrue(admit);
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT credit FROM basicFrame WHERE type='L'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			String credit = res.getString("credit");
			assertEquals(credit, "2~5");
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
	}

	public void testGetBasicFrame_1(){
		BasicFrame bf=BasicFrameManagement.getBasicFrame();
		assertFalse(bf.iterator().hasNext());
	}
	
	public void testGetBasicFrame_2(){
		insertBasicFrame();
		BasicFrame bf=BasicFrameManagement.getBasicFrame();
		assertTrue(bf.iterator().hasNext());
	}
	
	public BasicFrame getBasicFrame() {
		FrameElement fe1 = new FrameElement("A", "14~26", "1~8");
		FrameElement fe2 = new FrameElement("B", "14~26", "1~8");
		FrameElement fe3 = new FrameElement("C", "5~6", "1~2");
		FrameElement fe4 = new FrameElement("D", "14~26", "1~8");
		FrameElement fe5 = new FrameElement("E", "14~26", "1~8");
		FrameElement fe6 = new FrameElement("F", "14~26", "1~8");
		FrameElement fe7 = new FrameElement("G", "14~26", "1~4");
		FrameElement fe8 = new FrameElement("L", "2~5", "7~8");
		BasicFrame bf = new BasicFrame();
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
