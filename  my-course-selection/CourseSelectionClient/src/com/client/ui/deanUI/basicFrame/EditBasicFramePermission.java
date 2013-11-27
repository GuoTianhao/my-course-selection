package com.client.ui.deanUI.basicFrame;

import com.ui.myswing.EditPermission;

public class EditBasicFramePermission implements EditPermission{
	public boolean isEditable(int row, int column) {
		if(column==2||column==1){
			return true;
		}
		return false;
	}

}
