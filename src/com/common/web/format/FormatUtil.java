package com.common.web.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
	private FormatUtil(){
		
	}
	
	public static String formatDate(long time,String formatStr){
		if(formatStr==null || formatStr.trim().length()==0){
			formatStr = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat df = new SimpleDateFormat(formatStr);
		return df.format(new Date(time));
	}
	
	public static long formateDateStringToLong(String dateStr,String formatStr){
		if(formatStr==null || formatStr.trim().length()==0){
			formatStr = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat df = new SimpleDateFormat(formatStr);
		try {
			return df.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}
}
