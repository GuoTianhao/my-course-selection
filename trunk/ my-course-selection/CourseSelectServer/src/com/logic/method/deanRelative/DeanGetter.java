package com.logic.method.deanRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Dean;
import com.logic.dataController.DeanDataController;

public class DeanGetter {
	public static Dean getDean(String ID) {
		List<Dean> list = new ArrayList<Dean>();
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		List<String> aimName = new ArrayList<String>();
		clueName.add("ID");
		clue.add(ID);
		aimName.add("ID");
		aimName.add("Name");
		List<ArrayList<String>> res = DeanDataController.getMethod()
				.search("dean", clueName, clue, aimName);
		Iterator<ArrayList<String>> it = res.iterator();
		while (it.hasNext()) {
			List<String> innerList = it.next();
			Iterator<String> inIt = innerList.iterator();
			Dean d = new Dean((String) (inIt.next()), (String) (inIt.next()));
			list.add(d);

		}
		return list.get(0);
	}
}
