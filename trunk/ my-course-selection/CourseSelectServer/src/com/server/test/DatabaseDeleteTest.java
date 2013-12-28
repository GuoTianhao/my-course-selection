package com.server.test;

import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.method.DatabaseDelete;
import com.data.dataImpl.method.DatabaseInsert;
import com.data.dataImpl.method.DatabaseSearch;

import junit.framework.TestCase;

public class DatabaseDeleteTest extends TestCase{
	protected void setUp(){
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Faculty");
		clueName.add("Grade");
		clueName.add("Name");
		clue.add("300000000");
		clue.add("1025");
		clue.add("2010");
		clue.add("测试名字");
		DatabaseInsert.insert("student", clueName, clue);
	}
	
	public void testDelete(){
		assertTrue(DatabaseDelete.delete("student","ID","300000000"));
		List<String> res=DatabaseSearch.search("student", "ID", "300000000", "Name");
		assertEquals(res.size(),0);
	}
	
	public void testDelete_2(){
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Name");
		clue.add("300000000");
		clue.add("测试名字");
		assertTrue(DatabaseDelete.delete("student",clueName,clue));
		List<String> res=DatabaseSearch.search("student", "ID", "300000000", "Name");
		assertEquals(res.size(),0);
	}
}
