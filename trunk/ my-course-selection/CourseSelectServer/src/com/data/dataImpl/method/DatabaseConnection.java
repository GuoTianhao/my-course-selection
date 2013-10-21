package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306"
					+ "/CourseSelect?useUnicode=true&characterEncoding=utf8","lancer","hanxvdove520");
		}catch(Exception ex){
			System.out.println("数据库链接失败");
			ex.printStackTrace();
		}
		return con;
	}

}
