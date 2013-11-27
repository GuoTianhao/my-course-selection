package com.client.ui.teacherUI.CourseMagagement;

import com.ui.myswing.EditPermission;

public class EditScorePermission implements EditPermission{

	public boolean isEditable(int row, int column) {
		if(column==4){
			return true;
		}
		return false;
	}

}
