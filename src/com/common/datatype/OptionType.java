package com.common.datatype;

public class OptionType {

	private String strOptionName;

	private Integer intOptionNum;

	public OptionType(String strOptionName, Integer intOptionNum) {
		super();
		this.strOptionName = strOptionName;
		this.intOptionNum = intOptionNum;
	}

	public Integer getIntOptionNum() {
		return intOptionNum;
	}

	public String getStrOptionName() {
		return strOptionName;
	}

	public void setIntOptionNum(Integer intOptionNum) {
		this.intOptionNum = intOptionNum;
	}

	public void setStrOptionName(String strOptionName) {
		this.strOptionName = strOptionName;
	}

}
