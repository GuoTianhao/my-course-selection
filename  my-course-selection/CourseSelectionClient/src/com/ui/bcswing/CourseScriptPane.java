package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.data.po.Course;
import com.ui.myswing.MButton;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;
import com.ui.myswing.MTextField;

//教师完善课程信息框
public class CourseScriptPane extends MFrame {
	private static Dimension default_size = new Dimension(550, 500);
	private Course course;

	private MPanel scriptPanel;
	private MLabel outlineLb;
	private MLabel bookLb;
	private MLabel refBookLb;
	private JTextArea outlineArea;
	private JTextArea bookArea;
	private JTextArea refBookArea;
	private MButton yesBtn;
	private MButton noBtn;

	public CourseScriptPane(Dimension size) {
		super(size);
		createComponent();                          
	}

	public CourseScriptPane(Course c) {
		this(default_size);
		setCourse(c);
	}

	private void createComponent() {
		scriptPanel = new MPanel(new Point(0, 0), default_size);
		outlineLb = new MLabel(new Point(20, 20), new Dimension(80, 25),
				"课程大纲");
		outlineArea = new JTextArea();
		outlineArea.setLocation(150, 20);
		outlineArea.setSize(250, 60);
		bookLb = new MLabel(new Point(20, 130), new Dimension(80, 25),
				"教材");
		bookArea = new JTextArea();
		bookArea.setLocation(150, 130);
		bookArea.setSize(250, 60);
		refBookLb = new MLabel(new Point(20, 240), new Dimension(80, 25),
				"参考书目");
		refBookArea = new JTextArea();
		refBookArea.setLocation(150, 240);
		refBookArea.setSize(250, 60);
		yesBtn = new MButton(null, null, null, new Point(120, 330), new Dimension(80, 25));
		yesBtn.setText("确认");
		noBtn = new MButton(null, null, null, new Point(250, 330), new Dimension(80, 25));
		noBtn.setText("取消");
		scriptPanel.add(outlineLb);
		scriptPanel.add(outlineArea);
		scriptPanel.add(bookLb);
		scriptPanel.add(bookArea);
		scriptPanel.add(refBookLb);
		scriptPanel.add(refBookArea);
		scriptPanel.add(yesBtn);
		scriptPanel.add(noBtn);
		this.add(scriptPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void setCourse(Course c) {
		course = c;
	}

	public String getScript() {
		return outlineArea.getText()+";"+bookArea.getText()+";"+refBookArea.getText();
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CourseScriptPane pane = new CourseScriptPane(new Course(null, null,
				null, null, 0, null, null, null, 0,3, null, null));
		
	}
}
