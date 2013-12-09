package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseNum {
	public static int getNum(String tableName, List<String> clueName, List<String> clue){
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		int num=-1;
		try {
			String sql="SELECT COUNT(*) FROM "+tableName;
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
			st = (Statement) conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			while(res.next()){
				num=res.getInt(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取失败" + ex.getMessage());
		}
		return num;
	}
	
	public static int getNum(String tableName, String clueName, String clue){
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		int num=-1;
		try {
			String sql="SELECT COUNT(*) FROM "+tableName+" WHERE "+clueName+"="+"'"+clue+"'";
			System.out.println(sql);
			st = (Statement) conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			while(res.next()){
				num=res.getInt(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取失败" + ex.getMessage());
		}
		return num;
	}
}
