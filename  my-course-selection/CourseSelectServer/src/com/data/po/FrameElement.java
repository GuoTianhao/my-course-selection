package com.data.po;

import java.io.Serializable;

public class FrameElement implements Serializable{
	private String type="";
	private String credit="";
	private String period="";
	public FrameElement(String type,String credit,String period){
		this.setType(type);
		this.setCredit(credit);
		this.setPeriod(period);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type!=null){
			this.type = type;	
		}
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		if(credit!=null){
			this.credit = credit;	
		}
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		if(period!=null){
			this.period = period;	
		}
	}
}
