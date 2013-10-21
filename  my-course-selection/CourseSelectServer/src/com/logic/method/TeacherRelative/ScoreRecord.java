package com.logic.method.TeacherRelative;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.logic.dataController.TeacherDataController;

public class ScoreRecord {
	public static void recordScore(String cID, Map score) {
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		clueName.add("cID");
		clueName.add("sID");
		clueName.add("score");
		clue.add(cID);
		Set<String> sIDList = score.keySet();
		TeacherDataController.getMethod().delete("courseScore", "cID", cID);
		for (String sID : sIDList) {
			clue.add(sID);
			clue.add((String) score.get(sID));
			TeacherDataController.getMethod().insert("courseScore", clueName,
					clue);
			clue.remove(2);
			clue.remove(1);
		}
	}
}
