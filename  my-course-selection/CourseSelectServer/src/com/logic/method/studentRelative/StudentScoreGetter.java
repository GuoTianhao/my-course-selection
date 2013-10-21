package com.logic.method.studentRelative;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;
import com.logic.dataController.StudentDataController;

public class StudentScoreGetter {
	public static int getScore(String ID, String cID) {
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		List<String> aimName = new ArrayList<String>();
		clueName.add("cID");
		clueName.add("sID");
		clue.add(cID);
		clue.add(ID);
		aimName.add("score");
		List<ArrayList<String>> list = StudentDataController.getMethod()
				.search("courseScore", clueName, clue, aimName);
		int score = -1;
		if (list.size() != 0) {
			List<String> l = list.get(0);
			score = Integer.parseInt(l.get(0));

		}
		return score;
	}
}
