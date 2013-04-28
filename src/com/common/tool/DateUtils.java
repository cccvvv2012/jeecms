package com.common.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	/**
	 * 获取相加天数之后的时间
	 * 
	 * @param dateStartDate
	 * @param intDayNum
	 * @return
	 * @throws ParseException
	 */
	public static Date getAddDayDate(Date dateStartDate, int intDayNum)
			throws ParseException {
		Calendar cld = Calendar.getInstance();
		cld.setTime(dateStartDate);
		// 如要相加年使用 Calendar.YEAR
		cld.add(Calendar.DAY_OF_YEAR, intDayNum);
		return cld.getTime();
	}

	/**
	 * 获取相加分钟之后的时间
	 * 
	 * @param dateStartDate
	 * @param intMinute
	 * @return
	 * @throws ParseException
	 */
	public static Date getAddMinuteDate(Date dateStartDate, int intMinute)
			throws ParseException {
		Calendar cld = Calendar.getInstance();
		cld.setTime(dateStartDate);
		// 如要相加年使用 Calendar.YEAR
		cld.add(Calendar.MINUTE, intMinute);
		return cld.getTime();
	}

	/**
	 * 获取相加月之后的时间
	 * 
	 * @param dateStartDate
	 * @param numMonth
	 * @return
	 * @throws ParseException
	 */
	public static Date getAddMonthDate(Date dateStartDate, int numMonth)
			throws ParseException {
		Calendar cld = Calendar.getInstance();
		cld.setTime(dateStartDate);
		// 如要相加年使用 Calendar.YEAR
		cld.add(Calendar.MONTH, numMonth);
		return cld.getTime();
	}

	/**
	 * 获取相加秒之后的时间
	 * 
	 * @param dateStartDate
	 * @param intSecond
	 * @return
	 * @throws ParseException
	 */
	public static Date getAddSecondDate(Date dateStartDate, int intSecond)
			throws ParseException {
		Calendar cld = Calendar.getInstance();
		cld.setTime(dateStartDate);
		// 如要相加年使用 Calendar.YEAR
		cld.add(Calendar.SECOND, intSecond);
		return cld.getTime();
	}

	/**
	 * 返回时间字符串 yyyy-MM-dd HH:mm:ss 类型
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getDateAll(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dateTime).toString();
	}

	/**
	 * 返回时间字符串 HH:mm:ss 类型
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getDateHMS(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(dateTime).toString();
	}

	/**
	 * 返回时间字符串 yyyy年MM月dd日 类型
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getDateNYR(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(dateTime).toString();
	}

	/**
	 * 返回时间字符串 yyyy年MM月dd日 HH时mm分 类型
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getDateNYRSF(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		return sdf.format(dateTime).toString();
	}

	/**
	 * 将时间转换为特定格式字符串
	 * 
	 * @param date
	 * @param intStyle
	 * @return
	 */
	public static String getDateToStr(Date date, int intStyle) {
		SimpleDateFormat sdf = null;
		switch (intStyle) {
		case 1:
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			break;
		case 2:
			sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			break;
		case 3:
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			break;
		case 4:
			sdf = new SimpleDateFormat("yyyy年MM月dd日");
			break;
		default:
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			break;
		}
		return sdf.format(date).toString();
	}

	/**
	 * 返回时间字符串 yyyy-MM类型
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getDateYM(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(dateTime).toString();
	}

	/**
	 * 返回时间字符串 yyyy-MM-dd 类型
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getDateYMD(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dateTime).toString();
	}

	/**
	 * 获得指定时间的日
	 * 
	 * @param dateTime
	 * @return
	 */
	public static int getDay(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return Integer.parseInt(sdf.format(dateTime).toString());
	}

	/**
	 * 获得指定日期在当周是第几天
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static int getDayOfWeek(Date dateTime) throws ParseException {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateTime);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获得当前日的下拉列表
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static String getDaySelectOption(Date dateTime)
			throws ParseException {
		String Content = "";
		String m;
		int intDay = getDay(dateTime);
		for (int i = 1; i <= getMonthDay(dateTime); i++) {
			m = i < 10 ? ("0" + i) : Integer.toString(i);
			if (i == intDay) {
				Content += "<option value='" + m + "' selected>" + m
						+ "日</option>\n";
			} else {
				Content += "<option value='" + m + "'>" + m + "日</option>\n";
			}
		}
		return Content;
	}

	/**
	 * 获取两个时间之间的日差
	 * 
	 * @param dateStartDate
	 * @param dateEndDate
	 * @return
	 * @throws ParseException
	 */
	public static int getDiffDay(Date dateStartDate, Date dateEndDate)
			throws ParseException {
		return (int) ((dateEndDate.getTime() - dateStartDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 根据类型返回不同类型的第一天
	 * 
	 * @param strDataType
	 * @return
	 * @throws ParseException
	 */
	public static Date getFirstDayByType(String strDataType)
			throws ParseException {
		strDataType = strDataType.toLowerCase();
		if (strDataType != null && strDataType.length() > 0) {
			Date dateTemp = null;
			Date dateNow = new Date();
			if (strDataType.equals("week")) {
				dateTemp = getAddDayDate(dateNow, 2 + -1
						* getDayOfWeek(dateNow));
			} else if (strDataType.equals("month")) {
				dateTemp = getStrToDate(getYear(dateNow) + "-"
						+ getMonth(dateNow) + "-1");
			} else if (strDataType.equals("year")) {
				dateTemp = getStrToDate(getYear(dateNow) + "-1-1");
			} else {
				return null;
			}
			return dateTemp;
		} else {
			return null;
		}
	}

	/**
	 * 获得指定时间的月
	 * 
	 * @param dateTime
	 * @return
	 */
	public static int getMonth(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return Integer.parseInt(sdf.format(dateTime).toString());
	}

	/**
	 * 获取当前时间所在月的天数
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthDay(Date dateTime) throws ParseException {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateTime);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获得指定时间月的下拉菜单中的option
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static String getMonthSelectOption(Date dateTime)
			throws ParseException {
		String m;
		String Content = "";
		int intMonth = getMonth(dateTime);
		for (int i = 1; i <= 12; i++) {
			m = i < 10 ? ("0" + i) : Integer.toString(i);
			if (i == intMonth) {
				Content += "<option value='" + m + "' selected>" + m
						+ "月</option>\n";
			} else {
				Content += "<option value='" + m + "'>" + m + "月</option>\n";
			}
		}
		return Content;
	}

	/**
	 * 获得当前星期数字
	 * 
	 * @param date
	 * @return
	 */
	public static int getNowWeekNum(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);

	}

	/**
	 * 获得制定时间的星期字符
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowWeekWord(Date date) {
		String strWeek = "";
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK);
		switch (intWeek) {
		case 1:
			strWeek = "星期日";
			break;
		case 2:
			strWeek = "星期一";
			break;
		case 3:
			strWeek = "星期二";
			break;
		case 4:
			strWeek = "星期三";
			break;
		case 5:
			strWeek = "星期四";
			break;
		case 6:
			strWeek = "星期五";
			break;
		case 7:
			strWeek = "星期六";
			break;
		}
		return strWeek;
	}

	/**
	 * 将字符串转换为日期类型 格式为 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date getStrToDate(String strDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d1 = null;
		if (strDate != "" && strDate != null) {
			d1 = formatter.parse(strDate + " 00:00:00");
		}
		return d1;
	}

	/**
	 * 获得指定日期在当月是第几周
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static int getWeekOfMonth(Date dateTime) throws ParseException {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateTime);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 获得指定日期在当年是第几周
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static int getWeekOfYear(Date dateTime) throws ParseException {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateTime);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获得当前周在当年中下拉菜单中的option
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static String getWeekOfYearSelectOption(Date dateTime)
			throws ParseException {
		String Content = "";
		String m;
		int intWeekofMonth = getWeekOfMonth(dateTime);
		for (int i = 1; i <= 52; i++) {
			m = i < 10 ? ("0" + i) : Integer.toString(i);
			if (i == intWeekofMonth) {
				Content += "<option value='" + m + "' selected>" + m
						+ "周</option>\n";
			} else {
				Content += "<option value='" + m + "'>" + m + "周</option>\n";
			}
		}
		return Content;
	}

	/**
	 * 获得指定时间的年
	 * 
	 * @param dateTime
	 * @return
	 */
	public static int getYear(Date dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return Integer.parseInt(sdf.format(dateTime).toString());
	}

	/**
	 * 获得当指定时间在年下拉菜单中的option
	 * 
	 * @param intYearBegein
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static String getYearSelectOption(int intYearBegein, Date dateTime)
			throws ParseException {
		String Content = "";
		int intYearEnd = getYear(dateTime);
		for (int i = intYearEnd; i >= intYearBegein; i--) {
			Content += "<option value='" + i + "'";
			if (i == intYearEnd) {
				Content += " selected";
			}
			Content += ">" + i + "年</option>\n";
		}
		return Content;
	}

}
