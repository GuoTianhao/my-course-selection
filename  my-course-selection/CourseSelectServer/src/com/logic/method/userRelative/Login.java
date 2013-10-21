package com.logic.method.userRelative;

import java.util.List;

import com.logic.dataController.DatabaseController;

public class Login {
	public static boolean login(String ID, String password, String type) {
		String pas;
		List<String> list = DatabaseController.getMethod().search(type,
				"ID", ID, "Password");
		pas = (String) list.get(0);
		if (password != null) {
			if (pas.equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean deanLogin(String ID, String password) {
		return login(ID, password, "deanPassword");
	}

	public static boolean facultyDeanLogin(String ID, String password) {
		return login(ID, password, "facultyPassword");
	}

	public static boolean teacherLogin(String ID, String password) {
		return login(ID, password, "teacherPassword");
	}

	public static boolean studentLogin(String ID, String password) {
		return login(ID, password, "studentPassword");
	}

}
