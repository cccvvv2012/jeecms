package com.common.tool;

import java.util.ArrayList;
import java.util.List;

public class util {

	public static String[] mySplit(String source, String delimiter) {
		java.util.StringTokenizer st = new java.util.StringTokenizer(source,
				delimiter);
		List list = new ArrayList();
		while (st.hasMoreElements()) {
			list.add(st.nextToken().trim());
		}
		return (String[]) list.toArray(new String[0]);
	}
}
