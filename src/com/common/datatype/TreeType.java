package com.common.datatype;

import java.util.List;

public class TreeType {
	public Integer intID;
	public String strText;
	public List<TreeType> listChildren;
	public String strCode;

	public Integer getIntID() {
		return intID;
	}

	public List<TreeType> getListChildren() {
		return listChildren;
	}

	public String getStrCode() {
		return strCode;
	}

	public String getStrText() {
		return strText;
	}

	public void setIntID(Integer intID) {
		this.intID = intID;
	}

	public void setListChildren(List<TreeType> listChildren) {
		this.listChildren = listChildren;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	public void setStrText(String strText) {
		this.strText = strText;
	}

}
