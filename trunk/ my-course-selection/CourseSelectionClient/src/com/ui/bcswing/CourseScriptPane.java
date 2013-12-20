package com.ui.bcswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.client.rmi.TeacherMethodController;
import com.data.po.Course;
import com.logicService.TeacherMethod;
import com.ui.myswing.MButton;
import com.ui.myswing.MFont;
import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

//教师完善课程信息框
public class CourseScriptPane extends MFrame {
	private static Dimension default_size = new Dimension(440, 450);
	private Course course;
	private TeacherMethod method = TeacherMethodController.getMethod();

	private MPanel scriptPanel;
	private MLabel outlineLb;
	private MLabel bookLb;
	private MLabel refBookLb;
	private JTextArea outlineArea;
	private JTextArea bookArea;
	private JTextArea refBookArea;
	private MButton yesBtn;
	private MButton noBtn;

	public CourseScriptPane(Point loc, Dimension size) {
		super(default_size);
		this.setLocation(new Point(loc.x + size.width / 2
				- this.getSize().width / 2, loc.y + size.height / 2
				- this.getSize().height / 2));
		createComponent();
		addListener();
	}

	public CourseScriptPane(Point loc, Dimension size, Course c) {
		this(loc, size);
		setCourse(c);
		init();
	}

	private void createComponent() {
		scriptPanel = new MPanel(new Point(0, 0), default_size);
		outlineLb = new MLabel(new Point(40, 20), new Dimension(80, 25), "课程大纲");
		outlineArea = new JTextArea();
		outlineArea.setLocation(130, 20);
		outlineArea.setSize(250, 90);
		outlineArea.setLineWrap(true);
		outlineArea.setBorder(BorderFactory.createLineBorder(new Color(71, 114, 157), 2, true));
		outlineArea.setFont(MFont.textAreaFont);
		bookLb = new MLabel(new Point(40, 130), new Dimension(80, 25), "教材");
		bookArea = new JTextArea();
		bookArea.setLocation(130, 130);
		bookArea.setSize(250, 90);
		bookArea.setLineWrap(true);
		bookArea.setBorder(BorderFactory.createLineBorder(new Color(71, 114, 157), 2, true));
		bookArea.setFont(MFont.textAreaFont);
		refBookLb = new MLabel(new Point(40, 240), new Dimension(80, 25),
				"参考书目");
		refBookArea = new JTextArea();
		refBookArea.setLocation(130, 240);
		refBookArea.setSize(250, 90);
		refBookArea.setLineWrap(true);
		refBookArea.setBorder(BorderFactory.createLineBorder(new Color(71, 114, 157), 2, true));
		refBookArea.setFont(MFont.textAreaFont);
		yesBtn = new MButton(null, null, null, new Point(170, 350),
				new Dimension(60, 25));
		yesBtn.setText("确认");
		noBtn = new MButton(null, null, null, new Point(250, 350),
				new Dimension(60, 25));
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

	private void init() {
		if (!course.getScript().equals("")) {
			String[] script = course.getScript().split(";");
			outlineArea.setText(script[0]);
			bookArea.setText(script[1]);
			refBookArea.setText(script[2]);
		}
	}

	private void setCourse(Course c) {
		course = c;

	}

	public String getScript() {
		return outlineArea.getText() + ";" + bookArea.getText() + ";"
				+ refBookArea.getText();
	}

	private void addListener() {
		yesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					method.filnCourseInfor(course.getID(), getScript());
					CourseScriptPane.this.dispose();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		noBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CourseScriptPane.this.dispose();
			}
		});

		// outlineArea.addFocusListener(new FocusAdapter() {
		// public void focusLost(FocusEvent e){
		// outlineArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1,
		// true));
		// refresh();
		// }
		// });
		//
		// bookArea.addFocusListener(new FocusAdapter() {
		// public void focusLost(FocusEvent e){
		// bookArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1,
		// true));
		// refresh();
		// }
		// });
		//
		// refBookArea.addFocusListener(new FocusAdapter() {
		// public void focusLost(FocusEvent e){
		// refBookArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1,
		// true));
		// refresh();
		// }
		// });

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int val = JOptionPane.showConfirmDialog(rootPane, "是否保存当前更改？",
						"提醒", JOptionPane.YES_NO_OPTION);
				switch (val) {
				case JOptionPane.YES_OPTION:
					try {
						method.filnCourseInfor(course.getID(), getScript());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case JOptionPane.NO_OPTION:
					break;
				default:
					break;
				}
			}
		});
	}

}
