package com.logic.method.userRelative;


import com.logic.dataController.DatabaseController;

public class PasswordChange {
	public static boolean changePassword(String ID, String originalPassword,
			String password, String type) {
		boolean correct;
		correct = Login.login(ID, originalPassword, type);
		if (correct) {
			DatabaseController.getMethod().update(type, "ID", ID,
					"Password", password);
			return true;
		} else {
			return false;
		}
	}

	public static boolean deanChangePassword(String ID,
			String originalPassword, String password) {
		return changePassword(ID, originalPassword, password,
				"deanPassword");
	}

	public static boolean facultyDeanChangePassword(String ID,
			String originalPassword, String password) {
		return changePassword(ID, originalPassword, password,
				"facultyPassword");
	}

	public static boolean teacherChangePassword(String ID,
			String originalPassword, String password) {
		return changePassword(ID, originalPassword, password,
				"teacherPassword");
	}

	public static boolean studentChangePassword(String ID,
			String originalPassword, String password) {
		return changePassword(ID, originalPassword, password,
				"studentPassword");
	}
}
