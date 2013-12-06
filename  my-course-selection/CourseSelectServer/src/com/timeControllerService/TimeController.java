package com.timeControllerService;

public interface TimeController {
	//判断是否可以发布课程
	public boolean isTimeForPublishCourse();
	
	//判断是否可以选课
	public boolean isTimeForSelectCourse();
	
	//判断是否系统开始根据算法筛选课程时间
	public boolean isTimeForSystemSelect();
	
	//是否可以退选
	public boolean isTimeForQuitCourse();
}
