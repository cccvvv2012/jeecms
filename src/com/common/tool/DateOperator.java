package com.common.tool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DateOperator {
	public String getAllDir() {
		DateOperator dt = new DateOperator();
		String now = dt.getNowDate();
		String yyyy = now.substring(0, 4);
		String mm = now.substring(5, 7);
		String dd = now.substring(8, 10);
		String HH = now.substring(11, 13);
		String MM = now.substring(14, 16);
		String SS = now.substring(17, 19);
		return yyyy + mm + dd + HH + MM + SS;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getAllWorkWeek() {
		ArrayList alist = new ArrayList();
		String now = getNowDate();
		for (int i = getYear(now) - 1; i <= getYear(now) + 1; i++) {
			for (int j = 1; j <= 12; j++) {
				int days = getMonthDays(i, j);
				for (int k = 1; k <= days; k++) {
					String date = i + "-" + j + "-" + k;
					String week = getWeek(date);
					if (!week.equals("������"))
						alist.add(date);
				}
			}
		}
		return alist;
	}

	public int getDay(String date) {
		int day = 0;
		if (date != null && date.trim().length() > 0) {
			try {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				Date d = fmt.parse(date);
				fmt = new SimpleDateFormat("dd");
				day = Integer.parseInt(fmt.format(d));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return day;
	}

	public String getDayDir() {
		DateOperator dt = new DateOperator();
		String now = dt.getNowDate();
		String yyyy = now.substring(0, 4);
		String mm = now.substring(5, 7);
		String dd = now.substring(8, 10);
		String HH = now.substring(11, 13);
		String MM = now.substring(14, 16);
		String SS = now.substring(17, 19);
		return HH + MM + SS;
	}

	public int getDaysByYear(int year) {
		return (year % 4 == 0 || year % 400 == 0 && year % 100 != 0) ? 366
				: 365;
	}

	public int getFirstWorkBeginDay(int year, int month) {
		int day = 0;
		int days = getMonthDays(year, month);
		for (int i = 1; i <= days; i++) {
			String week = getWeek(year + "-" + month + "-" + i);
			if (!week.equals("������")) {
				day = i;
				break;
			}
		}
		return day;
	}

	public int getFirstWorkEndDay(int year, int month) {
		int day = 0;
		int days = getMonthDays(year, month);
		for (int i = 1; i <= days; i++) {
			String week = getWeek(year + "-" + month + "-" + i);
			if (week.equals("������")) {
				day = i;
				break;
			}
		}
		return day;
	}

	public int getHour(String date) {
		int hour = 0;
		if (date != null && date.trim().length() > 0) {
			try {
				SimpleDateFormat fmt = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date d = fmt.parse(date);
				fmt = new SimpleDateFormat("HH");
				hour = Integer.parseInt(fmt.format(d));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return hour;
	}

	public int getMinute(String date) {
		int minute = 0;
		if (date != null && date.trim().length() > 0) {
			try {
				SimpleDateFormat fmt = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date d = fmt.parse(date);
				fmt = new SimpleDateFormat("mm");
				minute = Integer.parseInt(fmt.format(d));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return minute;
	}

	public int getMonth(String date) {
		int month = 0;
		if (date != null && date.trim().length() > 0) {
			try {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				Date d = fmt.parse(date);
				fmt = new SimpleDateFormat("MM");
				month = Integer.parseInt(fmt.format(d));

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return month;
	}

	public int getMonthDays(int year, int month) {
		int days = 0;
		if (month >= 1 && month <= 7) {
			if (month == 2)
				days = (getDaysByYear(year) == 366) ? 29 : 28;
			else if (month % 2 != 0)
				days = 31;
			else if (month % 2 == 0)
				days = 30;
		} else if (month >= 8 && month <= 12) {
			if (month % 2 == 0)
				days = 31;
			else if (month % 2 != 0)
				days = 30;
		}
		return days;
	}

	public String getMonthDir() {
		DateOperator dt = new DateOperator();
		String now = dt.getNowDate();
		String yyyy = now.substring(0, 4);
		String mm = now.substring(5, 7);
		String dd = now.substring(8, 10);
		String HH = now.substring(11, 13);
		String MM = now.substring(14, 16);
		String SS = now.substring(17, 19);
		return dd + HH + MM + SS;
	}

	public String getNowDate() {
		String now = "";
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			Date d = new Date();
			now = fmt.format(d);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return now;
	}

	public int getSeconds(String date) {
		int seconds = 0;
		if (date != null && date.trim().length() > 0) {
			try {
				SimpleDateFormat fmt = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date d = fmt.parse(date);
				fmt = new SimpleDateFormat("ss");
				seconds = Integer.parseInt(fmt.format(d));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return seconds;
	}

	public String getWeek(String date) {
		String week = "";
		if (date != null && date.trim().length() > 0) {
			try {
				Date d = new Date();
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				d = fmt.parse(date);
				fmt = new SimpleDateFormat("E");
				week = fmt.format(d);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return week;
	}

	public int getWeekth(String date) {
		int weekth = 0;
		int year = getYear(date), month = getMonth(date), day = getDay(date);
		String newDate = year + "-" + month + "-" + day;
		int workWeeks = getWorkWeeks(year, month);
		for (int i = 1; i <= workWeeks; i++) {
			int begin = getWorkWeekBeginDay(year, month, i);
			for (int j = begin;; j++) {
				String d = year + "-" + month + "-" + j;
				if (d.equals(newDate)) {
					weekth = i;
					break;
				}
				String week = getWeek(d);
				if (week.equals("������"))
					break;

			}
		}
		return weekth;
	}

	public int getWorkDays(int year, int month) {
		int cnt = 0;
		int days = getMonthDays(year, month);
		for (int i = days; i >= 1; i--) {
			String date = year + "-" + month + "-" + i;
			String week = getWeek(date);
			if (!week.equals("������"))
				cnt++;
		}
		return cnt;
	}

	public int getWorkWeekBeginDay(int year, int month, int weekth) {
		int day = 0;
		int weeks = getWorkWeeks(year, month);
		if (weekth >= 1 && weekth <= weeks) {
			int begin = getFirstWorkBeginDay(year, month);
			int end = getFirstWorkEndDay(year, month);
			if (weekth == 1)
				day = begin;
			else if (weekth == 2)
				day = end + 2;
			else if (weekth > 2)
				day = end + 2 + 7 * (weekth - 2);
		}
		return day;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getWorkWeekList(int year) {
		ArrayList alist = new ArrayList();
		for (int i = 1; i <= 12; i++) {
			int days = getMonthDays(year, i);
			for (int j = 1; j <= days; j++) {
				String date = year + "-" + i + "-" + j;
				if (i < 10)
					date = year + "-0" + i + "-" + i;
				if (i < 10)
					date = year + "-" + i + "-0" + i;
				if (i < 10 && j < 10)
					date = year + "-0" + i + "-0" + j;
				String week = getWeek(date);
				if (!week.equals("������"))
					alist.add(date);
			}
		}
		return alist;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getWorkWeekList(int year, int month) {
		ArrayList alist = new ArrayList();
		int days = getMonthDays(year, month);
		for (int i = 1; i <= days; i++) {
			String date = year + "-" + month + "-" + i;
			if (month < 10)
				date = year + "-0" + month + "-" + i;
			if (i < 10)
				date = year + "-" + month + "-0" + i;
			if (month < 10 && i < 10)
				date = year + "-0" + month + "-0" + i;
			String week = getWeek(date);
			if (!week.equals("������"))
				alist.add(date);
		}
		return alist;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getWorkWeekList(int year, int month, int weekth) {
		ArrayList alist = new ArrayList();
		int days = getMonthDays(year, month);
		int weeks = getWorkWeeks(year, month);
		if (weekth >= 1 && weekth <= weeks) {
			int begin = getWorkWeekBeginDay(year, month, weekth);
			for (int i = begin;; i++) {
				String date = year + "-" + month + "-" + i;
				if (month < 10)
					date = year + "-0" + month + "-" + i;
				if (i < 10)
					date = year + "-" + month + "-0" + i;
				if (month < 10 && i < 10)
					date = year + "-0" + month + "-0" + i;
				String week = getWeek(date);
				alist.add(date);
				if (week.equals("������") || i >= days)
					break;
			}
		}
		return alist;
	}

	public int getWorkWeeks(int year, int month) {
		int weeks = 0;
		int days = getMonthDays(year, month);
		String date = "", week = "";
		for (int i = 1; i <= days; i++) {
			date = year + "-" + month + "-" + i;
			week = getWeek(date);
			if (week.equals("������"))
				weeks++;
		}
		date = year + "-" + month + "-" + days;
		week = getWeek(date);
		if (!week.equals("������") && !week.equals("������"))
			weeks++;
		return weeks;
	}

	public int getYear(String date) {
		int year = 0;
		if (date != null && date.trim().length() > 0) {
			try {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				Date d = fmt.parse(date);
				fmt = new SimpleDateFormat("yyyy");
				year = Integer.parseInt(fmt.format(d));

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return year;
	}

	public String getYearDir() {
		DateOperator dt = new DateOperator();
		String now = dt.getNowDate();
		String yyyy = now.substring(0, 4);
		String mm = now.substring(5, 7);
		String dd = now.substring(8, 10);
		String HH = now.substring(11, 13);
		String MM = now.substring(14, 16);
		String SS = now.substring(17, 19);
		return mm + dd + HH + MM + SS;
	}
}
