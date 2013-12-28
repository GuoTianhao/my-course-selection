package com.server.start;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ServerStart {
	public static void main(String[] args) {
		TimeInit.init();
		RmiInit.init();

		UI();
	}

	private static void UI() {
		JFrame f = new JFrame();
		JLabel l = new JLabel();
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setVerticalAlignment(JLabel.CENTER);
		f.add(l);
		f.setVisible(true);
		f.setSize(200, 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		try {
			f.setTitle("Server");
			l.setText("IP:"+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
