package com.common.tool;

public class JSProtect {
	/**
	 * 处理js防止恶意代码攻击.
	 * 
	 * @param js
	 *            要处理的字符串
	 * @return 处理后的字符串
	 */
	public static String doJS(String str) {
		if (str == null) {
			return str;
		}
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}
