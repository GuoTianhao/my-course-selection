package Adapter;

public class YearTermToTermAdapter {
	public static int adapter(String yearTerm,int grade){
		if(yearTerm.equals("20130")){
			return 2;
		}
		return 3;
	}
}
