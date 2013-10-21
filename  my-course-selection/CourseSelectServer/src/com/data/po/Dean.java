package com.data.po;

import java.io.Serializable;

public class Dean implements Serializable{
	private String ID=null;
	private String name=null;
	public Dean(String ID,String name){
		this.setID(ID);
		this.setName(name);
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}
}
