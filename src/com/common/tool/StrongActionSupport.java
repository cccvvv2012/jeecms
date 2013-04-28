package com.common.tool;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.common.datatype.ImageField;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StrongActionSupport extends ActionSupport implements Preparable {

	/**
	 * 继承ActionSupport增加自定义常量
	 */
	private static final long serialVersionUID = -4269468652952431862L;
	public static Logger logger = Logger.getLogger(IndexAction.class.getName());

	public static final String INDEX = "index";
	public static final String INDEX_ACTION = "indexAction";
	public static final String YICHANG = "exception";
	public static final String CUOWU = "error";
	public static final String JSXINXI = "jsmessage";
	public static final String XINXI = "message";
	public static final String TIAOZHUAN_ACTION = "tiaozhuanAction";
	public static final String TIAOZHUAN = "tiaozhuan";
	public static final String LIEBIAO = "liebiao";
	public static final String TIANJIA = "tianjia";
	public static final String XIUGAI = "xiugai";
	public static final String NEIRONG = "neirong";
	public static final String XIANSHI = "xianshi";
	public static final String XIAZAI = "xiazai";
	public static final String EXCEL = "excel";
	public static final String JAVASCRIPT = "javascript";
	public static final String JSON = "json";
	public static final String XML = "xml";

	public String template = "strong";
	public Integer intPageNum = 0;
	public Map<String, String> mapQuery = new HashMap<String, String>();
	public String strQuery;
	public String strFileName;
	public String strAction;
	public ImageField imageField;
	public String strLog = "";

	public Integer limit = 20;
	public Integer start = 0;

	public void addQueryString(String strKey, Object objValue) {
		if (objValue != null && strKey != null && strKey.length() > 0
				&& objValue.toString().length() > 0) {
			mapQuery.put(strKey, objValue.toString());
		}
	}

	public void addQueryStringPageNum() {
		if (intPageNum != null && intPageNum >= 0) {
			addQueryString("intPageNum", intPageNum);
		}
	}

	public ImageField getImageField() {
		return imageField;
	}

	public Integer getIntPageNum() {
		return intPageNum;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getStart() {
		return start;
	}

	public String getStrAction() {
		return strAction;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public String getStrQuery() {
		StringBuffer strTemp = new StringBuffer("");
		if (mapQuery.size() > 0) {
			strTemp.append("?");
			for (Map.Entry<String, String> entry : mapQuery.entrySet()) {
				strTemp.append("&").append(entry.getKey()).append("=").append(
						entry.getValue());
			}
			return strTemp.toString().replace("?&", "?");
		} else {
			return null;
		}
	}

	public String getTemplate() {
		return template;
	}

	@Override
	public void prepare() throws Exception {

	}

	public void setImageField(ImageField imageField) {
		this.imageField = imageField;
	}

	public void setIntPageNum(Integer intPageNum) {
		this.intPageNum = intPageNum;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setStrAction(String strAction) {
		this.strAction = strAction;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public void setStrQuery(String strQuery) {
		this.strQuery = strQuery;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
