package com.logic.method.FaucltyDeanRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;
import com.data.po.FacultyDean;
import com.logic.dataController.FacultyDeanDataController;

public class FacultyDeanGetter {
	public static FacultyDean getFacultyDean(String ID){
		List<FacultyDean> list=new ArrayList<FacultyDean>();
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		List<String> aimName=new ArrayList<String>();
		clueName.add("ID");
		clue.add(ID);
		aimName.add("ID");
		aimName.add("Name");
		aimName.add("Faculty");
		List<ArrayList<String>> res=FacultyDeanDataController.getMethod().search("facultyDean",clueName,clue,aimName);
		Iterator<ArrayList<String>> it=res.iterator();
		while(it.hasNext()){
			List<String> innerList=it.next();
			Iterator<String> inIt=innerList.iterator();
			FacultyDean d=new FacultyDean(inIt.next(),inIt.next(),inIt.next());
			list.add(d);
			
		}
		return list.get(0);
	}
}
