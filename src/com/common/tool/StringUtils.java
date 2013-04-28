package com.common.tool;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class StringUtils {
	/* 字符串及字符串数组(装载于List中)比较器 */
	class StringArrayComparator implements Comparator {

		boolean bAscSort = true;// 升降序

		int index = 0;// 下标

		public StringArrayComparator() {
		}

		public StringArrayComparator(boolean pAscSort, int pIndex) {
			this.bAscSort = pAscSort;
			this.index = pIndex;
		}

		@Override
		public int compare(Object arg0, Object arg1) {
			if (arg0 == null)
				return -1;
			if (arg1 == null)
				return 1;

			String str1 = "";
			String str2 = "";

			if (arg0 instanceof String[] && arg1 instanceof String[]) {
				str1 = ((String[]) arg0)[index];
				str2 = ((String[]) arg1)[index];
			} else if (arg0 instanceof String && arg1 instanceof String) {
				str1 = (String) arg0;
				str2 = (String) arg1;
			}
			return bAscSort ? str1.compareTo(str2) : -str1.compareTo(str2);
		}
	}// inner class StringArrayComparator end

	/**
	 * 在参数map中的每个key的前面加上指定的前缀
	 * 
	 * @param pParam
	 *            参数map
	 * @param pPrefix
	 *            前缀
	 * @return
	 */
	public static Map addPrefixToParam(Map pParam, String pPrefix) {
		if (judgetMap(pParam)) {
			Map result = new HashMap();
			for (Iterator iter = pParam.keySet().iterator(); iter.hasNext();) {
				String paramName = (String) iter.next();
				result.put(pPrefix + paramName, transactValue(pParam.get(
						paramName).toString()));
			}
			return result;
		}
		return new HashMap();
	}

	/* 增加单引号(单字符) */
	public static String addSQM(String pValue) {
		if (!isBlankStr(pValue)) {
			return "'" + pValue + "'";
		}
		return "''";
	}

	/* 增加单引号(字符数组) */
	public static String addSQM(String[] ids) {
		if (judgeArray(ids)) {
			String result = "";
			for (int i = 0; i < ids.length; i++) {
				if (i > 0)
					result += ",";
				result += addSQM(ids[i]);
			}
			return result;
		}
		return "''";
	}

	/**
	 * 把字符串数组转换成用分割符分割的字符串.
	 * 
	 * @param pStrArray
	 *            字符串数组.
	 * @param delim
	 *            指定的分隔符.
	 * @return String
	 * @author zhouzh 2004-4-14.
	 */
	public static String constructStr(String[] pStrArray, String delim) {
		if (pStrArray == null || pStrArray.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < pStrArray.length; i++) {
			if (i != 0) {
				sb.append(delim);
			}
			sb.append(pStrArray[i]);
		}
		return sb.toString();
	}

	/**
	 * 对给定字符进行 URL 解码
	 * 
	 * @param value
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String value)
			throws UnsupportedEncodingException {
		if (isEmpty(value))
			return "";
		return java.net.URLDecoder.decode(value, null);
	}

	/**
	 * 对给定字符进行 URL 编码
	 * 
	 * @param value
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String value)
			throws UnsupportedEncodingException {
		if (isEmpty(value))
			return "";
		return java.net.URLEncoder.encode(value, null);
	}

	/**
	 * 为了能正确排序含有数字的字符串。需要将中间的数字前补０。
	 * 
	 * @param str
	 *            　形如 ABC1 ->　ABC001
	 * @param len
	 *            格式化的长度。
	 * @return String.
	 */
	public static String formatForOrder(String str, int len) {
		if (isBlankStr(str))
			return null;
		int index = -1;
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				index = i;
			} else {
				break;
			}
		}
		if (index >= 0) {
			StringBuffer sb = new StringBuffer(16);
			sb.append(str.substring(0, index));
			String sNum = str.substring(index);
			for (int i = 0; i < len - sNum.length(); i++) {
				sb.append("0");
			}
			sb.append(sNum);
			return sb.toString();
		} else {
			return str;
		}
	}

	/**
	 * 根据 Cookie 名称得到请求中的 Cookie 值, 需要事先给 _request 一个初始值; 如果 Cookie 值是 null,
	 * 则返回""
	 * 
	 * @param request
	 * @param name
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getCookieValue(HttpServletRequest request, String name)
			throws UnsupportedEncodingException {
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return "";
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals(name)) {
				// 需要对 Cookie 中的汉字进行 URL 反编码, 适用版本: Tomcat 4.0
				return decode(cookie.getValue());
				// 不需要反编码, 适用版本: JSWDK 1.0.1
				// return cookie.getValue();
			}
		}
		// A cookie may not return a null value, may return a ""
		return "";
	}

	/**
	 * 获取当前时间的字符串， 格式："yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return
	 */
	public static String getCurDateString() {
		return getDateString(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 根据格式获取字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateString(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = "";
		try {
			dateString = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 得到文件的扩展名.
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtension(String fileName) {
		if (fileName != null) {
			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1) {
				return fileName.substring(i + 1).toLowerCase();
			}
		}
		return "";
	}

	/**
	 * 通过Collection构造sql in字符串
	 * 
	 * @param c
	 * @return
	 */
	public static String getInCondition(Collection c) {
		StringBuffer sb = new StringBuffer(256);
		int flag = 0;
		if (c == null || c.isEmpty()) {
			return null;
		}
		for (Iterator it = c.iterator(); it.hasNext();) {
			flag++;
			if (flag == 1) {
				sb.append("'" + it.next() + "'");
			} else {
				sb.append(",'" + it.next() + "'");
			}
		}
		return sb.toString();
	}

	public static Integer getInteger(String str) {
		Integer intTemp = 0;
		try {
			intTemp = Integer.parseInt(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return intTemp;
	}

	/**
	 * 使用反射，将对象列表中的对象的两个属性，以键值形式存于Map中
	 * 
	 * @param pObjectList
	 *            对象列表
	 * @param pKeyMethod
	 *            获取存于键的属性的方法名称
	 * @param pValueMethod
	 *            获取存于值的属性的方法名称
	 * @return
	 */
	public static Map getMapByObjectList(List pObjectList, String pKeyMethod,
			String pValueMethod) {
		HashMap map = new HashMap();
		if (judgetCollection(pObjectList)) {
			for (Iterator iter = pObjectList.iterator(); iter.hasNext();) {
				Object element = iter.next();
				try {
					String key = element.getClass().getMethod(pKeyMethod,
							new Class[] {}).invoke(element, new Object[0])
							.toString();
					String value = element.getClass().getMethod(pValueMethod,
							new Class[] {}).invoke(element, new Object[0])
							.toString();
					map.put(key, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	/**
	 * 取出对象列表中每个对象的主键，构造ids字符串数组
	 * 
	 * @param pObjectList
	 *            对象列表
	 * @param pMethodName
	 *            对象中的方法名称
	 * @return
	 */
	public static String[] getObjectListIds(Collection pObjectList,
			String pMethodName) {
		if (judgetCollection(pObjectList)) {
			String[] result = new String[pObjectList.size()];
			int i = 0;
			for (Iterator iter = pObjectList.iterator(); iter.hasNext();) {
				Object element = iter.next();
				try {
					result[i++] = element.getClass().getMethod(pMethodName,
							new Class[] {}).invoke(element, new Object[0])
							.toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * 得到文件的前缀名.
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getPrefix(String fileName) {
		if (fileName != null) {
			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1) {
				return fileName.substring(0, i);
			}
		}
		return "";
	}

	/**
	 * 获取随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	/* 日期变字符串（短） */
	public static String getStringDate(Date shortDate) {
		return getDateString(shortDate, "yyyy-MM-dd");
	}

	public static String getXMLString(String pAttributeName, String pValue) {
		if (isNotBlank(pValue)) {
			return "<" + pAttributeName + "><![CDATA[" + pValue + "]]></"
					+ pAttributeName + ">\n";
		}
		return "";
	}

	/**
	 * 过滤掉所有HTML代码为纯文本
	 * 
	 * @param inputString
	 * @return
	 */
	public static String html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script>]*?>[\s\S]*?<\/script>
			// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style>]*?>[\s\S]*?<\/style>
			// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;
	}

	/**
	 * 判断字符是否由startValue开头,endValue结束
	 */
	public static boolean isBetweenWith(String pValue, String startValue,
			String endValue) {
		if (pValue == null) {
			return false;
		}
		if (pValue.startsWith(startValue) && pValue.endsWith(endValue)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空. 如果字符串为null或者全为空格或者为“null”，都返回true.
	 * 
	 * @param pStr
	 *            要检查的字符串.
	 * @return boolean 值.
	 * @author luohc 2004-7-27
	 */
	public static boolean isBlankStr(String pStr) {
		return pStr == null || pStr.trim().length() == 0
				|| pStr.equalsIgnoreCase("null");
	}

	/**
	 * 判断一个字符串中是否有汉字 判断依据： 如果字符串pValue中存在值大于256的字符就认为有汉字，否
	 * 则就没有（非汉字数据的整数值不可能大于256的，因为他只有8位）
	 * 
	 * @param pValue
	 *            要检查的字符串.
	 * @return boolean
	 * @pre pValue != null
	 */
	public static boolean isChinese(String pValue) {
		for (int i = 0; i < pValue.length(); i++) {
			if (pValue.charAt(i) > 256)
				return true;
		}
		return false;
	}

	public static boolean isDouble(String str) {
		try {
			new Double(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否未空 不去除空格
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {
		if (input == null || input.length() <= 0)
			return true;
		return false;
	}

	public static boolean isEmptys(String... inputs) {
		for (int i = 0; i < inputs.length; i++) {
			if (inputs[i] == null || inputs[i].length() <= 0)
				return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否未空 去除空格
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmptyTrim(String input) {
		String strTemp = input.trim();
		if (strTemp == null || strTemp.length() <= 0)
			return true;
		return false;
	}

	/**
	 * 某字符是否存在字符串
	 */
	public static boolean isExist(String pValue, char pCh) {
		if (pValue.indexOf(pCh) != -1) {
			return true;
		}
		return false;
	}

	/**
	 * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	/**
	 * 是否负数
	 */
	public static boolean isNegative(String pValue) {
		if (pValue.startsWith("#") && pValue.lastIndexOf("#") == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否不为空。 字符串为null,或全是空格，或者是"null"，都返回false.
	 * 
	 * @param pStr
	 * @return true/false. 不为空(null, " ", "null")时返回true.
	 * @see isBlankStr(String).
	 */
	public static boolean isNotBlank(String pStr) {
		return !isBlankStr(pStr);
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (str == null | str.trim().length() <= 0) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否操作符
	 */
	public static boolean isOperator(String pValue) {
		if ("+".equals(pValue) || "-".equals(pValue) || "*".equals(pValue)
				|| "/".equals(pValue)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符是否真实数字
	 */
	public static boolean isRealNumber(String pValue) {
		try {
			new BigDecimal(pValue);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* 判断字符数组是否为空 */
	public static boolean judgeArray(String[] pArray) {
		return null != pArray && pArray.length > 0;
	}

	/* 判断集合是否为空 */
	public static boolean judgetCollection(Collection pCollection) {
		return null != pCollection && pCollection.size() > 0;
	}

	/* @Deprecated */
	public static boolean judgetMap(Map pMap) {
		return null != pMap && !pMap.isEmpty();
	}

	/* 判断字符是否为空 */
	public static boolean judgeValue(String pValue) {
		return null != pValue && !"".equals(pValue.trim())
				&& !"null".equals(pValue.trim());
		// 最后一个判断是负责除去OA是的空值
	}

	/**
	 * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
	 * 
	 * @param s
	 * @return
	 */
	public static int length(String s) {
		if (s == null)
			return 0;
		char[] c = s.toCharArray();
		int len = 0;
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i])) {
				len++;
			}
		}
		return len;
	}

	public static void main(String args[]) {
		System.out.println(3 / 2);
	}

	/**
	 * 进行unicode编码
	 * 
	 * @param s
	 * @return
	 */
	public static String NativeToAscii(String strInput) {
		StringBuffer unicode = new StringBuffer("");
		for (int j = 0; j < strInput.length(); j++) {
			String s = strInput.substring(j, j + 1);
			System.out.println(s);
			if (s.substring(0, 1).getBytes().length == 2) {
				char[] charAry = new char[s.length()];
				for (int i = 0; i < charAry.length; i++) {
					charAry[i] = s.charAt(i);
					unicode.append("\\u" + Integer.toString(charAry[i], 16));
				}
			} else {
				unicode.append(s);
			}
		}
		return unicode.toString();
	}

	/**
	 * 省略字符串，只取字符串前面length个字符加上省略号返回.
	 * 
	 * @param pStr
	 *            字符串。
	 * @param length
	 *            要保留的长度（英文字符长度，一个汉字占两个字符长度）。
	 * @return 如果pStr的长度小于length，则返回原串。
	 */
	public static String omit(String pStr, int length) {
		if (pStr == null || pStr.length() == 0 || length <= 0)
			return pStr;
		int len = 0;
		int count = 0; // 最终要返回的中英文字符个数.
		for (int i = 0; i < pStr.length(); i++) {
			char c = pStr.charAt(i);
			// 转换成英文字符长度.
			if (c > 256) {
				len += 2;
			} else {
				len += 1;
			}
			// 小于要返回的英文字符个数。
			if (len <= length) {
				count++;
			} else {
				break;
			}
		}
		if (count >= pStr.length())
			return pStr;
		// 要去掉省略号的长度(1个字符).
		String str = pStr.substring(0, count - 1);
		return str + "...";
	}

	/**
	 * 解析字符串为boolean值 yes, y, true, on, 1 都解析为true(不区分大小写)，否则解析为false
	 * 
	 * @param str
	 *            侍解析字符串
	 * @return 解析结果
	 */
	public static boolean parseBoolean(String str) {
		return ((str != null) && (str.equalsIgnoreCase("yes")
				|| str.equalsIgnoreCase("y") || str.equalsIgnoreCase("true")
				|| str.equalsIgnoreCase("on") || str.equalsIgnoreCase("1")));
	}

	/**
	 * 用指定的新字符穿代替指定的旧字符串
	 * 
	 * @param orgStr
	 *            要进行替换的字符串
	 * @param oldValue
	 *            旧字符串
	 * @param newValue
	 *            新字符串
	 * @return
	 */
	public static String replace(String orgStr, String oldValue, String newValue) {
		if (orgStr == null || orgStr.length() == 0)
			return orgStr;
		return orgStr.replaceAll(oldValue, newValue);
	}

	/**
	 * 用"<br>
	 * "替换回车符和字符'\r\n'
	 * 
	 * @param orgStr
	 *            含有回车符的字符串。
	 * @return 替换后的字符串.
	 */
	public static String replaceEnter(String orgStr) {
		if (orgStr == null || orgStr.length() == 0)
			return orgStr;
		return orgStr.replaceAll("\r\n", "<br>");
	}

	/**
	 * 用指定的字符替换回车符和字符'\r\n'
	 * 
	 * @param orgStr
	 *            含有回车符的字符串。
	 * @param value
	 *            用来代替回车的字符
	 * @return 替换后的字符串.
	 */
	public static String replaceEnter(String orgStr, String value) {
		if (orgStr == null || orgStr.length() == 0)
			return orgStr;
		return orgStr.replaceAll("\r\n", value);
	}

	/**
	 * 滤除帖子中的危险 HTML 代码, 主要是脚本代码, 滚动字幕代码以及脚本事件处理代码
	 * 
	 * @param content
	 * @return
	 */
	public static String replaceHtmlCode(String content) {
		if (isEmpty(content))
			return "";
		// 需要滤除的脚本事件关键字
		String[] eventKeywords = { "onmouseover", "onmouseout", "onmousedown",
				"onmouseup", "onmousemove", "onclick", "ondblclick",
				"onkeypress", "onkeydown", "onkeyup", "ondragstart",
				"onerrorupdate", "onhelp", "onreadystatechange", "onrowenter",
				"onrowexit", "onselectstart", "onload", "onunload",
				"onbeforeunload", "onblur", "onerror", "onfocus", "onresize",
				"onscroll", "oncontextmenu" };

		content = replaceMatchCase(content, "<script", "&ltscript", false);
		content = replaceMatchCase(content, "</script", "&lt/script", false);
		content = replaceMatchCase(content, "<marquee", "&ltmarquee", false);
		content = replaceMatchCase(content, "</marquee", "&lt/marquee", false);
		content = replaceMatchCase(content, "\r\n", "<BR>");
		// 滤除脚本事件代码
		for (int i = 0; i < eventKeywords.length; i++) {
			content = replaceMatchCase(content, eventKeywords[i], "_"
					+ eventKeywords[i], false); // 添加一个"_",
			// 使事件代码无效
		}

		return content;
	}

	/**
	 * 滤除 HTML 代码 为文本代码
	 * 
	 * @param input
	 * @return
	 */
	public static String replaceHtmlToText(String input) {
		if (isEmpty(input)) {
			return "";
		}
		return setBr(setTag(input));
	}

	/**
	 * 将字符串 source 中的 oldStr 替换为 newStr, 并以大小写敏感方式进行查找
	 * 
	 * @param source
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	public static String replaceMatchCase(String source, String oldStr,
			String newStr) {
		return replaceMatchCase(source, oldStr, newStr, true);
	}

	/**
	 * 将字符串 source 中的 oldStr 替换为 newStr, matchCase 为是否设置大小写敏感查找
	 * 
	 * @param source
	 * @param oldStr
	 * @param newStr
	 * @param matchCase
	 * @return
	 */
	public static String replaceMatchCase(String source, String oldStr,
			String newStr, boolean matchCase) {
		if (source == null)
			return null;
		// 首先检查旧字符串是否存在, 不存在就不进行替换
		if (source.toLowerCase().indexOf(oldStr.toLowerCase()) == -1) {
			return source;
		}

		int findStartPos = 0;
		int a = 0;
		while (a > -1) {
			int b = 0;
			String str1, str2, str3, str4, strA, strB;
			str1 = source;
			str2 = str1.toLowerCase();
			str3 = oldStr;
			str4 = str3.toLowerCase();
			if (matchCase) {
				strA = str1;
				strB = str3;
			} else {
				strA = str2;
				strB = str4;
			}
			a = strA.indexOf(strB, findStartPos);
			if (a > -1) {
				b = oldStr.length();
				findStartPos = a + b;
				StringBuffer bbuf = new StringBuffer(source);
				source = bbuf.replace(a, a + b, newStr) + "";
				// 新的查找开始点位于替换后的字符串的结尾
				findStartPos = findStartPos + newStr.length() - b;
			}
		}
		return source;
	}

	public static String replaceStringVar(String v, Map m) {
		for (Iterator i = m.keySet().iterator(); i.hasNext();) {
			String key = i.next().toString();
			if (v.indexOf(key) > -1) {
				v = m.get(key).toString()
						+ v.replaceAll("[$][{]" + key + "[}]", "");
			}
		}
		return v;

	}

	/**
	 * 将字符串反转输出
	 * 
	 * @param pString
	 * @return
	 */
	public static String reverse(String pString) {
		StringBuffer temp = new StringBuffer(pString);
		return temp.reverse().toString();
	}

	/**
	 * 将回车转换为 BR 代码
	 * 
	 * @param s
	 * @return
	 */
	public static String setBr(String s) {
		int j = s.length();

		StringBuffer stringbuffer = new StringBuffer(j + 500);

		for (int i = 0; i < j; i++)
			// if(s.charAt(i) == '\n' || s.charAt(i) == '\r')
			if (s.charAt(i) == '\n')
				stringbuffer.append("<br/>");
			else if (s.charAt(i) == '\r')
				stringbuffer.append("<br/>");
			else
				stringbuffer.append(s.charAt(i));

		return stringbuffer.toString();
	}

	/**
	 * 设置空格为可显示空格
	 * 
	 * @param s
	 * @return
	 */
	public static String setNbsp(String s) {
		int j = s.length();

		StringBuffer stringbuffer = new StringBuffer(j + 500);

		for (int i = 0; i < j; i++)
			if (s.charAt(i) == ' ')
				stringbuffer.append("&nbsp;");
			else
				stringbuffer.append(s.charAt(i));

		return stringbuffer.toString();
	}

	/**
	 * 滤除 HTML 标记为可显示代码
	 * 
	 * @param s
	 * @return
	 */
	public static String setTag(String s) {
		int j = s.length();

		StringBuffer stringbuffer = new StringBuffer(j + 500);

		for (int i = 0; i < j; i++)
			if (s.charAt(i) == '<')
				stringbuffer.append("&lt");
			else if (s.charAt(i) == '>')
				stringbuffer.append("&gt");
			else if (s.charAt(i) == '&')
				stringbuffer.append("&amp");
			else
				stringbuffer.append(s.charAt(i));

		return stringbuffer.toString();
	}

	/**
	 * 将心情符号修改为对应的图片 ------------- 请修改页面中相关代码!
	 * 
	 * @param temp
	 * @return
	 */
	public static String smilies(String temp) {
		if (isEmpty(temp))
			return "";
		// 判断是否有禁止表情字符的表单值
		// if( isEmpty(request("smilies")) ) {
		temp = replaceMatchCase(temp, "/:)",
				"<IMG border=0 SRC=images/brow/regular_smile.gif>");
		temp = replaceMatchCase(temp, "/:d",
				"<IMG border=0 SRC=images/brow/teeth_smile.gif>");
		temp = replaceMatchCase(temp, "/:o",
				"<IMG border=0 SRC=images/brow/omg_smile.gif>");
		temp = replaceMatchCase(temp, "/:p",
				"<IMG border=0 SRC=images/brow/tounge_smile.gif>");
		temp = replaceMatchCase(temp, "/;)",
				"<IMG border=0 SRC=images/brow/wink_smile.gif>");
		temp = replaceMatchCase(temp, "/:(",
				"<IMG border=0 SRC=images/brow/sad_smile.gif>");
		temp = replaceMatchCase(temp, "/:s",
				"<IMG border=0 SRC=images/brow/confused_smile.gif>");
		temp = replaceMatchCase(temp, "/:|",
				"<IMG border=0 SRC=images/brow/whatchutalkingabout_smile.gif>");
		temp = replaceMatchCase(temp, "/:$",
				"<IMG border=0 SRC=images/brow/embaressed_smile.gif>");
		// }
		return temp;
	}

	/**
	 * 根据指定的分割符分割字符串.
	 * 
	 * @param pStr
	 *            一特定的字符串，以某分隔符分隔.
	 * @param delim
	 *            指定的分隔符.
	 * @return List.
	 * @author luohc 2004-7-27.
	 */
	public static List splitStr(String pStr, String delim) {
		List list = new ArrayList();
		if (pStr == null || delim == null)
			return list;
		StringTokenizer st = new StringTokenizer(pStr, delim);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}

	/**
	 * 根据指定的分割符分割字符串.
	 * 
	 * @param str
	 *            一特定的字符串，以某分隔符分隔.
	 * @param delim
	 *            指定的分隔符.
	 * @return 数组。str 为 null 时返回长度为0的数组。
	 */
	public static String[] splitStr2(String str, String delim) {
		List list = splitStr(str, delim);
		if (list.isEmpty()) {
			return new String[0];
		} else {
			String[] strs = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				strs[i] = (String) list.get(i);
			}
			return strs;
		}
	}

	/**
	 * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
	 * 
	 * @param origin
	 * @param len
	 * @return
	 */
	public static String subString(String origin, int len) {
		if (origin == null || origin.equals("") || len < 1)
			return "";
		byte[] strByte = new byte[len];
		if (len > length(origin)) {
			return origin;
		}
		System.arraycopy(origin.getBytes(), 0, strByte, 0, len);
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			len = (len == 1) ? ++len : --len;
		}
		return new String(strByte, 0, len);
	}

	/**
	 * 转换由表单读取的数据的内码
	 * 
	 * @param input
	 * @return
	 */
	public static String toChi(String input) {
		try {
			byte[] bytes = input.getBytes("ISO8859-1");
			return new String(bytes);
		} catch (Exception ex) {
		}
		return null;
	}

	/**
	 * 把字符串pOriginalString转化为中文字符串（用来解决乱码问题）
	 * 
	 * @param pOriginalString
	 *            需要解码的字符串 说明：如果pOriginalString不包含乱码，则直接返回，否则进行解码处理.
	 * @return 不存在乱码的字符串
	 */
	public static String toChinese(final String pOriginalString) {
		if (pOriginalString == null) {
			return null;
		}

		if (isChinese(pOriginalString)) {
			return pOriginalString;
		}

		try {
			return new String(pOriginalString.getBytes("ISO-8859-1"), "gb2312");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String transactValue(String pValue) {
		return judgeValue(pValue) ? pValue : "";
	}

	/**
	 * 对字符串转码，用于解决中文乱码问题。
	 * 
	 * @param original
	 *            原始字符串。
	 * @param charset
	 *            字符集编码："UTF-8","ISO-8859-1","GBK","GB2312"等.
	 * @return 转码后的字符串.
	 */
	public static String transCharset(String original, String charset) {
		if (original == null)
			return null;
		StringBuffer sb = new StringBuffer(original.length() + 16);
		for (int i = 0; i < original.length(); i++) {
			char c = original.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = String.valueOf(c).getBytes(charset);
				} catch (Exception ex) {
					ex.printStackTrace();
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 去除串前后空格，若为null，转换成长度为0的串.
	 * 
	 * @param pStr
	 *            原字符串.
	 * @return 返回前后空格的字符串.
	 * @author luohc 2004-7-27
	 */
	public static String trim(String pStr) {
		return pStr == null ? "" : pStr.trim();
	}

	// 去掉所有空格
	public static String trimAllSpace(String s) {
		if (s == null)
			return null;
		return s.replaceAll(" ", "");
		/*
		 * StringBuffer result = new StringBuffer(128); for(int i=0;
		 * i<s.length(); i++){ char ch = s.charAt(i); if(ch != ' '){
		 * result.append(ch); } } return result.toString();
		 */
	}

	public static String unSplit(Object[] objs, String regx) {
		if (objs != null && objs.length > 0) {
			StringBuffer strTemp = new StringBuffer("");
			for (Object object : objs) {
				strTemp.append(regx).append(object.toString());
			}
			return strTemp.substring(1);
		} else {
			return "";
		}
	}

	public static String valueOf(Object obj) {
		return obj == null ? "" : String.valueOf(obj);
	}

	public final static String xmlEncode(String s) {
		if (s == null) {
			return null;
		}
		StringBuffer str = new StringBuffer(1024);
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			// encode standard ASCII characters into HTML entities where needed
			if (c < '\200') {
				switch (c) {
				case '&':
					str.append("&amp;");
					break;
				case '<':
					str.append("&lt;");
					break;
				case '>':
					str.append("&gt;");
					break;
				case '\'':
					str.append("&apos;");
					break;
				case '"':
					str.append("&quot;");
					break;
				default:
					str.append(c);
				}
			} else {
				str.append(c);
			}
		}
		return str.toString();
	}
}