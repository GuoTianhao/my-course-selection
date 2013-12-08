package com.logicService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.Dean;
import com.data.po.Frame;
import com.data.po.Student;
import com.data.po.Teacher;
import com.timeControllerService.TimeController;

public interface DeanMethod extends Remote,TimeController {
	// 登陆操作，传入ID（帐号）和password(密码)，当ID和password匹配return true，反之return false；
	public boolean login(String ID, String password) throws RemoteException;

	// 得到用户基本信息
	public Dean getSelf(String ID) throws RemoteException;

	// 更改密码操作，传入ID（帐号）、origninalassword（原密码）和password（现密码），若原密码正确return
	// true，若原密码错误return false。
	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException;

	// 建立整体框架，传入BasicFrame，若创建成功return true，若失败return false。
	public boolean formulateFrame(BasicFrame bf) throws RemoteException;

	// 修改整体框架，传入BasicFrame，若修改成功return true，若失败return false。
	public boolean modifyFrame(BasicFrame bf) throws RemoteException;

	// 发布课程
	public boolean publishCourse(Course c) throws RemoteException;

	// 修改课程
	public boolean modifyCourse(Course c) throws RemoteException;

	// 查看整体框架，return BasicFrame。
	public BasicFrame lookUpBasicFrame() throws RemoteException;

	// 查看院系的教学计划，传入facultyID（院系）ID，return Frame（院系教学计划）。
	public Frame lookUpFrame(String facultyID) throws RemoteException;

	// 得到全校老师列表，return List<Teacher>(一个链表)
	public List<Teacher> getAllTeacher() throws RemoteException;

	//得到老师
	public Teacher getTeacher(String id) throws RemoteException;
	
	// 得到院系老师列表，传入facultyID（院系），return List<Teacher>(一个链表)
	public List<Teacher> getFacultyTeacher(String facultyID)
			throws RemoteException;
 
	// 得到全校课程列表，return List<Course>
	public List<Course> getAllCourse() throws RemoteException;

	// 得到院系课程列表，传入falculty(院系)，return List<Course>.
	public List<Course> getFacultyCourse(String facultyID)
			throws RemoteException;

	// 分种类得到课程
	public List<Course> getTypeCourse(String type) throws RemoteException;

	// 得到自己发布的课程
	public List<Course> getMCourse() throws RemoteException;

	// 得到具体课程
	public Course getCourse(String courseID) throws RemoteException;
	
	//得到院系具体学期课程
	public List<Course> geFacultyTermCourse(String facultyID,String grade) throws RemoteException;
	
	//导入学生
	public boolean importStudent(List<Student> list) throws RemoteException;
	
	//导入老师
	public boolean importTeacher(List<Teacher> list) throws RemoteException;
}
