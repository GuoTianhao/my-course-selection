package com.ui.bcswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.basicdata.CourseTypeKind;
import com.data.po.Course;
import com.ui.myswing.MFont;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MTextField;

//显示具体的课程信息
public class CourseInforPane extends MFrame {
	private static Dimension default_size = new Dimension(260, 400);
	private Course course;

	// private MLabel namel;
	// private MLabel idl;
	// private MLabel locl;
	// private MLabel creditl;
	// private MLabel numl;
	// private MLabel typel;
	// private MLabel gradel;
	// private MLabel facultyl;
	// private MLabel periodl;
	// private MLabel timel;
	//
	// private MTextField namet;
	// private MTextField idt;
	// private MTextField loct;
	// private MTextField creditt;
	// private MTextField numt;
	// private MTextField typet;
	// private MTextField gradet;
	// private MTextField facultyt;
	// private MTextField periodt;
	// private MTextField timet;

	private JTextArea infor;

	public CourseInforPane(Dimension size) {
		super(size);
	}

	public CourseInforPane(Course c) {
		this(default_size);
		setCourse(c);
		createComponent();
		init();
	}

	private void createComponent() {
		// namel = new MLabel(new Point(0, 0), new Dimension(100, 20), "课程名称:");
		// idl = new MLabel(new Point(0, 30), new Dimension(100, 20), "课程编号:");
		// locl = new MLabel(new Point(0, 60), new Dimension(100, 20), "上课地点:");
		// creditl = new MLabel(new Point(0, 90), new Dimension(100, 20),
		// "学分:");
		// numl = new MLabel(new Point(0, 120), new Dimension(100, 20),
		// "上课人数:");
		// typel = new MLabel(new Point(0, 150), new Dimension(100, 20),
		// "课程类型:");
		// gradel = new MLabel(new Point(0, 180), new Dimension(100, 20),
		// "年级:");
		// facultyl = new MLabel(new Point(0, 210), new Dimension(100, 20),
		// "课程院系:");
		// periodl = new MLabel(new Point(0, 250), new Dimension(100, 20),
		// "上课周数:");
		// timel = new MLabel(new Point(0, 280), new Dimension(100, 20),
		// "上课时间:");
		//
		// namet = new MTextField(new Point(150, 0), new Dimension(100, 20));
		// idt = new MTextField(new Point(150, 30), new Dimension(100, 20));
		// loct = new MTextField(new Point(150, 60), new Dimension(100, 20));
		// creditt = new MTextField(new Point(150, 90), new Dimension(100, 20));
		// numt = new MTextField(new Point(150, 120), new Dimension(100, 20));
		// typet = new MTextField(new Point(150, 150), new Dimension(100, 20));
		// gradet = new MTextField(new Point(150, 180), new Dimension(100, 20));
		// facultyt = new MTextField(new Point(150, 210), new Dimension(100,
		// 20));
		// periodt = new MTextField(new Point(150, 250), new Dimension(100,
		// 20));
		// timet=new MTextField(new Point(150,290),new Dimension(60,20));
		//
		//
		// namet.setTextandBool(course.getName(),false);
		// idt.setTextandBool(course.getID(),false);
		// loct.setTextandBool(course.getLoc(),false);
		// creditt.setTextandBool(course.getCredit()+"",false);
		// numt.setTextandBool(course.getNum()+"",false);
		// typet.setTextandBool(course.getType(),false);
		// gradet.setTextandBool(course.getGrade()+"",false);
		// facultyt.setTextandBool(course.getFaculty(),false);
		// periodt.setTextandBool(course.getPeriod(),false);
		// //
		// timet.setTextandBool(course.getTime().get(0)+"  从"+course.getTime().get(1)+"到"+course.getTime().get(2),false);
		//
		//
		// this.add(namel);
		// this.add(idl);
		// this.add(locl);
		// this.add(creditl);
		// this.add(numl);
		// this.add(typel);
		// this.add(gradel);
		// this.add(facultyl);
		// this.add(periodl);
		// this.add(timel);
		//
		// this.add(namet);
		// this.add(idt);
		// this.add(loct);
		// this.add(creditt);
		// this.add(numt);
		// this.add(typet);
		// this.add(gradet);
		// this.add(facultyt);
		// this.add(periodt);
		// this.add(timet);

		infor = new JTextArea();
//		infor.setLocation(new Point(80, 50));
		infor.setSize(this.getSize().width - 20, this.getSize().height);
		infor.setEditable(false);
		infor.setLineWrap(true);
		infor.setBackground(new Color(230,230,230));
		infor.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		this.add(infor);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.refresh();
	}

	private void init() {
		infor.append("\n");

		infor.append("      课程编号：" + course.getID() + "\n");
		infor.append("\n");
		infor.append("      课程名称：" + course.getName() + "\n");
		infor.append("\n");
		infor.append("      课程类型："+CourseTypeKind.getName(course.getType())+"\n");
		infor.append("\n");
		infor.append("      上课地点："+course.getLoc()+"\n");
	}

	public void setCourse(Course c) {
		course = c;
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> time = new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		new CourseInforPane(new Course("0001", "软件工程与计算", "仙2_303", "F", 3,
				"1_17", "1250", "打造全院最好软件教育", 0, 3, time, null));
	}
}
