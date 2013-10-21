package com.dataService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface DatabaseMethod {
	public Connection getConnection();

	public List<String> search(String tableName,String clueName,String clue,String aimName);
	
	public List<ArrayList<String>> search(String tableName,List<String> clueName,List<String> clue,List<String> aimName);	 
	
	public boolean update(String tableName,String clueName,String clue,String aimName,String aim);
	
	public boolean insert(String tableName,List<String> clueName,List<String> clue);
	
	public boolean delete(String tableName,String clueName,String clue);
	
	public boolean delete(String tableName,List<String> clueName,List<String> clue);
}
