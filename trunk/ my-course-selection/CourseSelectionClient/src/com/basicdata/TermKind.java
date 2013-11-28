package com.basicdata;

import java.util.HashMap;
import java.util.Map;

public class TermKind {
	private static String[] term = { "大一上学期", "大一下学期", "大二上学期", "大二下学期",
			"大三上学期", "大三下学期", "大四上学期", "大四下学期" };
	private static Map<String, String> nameToTerm;
	private static Map<String, String> termToName;
	private static boolean state = false;

	private static void init() {
		nameToTerm = new HashMap<>();
		termToName = new HashMap<>();
		for (int i = 0; i < term.length; i++) {
			nameToTerm.put(term[i], String.valueOf(i+1));
			termToName.put(String.valueOf(i+1) + "", term[i]);
		}
		state = true;
	}

	public static int getTerm(String name) {
		if (!state) {
			init();
		}
		return Integer.parseInt(nameToTerm.get(name));
	}

	public static String getName(String term) {
		if (!state) {
			init();
		}
		return termToName.get(term);
	}

	public static String[] getAllTerm() {
		return term;
	}
}
