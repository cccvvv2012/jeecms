package com.common.tool;

import com.common.datatype.PaginationType;

public class PaginationUtils {

	@SuppressWarnings("unchecked")
	public static String getStrPageHTML(PaginationType pt) {
		if (pt.getStrPageTitle() == null || pt.getStrPageTitle().length != 7) {
			pt.setStrPageTitle(Constants.FEN_YE_TI_SHI);
		}
		String[] strPageTitles = pt.getStrPageTitle();
		if (pt.getIntListNum() > 0) {
			Integer intAllPageNum = 0;
			String strQueryString = "";
			if (pt.getStrQueryString() != null
					&& pt.getStrQueryString().length() > 0) {
				strQueryString = "&" + pt.getStrQueryString();
			}
			if ((pt.getIntListNum() % pt.getIntPageSize()) > 0) {
				intAllPageNum = pt.getIntListNum() / pt.getIntPageSize() + 1;
			} else {
				intAllPageNum = pt.getIntListNum() / pt.getIntPageSize();
			}
			StringBuffer strTemp = new StringBuffer("");
			String strEnd = "";
			strTemp.append("<div class=\"" + pt.getStrCSS() + "\"><b>"
					+ strPageTitles[0] + intAllPageNum + strPageTitles[1]
					+ pt.getIntListNum() + strPageTitles[2] + "</b> ");
			// 默认开始页面为1
			Integer intBeginPage = 1;
			// 默认最后页面为所有页面数
			Integer intEndPage = intAllPageNum;
			// 如果最大显示页面小于当前所有页面数 则启动自动省略分页
			if (pt.getIntMaxPage() < intAllPageNum) {
				// 如果当前页 - 最大分页数的一半 大于1 则开始页改为（当前页 - 最大分页数的一半）
				if (pt.getIntPageNum() - (pt.getIntMaxPage() / 2) > 1) {
					intBeginPage = pt.getIntPageNum()
							- (pt.getIntMaxPage() / 2);
				}
				if (pt.getIntPageNum() == 1) {
					strTemp.append(" <span class=\"disabled\">"
							+ strPageTitles[3] + "</span> ");
				} else {
					strTemp.append(" <a href=\"" + pt.getStrWorkFile()
							+ "?intPageNum=1" + strQueryString + "\">"
							+ strPageTitles[3] + "</a> ");
				}
				// 如果当前页小于或等于最大页数的一般 则末页为最大页数
				if (pt.getIntPageNum() <= (pt.getIntMaxPage() / 2)) {
					intEndPage = pt.getIntMaxPage() + 1;
				} else if (intAllPageNum - pt.getIntPageNum() <= (pt
						.getIntMaxPage() / 2)) {
					intBeginPage = intAllPageNum - pt.getIntMaxPage();
				} else if (pt.getIntPageNum() + (pt.getIntMaxPage() / 2) < intAllPageNum) {
					// 如果当前页 + 最大分页数的一半 小于当前所有页面数 则结束页改为（如果当前页 + 最大分页数的一半）
					intEndPage = pt.getIntPageNum() + (pt.getIntMaxPage() / 2);
				}
				if (pt.getIntPageNum().equals(intAllPageNum)) {
					strEnd = " <span class=\"disabled\">" + strPageTitles[6]
							+ "</span> ";
				} else {
					strEnd = " <a href=\"" + pt.getStrWorkFile()
							+ "?intPageNum=" + intAllPageNum + strQueryString
							+ "\">" + strPageTitles[6] + "</a> ";
				}
			}
			if (pt.getIntPageNum() == 1) {
				strTemp.append(" <span class=\"disabled\">" + strPageTitles[4]
						+ "</span> ");
			} else {
				strTemp.append(" <a href=\"" + pt.getStrWorkFile()
						+ "?intPageNum="
						+ String.valueOf(pt.getIntPageNum() - 1)
						+ strQueryString + "\">" + strPageTitles[4] + "</a> ");
			}
			for (Integer i = intBeginPage; i <= intEndPage; i++) {
				if (i.equals(pt.getIntPageNum())) {
					strTemp
							.append(" <span class=\"current\">" + i
									+ "</span> ");
				} else {
					strTemp.append(" <a href=\"" + pt.getStrWorkFile()
							+ "?intPageNum=" + i + strQueryString + "\">" + i
							+ "</a> ");
				}
			}
			if (pt.getIntPageNum().equals(intAllPageNum) || intAllPageNum == 0) {
				strTemp.append(" <span class=\"disabled\">" + strPageTitles[5]
						+ "</span> ");
			} else {
				strTemp.append(" <a href=\"" + pt.getStrWorkFile()
						+ "?intPageNum="
						+ String.valueOf(pt.getIntPageNum() + 1)
						+ strQueryString + "\">" + strPageTitles[5] + "</a> ");
			}
			strTemp.append(strEnd);
			strTemp.append("</div>");
			return strTemp.toString();
		} else {
			return "";
		}

	}
}