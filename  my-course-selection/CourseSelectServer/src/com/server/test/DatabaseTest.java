package com.server.test;

import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;
import com.data.dataImpl.method.DatabaseDivide;
import com.logic.dataController.DatabaseController;

import junit.framework.TestCase;

public class DatabaseTest extends TestCase{
	public void setUp(){
		
	}
//	public void testSearch(){
//		System.out.println((Database.search("course","ID","0003","Loc")).get(0));
//	}
//	public void testUpdate(){
//		System.out.println(Database.update("course","ID","0003","Loc","仙"));
//	}
//	public void testInsert(){
//		List ID=new ArrayList<String>();
//		List time=new ArrayList<String>();
//		ID.add("ID");
//		ID.add("Time");
//		time.add("0002");
//		time.add("2_5_6");
//		
//		System.out.println(Database.insert("courseTime",ID,time));
//	}
	public void testDelete(){
		System.out.println(DatabaseController.getMethod().delete("courseTime","ID","0001"));
	}
//	public void testDivide(){
//		List list=new ArrayList<String>();
//		list.add("time");
//		DatabaseDivide.divide("courseTime","time",list,"ID");
//	}
}
