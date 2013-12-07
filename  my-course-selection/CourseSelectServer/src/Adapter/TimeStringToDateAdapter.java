package Adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class TimeStringToDateAdapter {
	public static Date adapter(String time){
		DateFormat format=DateFormat.getDateTimeInstance();
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
