package com.ui.bcswing;

import java.util.Observable;

public class MObservable extends Observable {
	public synchronized void setChanged() {
		super.setChanged();
	}
	public synchronized void clearChanged() {
		super.clearChanged();
	}
}
