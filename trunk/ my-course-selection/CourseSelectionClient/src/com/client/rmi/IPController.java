package com.client.rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IPController {
	private static String ipStr;

	private static String readIP() {
		File ip = new File("resource//ip.txt");
		BufferedReader br;
		ipStr = null;
		try {
			br = new BufferedReader(new FileReader(ip));
			ipStr = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipStr;

	}

	public static String getIP() {
		if (ipStr != null) {
			return ipStr;
		} else {
			readIP();
			return ipStr;
		}

	}
}
