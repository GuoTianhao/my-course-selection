package com.logic.method.studentRelative.strategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ballot {
	public static List ballot(ArrayList l,int num){
		ArrayList clone=(ArrayList) l.clone();
		LinkedList list=new LinkedList();
		int size=l.size();
		int index;
		for(int i=0;i<num&&i<size;i++){
			index=(int)(Math.random()*(clone.size()-1));
			list.add(clone.get(index));
			clone.remove(index);
		}
		return list;
	}
}
