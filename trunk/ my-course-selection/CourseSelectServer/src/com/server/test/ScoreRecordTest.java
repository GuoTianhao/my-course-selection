package com.server.test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.logic.method.TeacherRelative.ScoreRecord;

public class ScoreRecordTest extends TestCase{
	public void testScoreRecord(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("121250041","99");
		map.put("121250011","98");
		ScoreRecord.recordScore("0001",map);
	}
}
