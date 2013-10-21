package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;

public class DatabaseDelete {
	public static boolean delete(String tableName,String clueName,String clue){
		boolean correct;
		Connection conn;
		Statement st;
		try{
			conn=DatabaseConnection.getConnection();
			st=conn.createStatement();
			String sql;
			sql="DELETE FROM "+tableName+" WHERE "+clueName+"="+"'"+clue+"'";
			st.execute(sql);
			conn.close();
			correct=true;
		}catch(Exception ex){
			System.out.println("删除失败:"+ex.getMessage());
			correct=false;
		}
		return correct;
	}
	public static boolean delete(String tableName,List<String> clueName,List<String> clue){
		boolean correct;
		Connection conn;
		Statement st;
		try{
			conn=DatabaseConnection.getConnection();
			st=conn.createStatement();
			String sql;
			sql="DELETE FROM "+tableName;
			if(clueName!=null){
				sql+=" WHERE ";
				Iterator<String> cNIt=clueName.iterator();
				Iterator<String> cIt=clue.iterator();
				while(cNIt.hasNext()){
					sql+=cNIt.next()+"="+"'"+cIt.next()+"' ";
					if(cNIt.hasNext()){
						sql+=" AND ";
					}
				}
			}
			st.execute(sql);
			conn.close();
			correct=true;
		}catch(Exception ex){
			System.out.println("删除失败:"+ex.getMessage());
			correct=false;
		}
		return correct;
	}
}
