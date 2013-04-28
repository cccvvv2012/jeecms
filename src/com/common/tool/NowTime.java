package com.common.tool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class NowTime {
	public static String getTime() {
		Date dates = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		String now = sdf.format(dates);
		return now;
	}

	public static String getToDay() {
		Date dates = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		String now = sdf.format(dates);
		return now;
	}
}
