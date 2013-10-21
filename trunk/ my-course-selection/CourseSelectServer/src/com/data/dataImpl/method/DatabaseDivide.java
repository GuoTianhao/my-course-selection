package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;

public class DatabaseDivide {
	public static List divide(String divisor,String dividend,List common,String aimName){
		boolean correct;
		Connection conn;
		List list=new ArrayList<Object>();
		Statement st;
		try{
			conn=DatabaseConnection.getConnection();
			st=conn.createStatement();
			String sql;
			sql="SELECT DISTINCT "+aimName+" FROM "+divisor+" d WHERE NOT EXISTS( SELECT * FROM "+dividend+" x WHERE NOT EXISTS ";
			sql+="(SELECT * FROM "+divisor+" d2 WHERE d."+aimName+"=d2."+aimName;
			Iterator it=common.iterator();
			while(it.hasNext()){
				String colunm;
				colunm=(String) it.next();
				sql+=" AND d2."+colunm+"="+"x."+colunm;
			}
			sql+="))";
			ResultSet res=st.executeQuery(sql);
			while(res.next()){
				list.add(res.getObject("aimName"));
			}
			conn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
}
