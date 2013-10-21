package com.client.rmi;

import java.rmi.Naming;
import com.logicService.DeanMethod;

public class DeanMethodController {
	private static DeanMethod deanMethod = null;
	private static String look="rmi://127.0.0.1:6600/deanMethod";
	public static DeanMethod getDeanMethod() {
		if (deanMethod == null) {
			try {
				deanMethod = (DeanMethod) Naming
						.lookup(look);
			} catch (Exception ex) {
				System.out.println("连接失败");
				ex.printStackTrace();
			}
		}
		return deanMethod;
	}
}
