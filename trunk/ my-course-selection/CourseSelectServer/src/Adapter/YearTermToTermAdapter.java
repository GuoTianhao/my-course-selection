package Adapter;

public class YearTermToTermAdapter {
	public static int adapter(String yearTerm, int grade) {
		StringBuilder time = new StringBuilder(yearTerm);
		StringBuilder nowTime = new StringBuilder(
				GradeToYearTermAdapter.adapter(grade));
//		StringBuilder nowTime = new StringBuilder("20130");
		int year = Integer.parseInt(time.substring(0, 4).toString());//grade
		int term = time.charAt(4);//grade to term
		int nowYear = Integer.parseInt(nowTime.substring(0, 4).toString());
		int nowTerm = nowTime.charAt(4);//now year to term
		// 20120,20130-3-减2,20141-减3,20140
		// 20131-2,20130,20140-5
		return GradeToTermAdapter.adapter(grade) - ((nowYear - year) * 2 + term - nowTerm);
	}
	
	public static void main(String[] args) {
		System.out.println(adapter("20140", 2011));
	}

}
