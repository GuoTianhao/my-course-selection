package com.server.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.data.dataImpl.method.DatabaseDelete;
import com.data.dataImpl.method.DatabaseInsert;
import com.data.dataImpl.method.DatabaseSearch;

public class DatabaseInsertTest extends TestCase {
	protected void tearDown(){
		DatabaseDelete.delete("student","ID","300000000");
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
		clue.add("测试名字");
		DatabaseInsert.insert("student", clueName, clue);
		
		List<String> res=DatabaseSearch.search("student", "ID", "300000000", "Name");
		assertEquals(res.get(0),"测试名字");
		
		res=DatabaseSearch.search("student", "ID", "300000000", "Faculty");
		assertEquals(res.get(0),"1025");
		
		res=DatabaseSearch.search("student", "ID", "300000000", "Grade");
		assertEquals(res.get(0),"2010");
		
	}
}
