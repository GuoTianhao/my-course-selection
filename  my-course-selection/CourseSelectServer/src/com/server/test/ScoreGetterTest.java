package com.server.test;

import com.logic.method.studentRelative.StudentScoreGetter;

import junit.framework.TestCase;

public class ScoreGetterTest extends TestCase{
	public void testGetScore(){
		int score=StudentScoreGetter.getScore("121250041","0001");
		System.out.println("Socre:"+score);
	}
}
