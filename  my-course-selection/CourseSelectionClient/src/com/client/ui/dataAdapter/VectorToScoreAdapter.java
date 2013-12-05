package com.client.ui.dataAdapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class VectorToScoreAdapter {
	public static Map adapter(Vector v){
		Map map=new HashMap();
		Iterator<Vector> it=v.iterator();
		while(it.hasNext()){
			Vector row=it.next();
			map.put(row.get(0), row.get(4));
		}
		return map;
	}
}
