package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.dataImpl.method.DatabaseDelete;
import com.data.dataImpl.method.DatabaseInsert;
import com.data.dataImpl.method.DatabaseSearch;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class DatabaseSearchTest extends TestCase {
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

	public void testSearch_1() {
		List<String> name=DatabaseSearch.search("student", "ID", "300000000","Name");
		assertTrue(name.contains("测试学生1"));	
	}

	public void testSearch_2() {
		List<String> id=DatabaseSearch.search("student", "Name", "测试学生1","ID");
		assertTrue(id.contains("300000000"));
	}

	public void testSearch_3() {
		List<String> name=DatabaseSearch.search("student", "Grade", "2010","ID");
		assertTrue(name.contains("300000000"));
	}
	
	public void testSearch_4() {
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		List<String> aimName=new ArrayList<String>();
		clueName.add("Faculty");
		clueName.add("Grade");
		clueName.add("Name");
		clue.add("1025");
		clue.add("2010");
		clue.add("测试学生1");
		aimName.add("ID");
		List<ArrayList<String>> id=DatabaseSearch.search("student", clueName, clue,aimName);
		List<String> idList=new ArrayList<String>();
		Iterator<ArrayList<String>> it=id.iterator();
		while(it.hasNext()){
			idList.add(it.next().get(0));
		}
		assertTrue(idList.contains("300000000"));
	}
	
}
