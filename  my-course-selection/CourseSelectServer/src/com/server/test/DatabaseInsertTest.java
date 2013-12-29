package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.dataImpl.method.DatabaseDelete;
import com.data.dataImpl.method.DatabaseInsert;
import com.data.dataImpl.method.DatabaseSearch;

public class DatabaseInsertTest extends TestCase {
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
	
	public void testInsert(){
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Faculty");
		clueName.add("Grade");
		clueName.add("Name");
		clue.add("300000000");
		clue.add("1025");
		clue.add("2010");
		clue.add("测试学生1");
		DatabaseInsert.insert("student", clueName, clue);
		
		List<String> res=DatabaseSearch.search("student", "ID", "300000000", "Name");
		assertEquals(res.get(0),"测试名字");
		
		res=DatabaseSearch.search("student", "ID", "300000000", "Faculty");
		assertEquals(res.get(0),"1025");
		
		res=DatabaseSearch.search("student", "ID", "300000000", "Grade");
		assertEquals(res.get(0),"2010");
		
	}
}
