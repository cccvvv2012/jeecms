package com.common.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaginationType<T> {

	private String strJPQL; // jpql语句

	private String strWorkFile; // 调用的页面

	private Integer intPageNum; // 当前页数

	private Integer intBeginNum; // 当前开始记录数

	private Integer intPageSize; // 单页显示条数

	private Integer intListNum; // 总记录数

	private String strCSS; // 显示样式

	public Map<String, String> mapQueryString = new HashMap<String, String>(); // 其他参数map

	private String strQueryString; // 其他参数

	private List<T> lsPageContent;// 当前分页的内容列表

	private String strPageHTML;// 当前分类代码；

	private String strOrderBy;// 排序依据

	private Boolean isAsc;// 是否正序

	private Integer intMaxPage;// 最大显示分页数量

	private String[] strPageTitle; // 分页提示信息

	private Object[] objJPQL;// 查询参数对象

	public PaginationType() {

	}

	public PaginationType(String strJPQL, Integer intPageNum,
			Integer intPageSize, String strOrderBy, Boolean isAsc,
			Object[] objJPQL) {
		super();
		this.strJPQL = strJPQL;
		this.intPageNum = intPageNum;
		this.intPageSize = intPageSize;
		this.strOrderBy = strOrderBy;
		this.isAsc = isAsc;
		this.objJPQL = objJPQL;
	}

	public PaginationType(String strJPQL, String strWorkFile,
			Integer intPageNum, Integer intPageSize, String strCSS,
			String strQueryString, String strOrderBy, Boolean isAsc,
			Object[] objJPQL) {
		super();
		this.strJPQL = strJPQL;
		this.strWorkFile = strWorkFile;
		this.intPageNum = intPageNum;
		this.intPageSize = intPageSize;
		this.strCSS = strCSS;
		this.strQueryString = strQueryString;
		this.strOrderBy = strOrderBy;
		this.isAsc = isAsc;
		this.objJPQL = objJPQL;
	}

	public void addQueryString(String strKey, Object objValue) {
		if (objValue != null && strKey != null && strKey.length() > 0
				&& objValue.toString().length() > 0) {
			this.mapQueryString.put(strKey, objValue.toString());
		}
	}

	public Integer getIntBeginNum() {
		return intBeginNum;
	}

	public Integer getIntListNum() {
		return intListNum;
	}

	// 如果当前页面大小参数intMaxPage为空或小于等于0 为奇数则+1返回 否则则默认为10
	public Integer getIntMaxPage() {
		if (intMaxPage == null || intMaxPage <= 0)
			// 如果为空则返回默认10
			return 10;
		else if (intMaxPage % 2 == 1)
			// 如果为奇数则 +1 返回
			return intMaxPage + 1;
		else
			return intMaxPage;
	}

	// 如果当前页参数intPageNum为空或小于等于0 则默认为1
	public Integer getIntPageNum() {
		if (intBeginNum != null && intBeginNum >= 0) {
			return (intBeginNum / intPageSize + 1);
		} else {
			if (intPageNum == null || intPageNum <= 0)
				return 1;
			else
				return intPageNum;
		}
	}

	// 如果当前页面大小参数intPageSize为空或小于等于0 则默认为30
	public Integer getIntPageSize() {
		if (intPageSize == null || intPageSize <= 0)
			return 30;
		else
			return intPageSize;
	}

	public Boolean getIsAsc() {
		return isAsc;
	}

	public List<T> getLsPageContent() {
		return lsPageContent;
	}

	public Map<String, String> getMapQueryString() {
		return mapQueryString;
	}

	public Object[] getObjJPQL() {
		return objJPQL;
	}

	// 如果样式表参数strCSS为空或长度等于0 则默认为 strCSS
	public String getStrCSS() {
		if (strCSS == null || strCSS.length() == 0)
			return "manu";
		else
			return strCSS;
	}

	public String getStrJPQL() {
		return strJPQL;
	}

	public String getStrOrderBy() {
		return strOrderBy;
	}

	public String getStrPageHTML() {
		return strPageHTML;
	}

	public String[] getStrPageTitle() {
		return strPageTitle;
	}

	public String getStrQueryString() {
		StringBuffer strTemp = new StringBuffer("");
		if (mapQueryString.size() > 0) {
			strTemp.append("?");
			for (Map.Entry<String, String> entry : mapQueryString.entrySet()) {
				strTemp.append("&").append(entry.getKey()).append("=").append(
						entry.getValue());
			}
			return strTemp.toString().replace("?&", "");
		} else {
			return null;
		}
	}

	public String getStrWorkFile() {
		if (this.strWorkFile == null) {
			this.strWorkFile = "";
		}
		return strWorkFile;
	}

	public void setIntBeginNum(Integer intBeginNum) {
		this.intBeginNum = intBeginNum;
	}

	public void setIntListNum(Integer intListNum) {
		this.intListNum = intListNum;
	}

	public void setIntMaxPage(Integer intMaxPage) {
		this.intMaxPage = intMaxPage;
	}

	public void setIntPageNum(Integer intPageNum) {
		this.intPageNum = intPageNum;
	}

	public void setIntPageSize(Integer intPageSize) {
		this.intPageSize = intPageSize;
	}

	public void setIsAsc(Boolean isAsc) {
		this.isAsc = isAsc;
	}

	public void setLsPageContent(List<T> lsPageContent) {
		this.lsPageContent = lsPageContent;
	}

	public void setMapQueryString(Map<String, String> mapQueryString) {
		this.mapQueryString = mapQueryString;
	}

	public void setObjJPQL(Object[] objJPQL) {
		this.objJPQL = objJPQL;
	}

	public void setStrCSS(String strCSS) {
		this.strCSS = strCSS;
	}

	public void setStrJPQL(String strJPQL) {
		this.strJPQL = strJPQL;
	}

	public void setStrOrderBy(String strOrderBy) {
		this.strOrderBy = strOrderBy;
	}

	public void setStrPageHTML(String strPageHTML) {
		this.strPageHTML = strPageHTML;
	}

	public void setStrPageTitle(String[] strPageTitle) {
		this.strPageTitle = strPageTitle;
	}

	public void setStrQueryString(String strQueryString) {
		this.strQueryString = strQueryString;
	}

	public void setStrWorkFile(String strWorkFile) {
		this.strWorkFile = strWorkFile;
	}
}
