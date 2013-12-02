package Adapter;

public class IntegerToStringAdapter {
	public static String convert(int num) {
		String res = null;
		if (num/10==0) {
			res = "000"+num;
		}else if (num/100==0) {
			res = "00"+num;
		}else if (num/1000==0) {
			res = "0"+num;
		}else {
			res = String.valueOf(num);
		}
		return res;
	}

}
