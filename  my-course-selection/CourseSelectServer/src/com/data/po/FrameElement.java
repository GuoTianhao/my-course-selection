package com.data.po;

public class FrameElement{
	private String type=null;
	private String credit=null;
	private String period=null;
	public FrameElement(String type,String credit,String period){
		this.setType(type);
		this.setCredit(credit);
		this.setPeriod(period);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
}
